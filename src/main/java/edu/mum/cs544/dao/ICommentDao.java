package edu.mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs544.model.Comment;

public interface ICommentDao  extends JpaRepository<Comment, Integer>{

    public List<Comment> findByCreatedUserIdAndCreatedPostId(int userId, int postId);

	// public abstract List<Comment> getAll();

	// public abstract List<Comment> getAllByUserIdAndPostId(int userId, int postId);

	// public abstract void add(Comment comment);

	// public abstract Comment get(int id);

	// public abstract void update(Comment comment);

	// public abstract void delete(int CommentId);

}