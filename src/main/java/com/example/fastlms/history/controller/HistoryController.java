package com.example.fastlms.history.controller;

import com.example.fastlms.history.service.HistoryService;
import com.example.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class HistoryController {

    private final HistoryService historyService;

    @RequestMapping("/history")
    public String saveHistory(HttpServletRequest request) {
        return "index";
    }
}
