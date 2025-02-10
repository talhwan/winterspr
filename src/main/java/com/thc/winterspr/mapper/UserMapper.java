package com.thc.winterspr.mapper;

import com.thc.winterspr.dto.DefaultDto;
import com.thc.winterspr.dto.UserDto;

import java.util.List;

public interface UserMapper {
    UserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<UserDto.DetailResDto> list(UserDto.ListReqDto params);

    int pagedListCount(UserDto.PagedListReqDto params);
    List<UserDto.DetailResDto> pagedList(UserDto.PagedListReqDto params);
    List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto params);
}
