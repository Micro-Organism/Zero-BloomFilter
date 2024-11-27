package com.zero.bloom.filter.controller;

import com.zero.bloom.filter.common.config.BloomFilterConfig;
import com.zero.bloom.filter.service.BloomFilterService;
import com.zero.bloom.filter.service.RBloomFilterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "布隆过滤器测试控制器")
@RequestMapping("bloom")
public class BloomFilterController {

    @Resource
    private BloomFilterService bloomFilterService;

    @Resource
    private RBloomFilterService rBloomFilterService;

    @Resource
    private BloomFilterConfig bloomFilterConfig;

    @GetMapping("/add")
    @Operation(summary = "基于JVM本地缓存布隆过滤器-添加")
    public void add(@RequestParam String element) {
        bloomFilterService.add(element);
    }

    @GetMapping("/check")
    @Operation(summary = "基于JVM本地缓存布隆过滤器-检查")
    public String check(@RequestParam String element) {
        return bloomFilterService.check(element);
    }

    @GetMapping("/addR")
    @Operation(summary = "基于Redis布隆过滤器-添加")
    public void addR(@RequestParam String element) {
        rBloomFilterService.add(element);
    }

    @GetMapping("/checkR")
    @Operation(summary = "基于Redis布隆过滤器-检查")
    public String checkR(@RequestParam String element) {
        return rBloomFilterService.check(element);
    }

    @GetMapping("/dilatationR")
    @Operation(summary = "基于Redis布隆过滤器-手动扩容")
    public void dilatationR() {
        bloomFilterConfig.dilatation();
    }
}
