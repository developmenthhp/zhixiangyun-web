package cn.zhixiangyun.service.impl.user;

import cn.zhixiangyun.api.model.user.User;
import cn.zhixiangyun.api.service.redis.RedisService;
import cn.zhixiangyun.api.service.user.UserService;
import cn.zhixiangyun.resource.user.UserMapper;
import cn.zhixiangyun.sms.SendSmsUtil;
import cn.zhixiangyun.web.responseConfig.JsonUtil;
import cn.zhixiangyun.web.responseConfig.ResultBean;
import com.alibaba.dubbo.config.annotation.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0", interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisService redisService;

	@Override
	public String getUserList(int page, int pageSize) {

		try {
			PageHelper.startPage(page, pageSize);

			List<User> users = userMapper.getUsers();

			PageInfo<User> pageInfo = new PageInfo<User>();

			return JsonUtil.toJson(new ResultBean(true, null,pageInfo.getTotal(),users));
		} catch (Exception e) {
			return JsonUtil.toJson(new ResultBean(false, e.getMessage()));
		}

	}

	@Override
	public String addUser(User user) {

		try {

			userMapper.insert(user);

			//发短信
			/*SendSmsResponse response = SendSmsUtil.sendSms();
			System.out.println("短信接口返回的数据----------------");
			System.out.println("Code=" + response.getCode());
			System.out.println("Message=" + response.getMessage());
			System.out.println("RequestId=" + response.getRequestId());
			System.out.println("BizId=" + response.getBizId());*/

			return JsonUtil.toJson(new ResultBean(true, "添加成功"));
		} catch (Exception e) {
			return JsonUtil.toJson(new ResultBean(false, e.getMessage()));
		}

	}


}