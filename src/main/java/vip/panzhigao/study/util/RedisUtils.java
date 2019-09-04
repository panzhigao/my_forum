//package vip.panzhigao.study.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author panzhigao
// */
//@Component
//public class RedisUtils{
//
//    private static StringRedisTemplate redisTemplate;
//
//
//    @Autowired
//    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
//        RedisUtils.redisTemplate = redisTemplate;
//    }
//
//    public static Object get(String key){
//        return key==null?null:redisTemplate.opsForValue().get(key);
//    }
//}
