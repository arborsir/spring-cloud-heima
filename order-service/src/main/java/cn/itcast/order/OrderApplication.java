package cn.itcast.order;

//import cn.itcast.order.config.FeignConfiguration;
import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.config.FeignConfiguration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
// 配置feign的日志级别，加在启动类是全局有效
//@EnableFeignClients(defaultConfiguration = FeignConfiguration.class)
// 配置FeignClient所在的包
//@EnableFeignClients(basePackages = "cn.itcast.feign.clients")
// 配置FeignClient所需要的字节码，是一个数组
@EnableFeignClients(clients = {UserClient.class})
//@EnableFeignClients
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate并注入Spring容器
     * 用于发起http请求
     *
     * @return restTemplate对象
     */
    @Bean
    @LoadBalanced   // 开启负载均衡注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    /**
//     * 修改负载均衡策略
//     * 使用随机选择一个可用服务器
//     */
//    @Bean
//    public IRule randomRule() {
//        return new RandomRule();
//    }

}