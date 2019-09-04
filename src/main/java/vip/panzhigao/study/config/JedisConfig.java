package vip.panzhigao.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author panzhigao
 */
@Slf4j
@Configuration
@PropertySource("classpath:file/jedis.properties")
public class JedisConfig {

    @Value("${jedis.host}")
    private String host;

    @Value("${jedis.port}")
    private int port;

    @Value("${jedis.timeout}")
    private int timeout;

    @Value("${jedis.maxIdle}")
    private int maxIdle;

    @Value("${jedis.maxWait}")
    private long maxWaitMillis;

    @Value("${jedis.password}")
    private String password;

    @Value("${jedis.block-when-exhausted}")
    private boolean  blockWhenExhausted;

    @Bean
    public JedisPool redisPoolFactory()  throws Exception{
        log.info("JedisPool注入成功！！");
        log.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return jedisPool;
    }


}
