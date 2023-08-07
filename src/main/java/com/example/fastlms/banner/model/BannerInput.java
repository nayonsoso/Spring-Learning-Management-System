package com.example.fastlms.banner.model;

import lombok.Data;

@Data
public class BannerInput {
    long bannerId;

    String bannerName;
    String filename; // 이미지 파일을 저장할 절대 경로
    String urlFilename; // URL 경로
    String url; // 누르면 이동할 url

    long seq;
    String isPublic;
    String idList;

}