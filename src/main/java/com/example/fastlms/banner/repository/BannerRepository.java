package com.example.fastlms.banner.repository;

import com.example.fastlms.banner.dto.BannerDto;
import com.example.fastlms.banner.entity.Banner;
import com.example.fastlms.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BannerRepository extends JpaRepository<Banner, Long> {
    Optional<Banner> findByBannerId(Long bannerId);
    List<Banner> findAllByOrderBySeq();
    List<Banner> findAllByIsPublicIsNotNullOrderBySeq();
}