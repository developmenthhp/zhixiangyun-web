package cn.zhixiangyun.api.service.redis;

public interface RedisService {

    public void set(String key, Object value);  

    public Object get(String key);  

}
