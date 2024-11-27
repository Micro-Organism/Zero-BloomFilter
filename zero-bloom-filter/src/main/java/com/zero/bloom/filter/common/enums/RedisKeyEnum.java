package com.zero.bloom.filter.common.enums;

public enum RedisKeyEnum {
    USER_REGISTER_CACHE_PENETRATION_BLOOM_FILTER_1(1, "用户注册缓存1"),
    USER_REGISTER_CACHE_PENETRATION_BLOOM_FILTER_2(2, "用户注册缓存2");

    private final Integer code;
    private final String message;

    RedisKeyEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
