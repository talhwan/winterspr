package com.thc.winterspr.dto;

import com.thc.winterspr.domain.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class NoticeDto {

    @Builder
    @Getter
    @Setter
    public static class CreateReqDto{
        private String title;
        private String content;

        public Notice toEntity(){
            return Notice.of(getTitle(), getContent());
        }
    }

    @Builder
    @Getter
    @Setter
    public static class CreateResDto{
        private Long id;
    }

    @Builder
    @Getter
    @Setter
    public static class UpdateReqDto{
        private Long id;
        private Boolean deleted;
        private String process;
        private String title;
        private String content;
    }


}
