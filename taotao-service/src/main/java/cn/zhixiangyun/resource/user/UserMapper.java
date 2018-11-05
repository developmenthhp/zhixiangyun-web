package cn.zhixiangyun.resource.user;

import cn.zhixiangyun.api.model.user.User;
import cn.zhixiangyun.dataBase.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
	// 使用注解的方式
	@Select("select * from t_user where name like concat('%',#{name},'%')")
	public List<User> likeName(String name);

	@Select("select * from t_user where id = #{id}")
	public User getById(Long id);

	// 使用xml的方式
	public List<User> getUsers();

}