package com.thc.winterspr.dto;

import com.thc.winterspr.domain.Notice;
import lombok.*;

import java.util.List;

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

    @Builder
    @Getter
    @Setter
    public static class DetailReqDto{
        private Long id;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class DetailResDto{
        private Long id;
        private String createdAt;
        private String modifiedAt;
        private Boolean deleted;
        private String process;
        private String title;
        private String content;
    }

    @Builder
    @Getter
    @Setter
    public static class ListReqDto{
        private Boolean deleted;
        private String title;
    }

    @Builder
    @Getter
    @Setter
    public static class PagedListReqDto{
        private Boolean deleted;
        private String title;

        private Integer offset;
        private Integer callpage;
        private Integer perpage;
    }
    @Builder
    @Getter
    @Setter
    public static class PagedListResDto{
        private Object list;

        private Integer totalList;
        private Integer totalPage;
        private Integer callpage;
        private Integer perpage;
    }

}
