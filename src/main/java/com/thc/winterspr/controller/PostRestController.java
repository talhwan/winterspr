package com.thc.winterspr.controller;

import com.thc.winterspr.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/post")
@RestController
public class PostRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Autowired
    PostService postService;*/

    private final PostService postService;
    public PostRestController(
            PostService postService
    ) {
        this.postService = postService;
    }

    //create
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {

        logger.info("create : " + params);
        System.out.println("create : " + params);

        /*PostServiceImpl postService = new PostServiceImpl();
        postService.create(params);*/

        int[] arrayResultCode = postService.create(params);

        Map<String, Object> returnValue = new HashMap<String, Object>();
        returnValue.put("resultCode", arrayResultCode[0]);
        returnValue.put("id", arrayResultCode[1]);

        return returnValue;
    }

    //update
    //delete
    //detail
    //list
}
