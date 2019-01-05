package dao;

import org.junit.Test;
import po.User;

import static org.junit.Assert.*;

public class UserDaoTest {
    User user = new User();
    User user_1 = new User("didi","dizhongdi","woshidiidi");
    UserDao userDao = new UserDao();
    @Test
    public void findByUserName() {
        System.out.println(userDao.findByUserName("root").getNickName());
    }
    @Test
    public void addUser(){
        userDao.addUser(user_1);
    }
}