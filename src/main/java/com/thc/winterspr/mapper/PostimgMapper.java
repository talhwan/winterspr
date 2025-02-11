package com.thc.winterspr.mapper;

import com.thc.winterspr.dto.DefaultDto;
import com.thc.winterspr.dto.PostimgDto;

import java.util.List;

public interface PostimgMapper {
    PostimgDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto params);

    int pagedListCount(PostimgDto.PagedListReqDto params);
    List<PostimgDto.DetailResDto> pagedList(PostimgDto.PagedListReqDto params);
    List<PostimgDto.DetailResDto> scrollList(PostimgDto.ScrollListReqDto params);
}
