package vip.panzhigao.study.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @author panzhigao
 */
@Configuration
public class RedisConfig implements InitializingBean,BeanNameAware,DisposableBean,BeanFactoryAware{

    public RedisConfig(){
        System.out.println("redis construction...");
    }

    @Bean
    public RedisTemplate<String,Object> initRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("redis afterPropertiesSet...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void init(){
        System.out.println("init");
    }

    public void des(){
        System.out.println("des");
    }

}
