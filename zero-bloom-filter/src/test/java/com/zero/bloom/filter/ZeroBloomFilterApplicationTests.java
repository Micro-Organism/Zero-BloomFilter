package com.zero.bloom.filter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ZeroBloomFilterApplicationTests {

    @BeforeEach
    public void before()  {
        log.info("init some data");
    }

    @AfterEach
    public void after(){
        log.info("clean some data");
    }

    @Test
    public void execute()  {
        log.info("your method test Code");
        //  Redisson client
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        // create Redisson client instant
        RedissonClient redisson = Redisson.create(config);

        // create RBloomFilter
        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("myBloomFilter");

        // Initialize the Bloom filter, set the expected number of elements to be inserted and the false positive rate
        bloomFilter.tryInit(10000L, 0.03);

        // inert element
        bloomFilter.add("key1");
        bloomFilter.add("key2");

        // find element
        boolean mightContainYi = bloomFilter.contains("key3");
        System.out.println("bloomFilter may contain 'key1'：" + mightContainYi);

        // close Redisson client
        redisson.shutdown();
    }

}
