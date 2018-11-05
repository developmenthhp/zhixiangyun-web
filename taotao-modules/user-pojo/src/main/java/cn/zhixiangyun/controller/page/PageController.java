package cn.zhixiangyun.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * All rights Reserved, Designed By www.zhixiangyun.net
 *
 * @version V1.0
 * @Title: PageController
 * @Package cn.zhixiangyun.page
 * @Description:  通用的页面跳转
 * @author: hhp
 * @date: 2018-09-25 13:53
 * @Copyright: 2018 www.zhixiangyun.net Inc. All rights reserved.
 * 注意：本内容仅限于浙江智飨科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/page")
public class PageController {

    /**   
     * @Title: toPage
     * @Description: 具体跳转到哪个页面
     * @date:
     * @param: pageName 页面名
     * @return: 页面名
     */
    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName")String pageName){
        return pageName;
    }

}
