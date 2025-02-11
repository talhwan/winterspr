package com.thc.winterspr.mapper;

import com.thc.winterspr.dto.DefaultDto;
import com.thc.winterspr.dto.PostDto;

import java.util.List;

public interface PostMapper {
    PostDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto params);

    int pagedListCount(PostDto.PagedListReqDto params);
    List<PostDto.DetailResDto> pagedList(PostDto.PagedListReqDto params);
    List<PostDto.DetailResDto> scrollList(PostDto.ScrollListReqDto params);
}
