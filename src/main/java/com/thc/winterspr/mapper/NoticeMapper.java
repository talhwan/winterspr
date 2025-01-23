package com.thc.winterspr.mapper;

import com.thc.winterspr.dto.NoticeDto;

import java.util.List;

public interface NoticeMapper {
    NoticeDto.DetailResDto detail(NoticeDto.DetailReqDto param);
    List<NoticeDto.DetailResDto> list();
}
