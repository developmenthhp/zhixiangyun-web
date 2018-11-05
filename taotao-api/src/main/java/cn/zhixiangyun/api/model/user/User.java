package cn.zhixiangyun.api.model.user;

import cn.zhixiangyun.api.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;


import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.zhixiangyun.net
 *
 * @version V1.0
 * @Title: zhixiangyun-taotao
 * @Package cn.zhixiangyun.api.model.user
 * @Description: 用户实体类
 * @author: hhp
 * @date: 2018-09-26 10:50
 * @Copyright: 2018 www.zhixiangyun.net Inc. All rights reserved.
 * 注意：本内容仅限于浙江智飨科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
@ToString
@Table(name="tb_user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -459993263361085318L;

    private Long id;

    // 用户名
    private String userName;

    /**
     * @Max(value = 999999,message = "超过最大数值")
     * @Min(value = 000000,message = "密码设定不正确")
     * */
    // 密码
    private String password;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 性别，1男性，2女性
    private Integer sex;

    // 出生日期
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date birthday;

    // 创建时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date created;

    // 更新时间
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updated;

}
