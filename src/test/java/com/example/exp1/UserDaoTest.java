package com.example.exp1;
import com.example.exp1.Dao.IUserDao;
import com.example.exp1.Entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    private IUserDao userdao;
    @Test
    public void CreatUser(){
        User u = new User();
        u.setAge(18);
        u.setId("100000");
        u.setName("Test");
        u.setSex(true);
        u.setPassword("12314234");
        userdao.save(u);
    }
    @Test
    public void InsertUsers(){
        List<User> uList = new ArrayList<User>();
        User u1 = new User();
        u1.setAge(18);
        u1.setId("100001");
        u1.setName("Test2");
        u1.setSex(true);
        u1.setPassword("12314234");

        User u2 = new User();
        u2.setAge(18);
        u2.setId("100002");
        u2.setName("Test3");
        u2.setSex(true);
        u2.setPassword("12314234");

        User u3 = new User();
        u3.setAge(18);
        u3.setId("100003");
        u3.setName("Test4");
        u3.setSex(true);
        u3.setPassword("12314234");
        uList.add(u1);
        uList.add(u2);
        uList.add(u3);
        userdao.saveAll(uList);
    }
    @Test
    public void FindAllUsers(){
        List<User> uList = userdao.findAll();
    }
    @Test
    public void Login(){
        User u = userdao.findUserByIdAndPassword("100000","12314234");
        System.out.println(u.getName());
    }
    @Test
    public void UpdateUserName(){
        int result=userdao.updateUserNameById("100000","Update");
        System.out.println(result);
    }
    @Test
    public void Delete(){
        int result=userdao.deleteUserById("100003");
        System.out.println(result);
    }
}
