package service;

import org.junit.Test;
import po.User;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserService();
    @Test
    public void registorService() {
        System.out.println(userService.registorService(new User("1234","123","123")));
    }
}