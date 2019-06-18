package edu.mum.cs544;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User,Long> {
    @Query("select distinct u from User u where u.email= :email and u.password= :password")
    public User FindByEmailAndPassword(@Param("email") String email,@Param("password") String password);

}
