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

    public List<NoticeDto.DetailResDto> addlist(List<NoticeDto.DetailResDto> list) {
        List<NoticeDto.DetailResDto> finalList = new ArrayList<>();
        for(NoticeDto.DetailResDto each : list){
            finalList.add(get(NoticeDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return finalList;
    }


    @Override

    public List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto params) {
        List<NoticeDto.DetailResDto> tempList = noticeMapper.list(params);
        return addlist(tempList);
    }
    @Override
    public NoticeDto.PagedListResDto pagedList(NoticeDto.PagedListReqDto params) {

        //전체 글 갯수가 몇개인지 확인할것!!
        int totalList = noticeMapper.pagedListCount(params);

        //한 페이지에 몇개씩 볼지 확인할 것!!
        Integer perpage = params.getPerpage();
        if(perpage == null || perpage <= 0){
            perpage = 10;
        }
        params.setPerpage(perpage);

        //전체 페이지 갯수
        int totalPage = totalList / perpage;
        if(totalList % perpage > 0){
            totalPage++;
        }

        //몇번째 페이지 보고 싶은지
        Integer callpage = params.getCallpage();
        if(callpage == null || callpage <= 0){
            callpage = 1;
        } else if(callpage > totalPage){
            callpage = totalPage;
        }
        params.setCallpage(callpage);

        //몇번째 글부터 보여줄지
        int offset = (callpage - 1) * perpage;
        params.setOffset(offset);

        List<NoticeDto.DetailResDto> pagedList = noticeMapper.pagedList(params);
        List<NoticeDto.DetailResDto> finalList = addlist(pagedList);

        NoticeDto.PagedListResDto returnVal = NoticeDto.PagedListResDto.builder()
                .list(finalList)
                .totalList(totalList)
                .totalPage(totalPage)
                .callpage(callpage)
                .perpage(perpage)
                .build();

        return returnVal;
    }
}
