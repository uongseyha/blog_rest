package edu.mum.cs544.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import edu.mum.cs544.model.Comment;
import edu.mum.cs544.service.CommentService;

@RestController
@RequestMapping("/api/users/{userId}/posts/{postId}")
public class CommentRestController {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/comments/all", produces = "application/json")
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping(value = "/comments", produces = "application/json")
    public List<Comment> getAll(@PathVariable int userId, @PathVariable int postId) {
        return commentService.getAllByUserIdAndPostId(userId, postId);
    }

    @GetMapping(value = "/comments/{id}", produces = "application/json")
    public Comment get(@PathVariable int id) {
        return commentService.get(id);
    }

    @PostMapping(value = "/comments/", consumes = "application/json")
    public RedirectView add(@RequestBody Comment comment, @PathVariable int userId, @PathVariable int postId) {
        comment.setCreatedUserId(userId);
        comment.setCreatedPostId(postId);
        comment.setCreateDate(new Date());
        int id = commentService.store(userId, postId, comment);
        return new RedirectView("/api/users/{userId}/posts/{postId}/comments/" + id);
    }

    @PutMapping(value = "/comments/{id}", consumes = "application/json")
    public RedirectView update(@RequestBody Comment comment, @PathVariable int userId, @PathVariable int postId) {
        int id = commentService.store(userId, postId, comment);
        return new RedirectView("/api/users/{userId}/posts/{postId}/comments/" + id);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable int id) {
        commentService.delete(id);
    }

}
