package com.example.fastlms.history.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HistoryDto {
    private Long historyId;
    private String username;
    private String ip;
    private String agent;
    private LocalDateTime loginTime;

    public String getLoginTimeText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return loginTime != null ? loginTime.format(formatter) : "";
    }
}
