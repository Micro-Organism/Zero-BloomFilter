package com.zero.bloom.filter.service.impl;

import com.zero.bloom.filter.common.config.BloomFilterConfig;
import com.zero.bloom.filter.service.BloomFilterService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BloomFilterServiceImpl implements BloomFilterService {

    /**
     * 私有的不可变的BloomFilter对象
     */
    @Resource
    private BloomFilterConfig bloomFilterUtil;

    /**
     * 向BloomFilter中添加元素
     * @param element   元素
     */
    @Override
    public void add(String element) {
        bloomFilterUtil.bloomFilter.put(element);
    }

    /**
     * 检查BloomFilter中是否存在元素
     * @param element   元素
     * @return  元素是否存在于集合中
     */
    @Override
    public String check(String element) {
        // 如果BloomFilter判断元素可能存在
        if (bloomFilterUtil.bloomFilter.mightContain(element)) {
            return element + " 可能存在于集合中";
        } else {
            return element + " 不可能存在于集合中";
        }
    }

}
