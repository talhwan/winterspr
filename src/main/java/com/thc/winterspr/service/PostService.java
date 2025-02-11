package com.thc.winterspr.service;

import com.thc.winterspr.dto.DefaultDto;
import com.thc.winterspr.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto.CreateResDto create(PostDto.CreateReqDto params);
    void update(PostDto.UpdateReqDto params);
    void delete(PostDto.UpdateReqDto params);
    PostDto.DetailResDto detail(DefaultDto.DetailReqDto params);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto params);

    DefaultDto.PagedListResDto pagedList(PostDto.PagedListReqDto params);
    List<PostDto.DetailResDto> scrollList(PostDto.ScrollListReqDto params);
}
