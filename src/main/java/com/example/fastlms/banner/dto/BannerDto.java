package com.example.fastlms.banner.dto;

import com.example.fastlms.banner.entity.Banner;
import com.example.fastlms.course.dto.CourseDto;
import com.example.fastlms.course.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BannerDto {
    private Long bannerId;
    private String bannerName; // 배너명
    private String bannerImg; // 절대 경로
    private String urlFileName;
    private String url; // 링크 주소
    private LocalDate regDt;
    private Long openMethod; // 오픈 방법
    private Long seq; // 정렬 순서
    private String isPublic; // 공개 여부

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return regDt != null ? regDt.format(formatter) : "";
    }

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .bannerId(banner.getBannerId())
                .bannerName(banner.getBannerName())
                .bannerImg(banner.getBannerImg())
                .urlFileName(banner.getUrlFileName())
                .url(banner.getUrl())
                .regDt(banner.getRegDt())
                .seq(banner.getSeq())
                .isPublic(banner.getIsPublic())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {

        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for (Banner x : banners) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;
    }
}
