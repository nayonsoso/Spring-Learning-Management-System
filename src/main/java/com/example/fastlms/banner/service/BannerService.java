package com.example.fastlms.banner.service;

import com.example.fastlms.admin.entity.Category;
import com.example.fastlms.admin.model.CategoryInput;
import com.example.fastlms.banner.dto.BannerDto;
import com.example.fastlms.banner.entity.Banner;
import com.example.fastlms.banner.model.BannerInput;
import com.example.fastlms.banner.repository.BannerRepository;
import com.example.fastlms.course.dto.CourseDto;
import com.example.fastlms.course.entity.Course;
import com.example.fastlms.course.model.CourseInput;
import com.example.fastlms.history.dto.HistoryDto;
import com.example.fastlms.history.entity.History;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    public List<BannerDto> list(){
        return bannerRepository.findAllByOrderBySeq().stream().map(BannerDto::of).collect(Collectors.toList());
    }

    public List<BannerDto> listIfPublic(){
        return bannerRepository.findAllByIsPublicIsNotNullOrderBySeq().stream().map(BannerDto::of).collect(Collectors.toList());
    }

    public BannerDto getById(long id) {
        Optional<Banner> optionalBanner = bannerRepository.findByBannerId(id);
        if(optionalBanner.isPresent()){
            return BannerDto.of(optionalBanner.get());
        }
        return bannerRepository.findByBannerId(id).map(BannerDto::of).orElse(null);
    }

    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalBanner = bannerRepository.findByBannerId(parameter.getBannerId());

        if(optionalBanner.isPresent()){
            Banner banner = optionalBanner.get();
            banner.setBannerName(parameter.getBannerName());
            banner.setBannerImg(parameter.getFilename());
            banner.setUrl(parameter.getUrl());
            banner.setUrlFileName(parameter.getUrlFilename());
            banner.setSeq(parameter.getSeq());
            banner.setIsPublic(parameter.getIsPublic());
            banner.setUrlFileName(parameter.getUrlFilename());
            bannerRepository.save(banner);
            return true;
        } else {
            return false;
        }
    }

    public boolean add(BannerInput parameter) {
        Banner banner = new Banner();
        banner.setBannerName(parameter.getBannerName());
        banner.setUrl(parameter.getUrl());
        banner.setSeq(parameter.getSeq());
        banner.setIsPublic(parameter.getIsPublic());
        banner.setBannerImg(parameter.getFilename());
        banner.setUrlFileName(parameter.getUrlFilename());
        banner.setRegDt(LocalDate.now());
        bannerRepository.save(banner);

        return true;
    }

    public boolean del(String idList) {
        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
        return true;
    }
}
