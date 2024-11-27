package com.zero.bloom.filter.service;

public interface BloomFilterService {

    void add(String element);

    String check(String element);

}
