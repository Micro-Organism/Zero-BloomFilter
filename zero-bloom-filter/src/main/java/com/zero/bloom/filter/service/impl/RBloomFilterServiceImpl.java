package com.zero.bloom.filter.service.impl;

import com.zero.bloom.filter.common.config.BloomFilterConfig;
import com.zero.bloom.filter.service.RBloomFilterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RBloomFilterServiceImpl implements RBloomFilterService {

    @Resource
    private BloomFilterConfig bloomFilterUtil;

    /**
     * 新增数据到布隆过滤器中
     *
     * @param element   元素
     */
    @Override
    public String add(String element) {
        return bloomFilterUtil.rBloomFilter.add(element) ? "插入成功" : "插入失败";
    }

    /**
     * 检查数据是否存在布隆过滤器中
     *
     * @param element   元素
     * @return  存在或不存在
     */
    @Override
    public String check(String element) {
        log.info("序号：{}", bloomFilterUtil.RBloomFilterSequence);
        log.info("元素个数：{}", bloomFilterUtil.rBloomFilter.count());
        log.info("期望插入数：{}", bloomFilterUtil.rBloomFilter.getExpectedInsertions());
        log.info("假阳性概率：{}", bloomFilterUtil.rBloomFilter.getFalseProbability());
        return bloomFilterUtil.rBloomFilter.contains(element) ? "存在" : "不存在";
    }

}
