package cn.zhixiangyun.controller.user;

import cn.zhixiangyun.api.model.user.User;
import cn.zhixiangyun.api.service.user.UserService;
import cn.zhixiangyun.web.requestdata.RequestDataConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.zhixiangyun.net
 *
 * @version V1.0
 * @Title: UserController
 * @Package cn.zhixiangyun.user.controller
 * @Description: 用户congroller
 * @author: hhp
 * @date: 2018-09-25 13:51
 * @Copyright: 2018 www.zhixiangyun.net Inc. All rights reserved.
 * 注意：本内容仅限于浙江智飨科技内部传阅，禁止外泄以及用于其他的商业目
 */
@RestController
@RequestMapping("/userManager")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    /**
     * @Title: getUserlist
     * @Description: 得到用户列表
     * @param: page 页码 @Param pageSize 每页显示条数
     * @return:  List<User> 用户list集合
     * @throws
     */
    @ResponseBody
    @PostMapping("/getUserList")
    public String getUserlist(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int rows) {

        return userService.getUserList(page, rows);
    }


    /*@ApiOperation(value = "not use")
    @ApiImplicitParam(name = "params" , paramType = "body",examples = @Example({
            @ExampleProperty(value = "{'user':'id'}", mediaType = "application/json")
    }))*/
    @PostMapping("/addUser")//@RequestBody Map<String,String> map
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
