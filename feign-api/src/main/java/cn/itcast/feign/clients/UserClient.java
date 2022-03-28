package cn.itcast.feign.clients;

import cn.itcast.feign.config.FeignConfiguration;
import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 配置feign的日志级别，加在指定的类上表示指定的服务有效
@FeignClient(value = "userservice", configuration = FeignConfiguration.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
