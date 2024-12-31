package com.thc.winterspr.service.impl;

import com.thc.winterspr.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    int id = 1;
    List<Map<String, Object>> boards = new ArrayList<Map<String, Object>>(); //10개까지만 저장하는 것으로 합시다!

    @Override
    public int[] create(Map<String, Object> params) {

        logger.info("create : " + params);
        System.out.println("create : " + params);

        int[] resultValue = {200,0};

        String title = (String) params.get("title");
        if(title ==  null || title.isEmpty()){
            resultValue[0] = -100;
            return resultValue; //타이틀이 비어있는 경우
        }

        if(boards.size() == 10){
            resultValue[0] = -110;
            return resultValue; //10개 이상은 저장 안되요!
        }

        resultValue[1] = id;
        params.put("id", id++);
        boards.add(params);

        logger.info("resultValue : " + resultValue.toString());
        System.out.println("resultValue : " + resultValue.toString());
        return resultValue;
    }
}
