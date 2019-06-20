package edu.mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.model.Comment;

public interface ICommentDao  extends JpaRepository<Comment, Integer>{

    public List<Comment> findByCreatedPostId(int postId);

}