package edu.mum.cs544.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.dao.ICommentDao;
import edu.mum.cs544.model.Comment;

@Service
@Transactional
public class CommentService {
    @Resource
    private ICommentDao commentDao;

    public List<Comment> getAll(){
        return commentDao.findAll();
    }

    public List<Comment> getAllByPostId(int postId) {
        return commentDao.findByCreatedPostId(postId);
    }

    public Comment get(int id) {
        return commentDao.findById(id).get();
    }

    public int store(int userId, int postId, Comment comment) {
        comment.setCreatedPostId(postId);
        comment.setCreatedUserId(userId);
        commentDao.save(comment);
        return comment.getId();
    }

    public void delete(int id) {
        commentDao.deleteById(id);
    }
}