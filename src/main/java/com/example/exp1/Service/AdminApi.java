package com.example.exp1.Service;
import com.example.exp1.Dao.IAdminDao;
import com.example.exp1.Entity.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "管理员管理相关接口")
@RequestMapping("/api/Admin")
public class AdminApi {
    @Autowired
    private IAdminDao admindao;
    @PostMapping("/login/")
    @ApiOperation("管理员登录的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "管理员编号", defaultValue = "100000", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "12314234", required = true)
    })
    public String loginByIdAndPassword(@RequestParam String id,@RequestParam String password){
        Admin a = admindao.findAdminByIdAndPassword(id, password);
        if (a == null) {
            return "Invalid ID or Password!";
        } else {
            return "Welcome " + a.getName() + "!";
        }
    }
    @PostMapping("/update")
    @ApiOperation("修改管理员名称的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "管理员编号", defaultValue = "100000", required = true),
            @ApiImplicitParam(name = "name", value = "修改后名称", defaultValue = "Test", required = true)
    })
    public String updateAdmin(@RequestParam String id,@RequestParam String name){
        admindao.updateAdminNameById(id,name);
        return "updated successfully.";
    }
}
