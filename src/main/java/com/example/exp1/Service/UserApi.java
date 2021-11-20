package com.example.exp1.Service;
import com.example.exp1.Dao.IUserDao;
import com.example.exp1.Entity.User;
import com.mysql.cj.xdevapi.JsonArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/api/User")
public class UserApi {
    @Autowired
    private IUserDao userdao;
    @PostMapping("/login1/")
    @ApiOperation("用户登录的接口1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", defaultValue = "100000", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "12314234", required = true)
    })
    public String loginByIdAndPassword(@RequestParam String id,@RequestParam String password){
        User u = userdao.findUserByIdAndPassword(id, password);
        if (u == null) {
            return "Invalid ID or Password!";
        } else {
            return "Welcome " + u.getName() + "!";
        }
    }
    @PostMapping("/login2/")
    @ApiOperation("用户登录的接口2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户的JSON数据", defaultValue = "100000", required = true),
    })
    public User loginByIdAndPassword2(@RequestBody User user){
        User u = userdao.findUserByIdAndPassword(user.getId(), user.getPassword());
        return u;
    }
    @PostMapping("/register/")
    @ApiOperation("用户注册的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", defaultValue = "100000", required = true),
            @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "Test", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "12314234", required = true),
            @ApiImplicitParam(name = "sex", value = "性别", defaultValue = "true", required = true),
            @ApiImplicitParam(name = "age", value = "年龄", defaultValue = "18", required = true)
    })
    public String registerUser(@RequestParam String id,@RequestParam String name,@RequestParam String password,@RequestParam boolean sex,@RequestParam int age){
        if(id==null){
            return "Please fill id!";
        }
        User u = new User();
        u.setPassword(password);
        u.setName(name);
        u.setSex(sex);
        u.setId(id);
        u.setAge(age);
        try {
            userdao.save(u);
        }catch (Exception e){
            return e.getMessage();
        }
        return "successfully registered!";
    }
    @PostMapping("/register2/")
    @ApiOperation("用户注册的接口2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户的JSON数据", defaultValue = "100000", required = true),
    })
    public boolean registerUser2(@RequestBody User user) {
        try {
            userdao.save(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @PostMapping("/delete/")
    @ApiOperation("删除用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", defaultValue = "100000", required = true),
    })
    public int deleteUser(@RequestParam String deleteId){
        int i=userdao.deleteUserById(deleteId);
        return i;
    }
    @PostMapping("/update/")
    @ApiOperation("修改用户信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", defaultValue = "100000", required = true),
            @ApiImplicitParam(name = "name", value = "修改后的用户名", defaultValue = "Test", required = true),
    })
    public int updateUserNameById(@RequestParam String id,@RequestParam String name){
        int i = userdao.updateUserNameById(id, name);
        return i;
    }
    @GetMapping("/getAll/")
    @ApiOperation("获取所有用户的接口")
    public List<User> getAll(){
        List<User> u = userdao.findAll();
        return u;
    }
}
