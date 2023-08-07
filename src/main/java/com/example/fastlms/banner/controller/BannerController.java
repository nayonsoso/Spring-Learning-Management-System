package com.example.fastlms.banner.controller;

import com.example.fastlms.banner.dto.BannerDto;
import com.example.fastlms.banner.service.BannerService;
import com.example.fastlms.course.dto.CourseDto;
import com.example.fastlms.course.model.CourseParam;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BannerController {
    private final BannerService bannerService;
}
