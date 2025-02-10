package com.thc.winterspr.mapper;

import com.thc.winterspr.dto.DefaultDto;
import com.thc.winterspr.dto.NoticeDto;

import java.util.List;

public interface NoticeMapper {
    NoticeDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto params);

    int pagedListCount(NoticeDto.PagedListReqDto params);
    List<NoticeDto.DetailResDto> pagedList(NoticeDto.PagedListReqDto params);
    List<NoticeDto.DetailResDto> scrollList(NoticeDto.ScrollListReqDto params);
}
