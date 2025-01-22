package com.thc.winterspr.service;

import com.thc.winterspr.domain.Notice;
import com.thc.winterspr.dto.NoticeDto;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    NoticeDto.CreateResDto create(NoticeDto.CreateReqDto params);
    void update(NoticeDto.UpdateReqDto params);
    void delete(NoticeDto.UpdateReqDto params);
    Notice detail(Long id);
    List<Notice> list();
}
