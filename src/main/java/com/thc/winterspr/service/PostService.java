package com.thc.winterspr.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/*@Service*/
public interface PostService {
    int[] create(Map<String, Object> params);
}
