package com.example.exp1.Service;
import com.example.exp1.Dao.IProductDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "商品管理相关接口")
@RequestMapping("/api/Product")
public class ProductApi {
    @Autowired
    private IProductDao productDao;
    @GetMapping("/delete/{id}")
    @ApiOperation("删除商品的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品编号", defaultValue = "100000", required = true)
    })
    public String deleteProduct(@PathVariable String id){
        productDao.deleteById(id);
        return "deleted successfully.";
    }
    @PostMapping("/update")
    @ApiOperation("修改商品名称的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品编号", defaultValue = "100000", required = true),
            @ApiImplicitParam(name = "name", value = "修改后名称", defaultValue = "Test", required = true)
    })
    public String updateProduct(@RequestParam String id,@RequestParam String name){
        productDao.updateProductNameById(id,name);
        return "updated successfully.";
    }
}
