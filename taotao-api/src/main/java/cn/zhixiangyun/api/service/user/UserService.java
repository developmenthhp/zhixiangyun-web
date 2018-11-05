package cn.zhixiangyun.api.service.user;

import cn.zhixiangyun.api.model.user.User;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.zhixiangyun.net
 *
 * @version V1.0
 * @Title: zhixiangyun-taotao
 * @Package cn.zhixiangyun.api.service.user
 * @Description: 用户业务接口
 * @author: hhp
 * @date: 2018-09-26 10:56
 * @Copyright: 2018 www.zhixiangyun.net Inc. All rights reserved.
 * 注意：本内容仅限于浙江智飨科技内部传阅，禁止外泄以及用于其他的商业目
 */
public interface UserService{

    /**
     * @param page 当前页
     * @param pageSize 每页显示条数
     * @return
     */
    String getUserList(int page, int pageSize);

    /**
     * @param user user实体类
     * @return
     */
    String addUser(User user);

}
