package com.example.fastlms.banner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bannerId;

    String bannerName; // 배너명
    String bannerImg; // 배너 파일
    String urlFileName; // URL 파일 이름
    String url; // 링크 주소
    LocalDate regDt;
    Long openMethod; // 오픈 방법
    Long seq; // 정렬 순서
    String isPublic; // 공개 여부
}