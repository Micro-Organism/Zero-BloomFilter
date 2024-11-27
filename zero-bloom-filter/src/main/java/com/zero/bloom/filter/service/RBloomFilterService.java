package com.zero.bloom.filter.service;

public interface RBloomFilterService {

    String add(String element);

    String check(String element);

}
