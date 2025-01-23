package com.thc.winterspr.service.impl;

import com.thc.winterspr.domain.Notice;
import com.thc.winterspr.dto.NoticeDto;
import com.thc.winterspr.mapper.NoticeMapper;
import com.thc.winterspr.repository.NoticeRepository;
import com.thc.winterspr.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;
    public NoticeServiceImpl(NoticeRepository noticeRepository, NoticeMapper noticeMapper){
        this.noticeRepository = noticeRepository;
        this.noticeMapper = noticeMapper;
    }

    @Override
    public NoticeDto.CreateResDto create(NoticeDto.CreateReqDto params) {
        return noticeRepository.save(params.toEntity()).toCreateResDto();
    }

    @Override
    public void update(NoticeDto.UpdateReqDto params) {
        Notice notice = noticeRepository.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(params.getDeleted() != null){ notice.setDeleted(params.getDeleted()); }
        if(params.getProcess() != null){ notice.setProcess(params.getProcess()); }
        if(params.getTitle() != null){ notice.setTitle(params.getTitle()); }
        if(params.getContent() != null){ notice.setContent(params.getContent()); }
        noticeRepository.save(notice);
    }

    @Override
    public void delete(NoticeDto.UpdateReqDto params) {
        /*
        Notice notice = noticeRepository.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        noticeRepository.delete(notice);
        */
        params.setDeleted(true);
        update(params);
    }


    public NoticeDto.DetailResDto get(NoticeDto.DetailReqDto params) {
        /*
        Notice notice = noticeRepository.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        NoticeDto.DetailResDto res = NoticeDto.DetailResDto.builder()
                .id(notice.getId())
                .createdAt(notice.getCreatedAt() + "")
                .modifiedAt(notice.getModifiedAt() + "")
                .deleted(notice.getDeleted())
                .process(notice.getProcess())
                .title(notice.getTitle())
                .content(notice.getContent())
                .build();
        return res;
        */
        return noticeMapper.detail(params);
    }

    @Override
    public NoticeDto.DetailResDto detail(NoticeDto.DetailReqDto params) {
        return get(params);
    }

    @Override
    public List<NoticeDto.DetailResDto> list() {
        /*
        List<Notice> listNotice = noticeRepository.findAll();
        List<NoticeDto.DetailResDto> finalList = new ArrayList<NoticeDto.DetailResDto>();
        for(Notice each : listNotice){
            finalList.add(get(NoticeDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return finalList;
        */
        List<NoticeDto.DetailResDto> tempList = noticeMapper.list();
        List<NoticeDto.DetailResDto> finalList = new ArrayList<NoticeDto.DetailResDto>();
        for(NoticeDto.DetailResDto each : tempList){
            finalList.add(get(NoticeDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return finalList;
    }
}
