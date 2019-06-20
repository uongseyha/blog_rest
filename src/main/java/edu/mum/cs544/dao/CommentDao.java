package edu.mum.cs544.dao;// package edu.mum.cs544.dao;

// import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;
// import javax.persistence.TypedQuery;

// import org.springframework.stereotype.Repository;

// import edu.mum.cs544.model.Comment;

// @Repository
// public class CommentDao implements ICommentDao{
// 	@PersistenceContext
// 	private EntityManager em;


//     public CommentDao() {}
    
//     @Override
//     public List<Comment> getAll() {
//         TypedQuery<Comment> query =  em.createQuery("from Comment",Comment.class);
//         return query.getResultList();
//     }

//     @Override
//     public List<Comment> getAllByUserIdAndPostId(int userId, int postId) {
//         TypedQuery<Comment> query =  em.createQuery("from Comment f where f.createdPostId = :post and f.createdUserId = :user", Comment.class);
//         query.setParameter("post", postId);
//         query.setParameter("user", userId);
//         return query.getResultList();
//     }

//     @Override
//     public void add(Comment comment) {
//         em.persist(comment);
//     }

//     @Override
//     public Comment get(int id) {
//         return em.find(Comment.class, id);
//     }

//     @Override
//     public void update(Comment comment) {
//         em.merge(comment);
//     }

//     @Override
//     public void delete(int commentId) {
//         Comment comment = em.getReference(Comment.class, commentId);
//         em.remove(comment);
//     }

// }
