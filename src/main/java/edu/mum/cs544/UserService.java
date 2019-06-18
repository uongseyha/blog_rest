package edu.mum.cs544;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Resource
    private IUserDao userDao;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public void add(User user) {
        userDao.save(user);
    }

    public User get(Long id) {
        return userDao.findById(id).get();
        //return userDao.getOne(id);
    }

    public void update(User user) {
        userDao.save(user);
    }

    public void delete(Long id) {
        userDao.deleteById(id);
    }

    public User CheckUserAndPassword(String u, String p){
        return userDao.FindByEmailAndPassword(u,p);
    }

}
