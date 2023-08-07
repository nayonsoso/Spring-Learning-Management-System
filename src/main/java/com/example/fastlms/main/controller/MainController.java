package com.example.fastlms.main.controller;


import com.example.fastlms.banner.dto.BannerDto;
import com.example.fastlms.banner.service.BannerService;
import com.example.fastlms.components.MailComponents;
import com.example.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;
    private final BannerService bannerService;

    @GetMapping("/")
    public String index(Model model){
        List<BannerDto> bannerDtoList = bannerService.listIfPublic();
        model.addAttribute("publicBanners", bannerDtoList);
        return "index";
    }
    
    @RequestMapping("/error/denied")
    public String errorDenied() {
        return "error/denied";
    }
}
