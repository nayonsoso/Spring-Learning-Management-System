package com.example.fastlms.history.service;

import com.example.fastlms.history.dto.HistoryDto;
import com.example.fastlms.history.entity.History;
import com.example.fastlms.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public void saveHistory(String userId, String ip, String agent){
        History history = History.builder()
                .agent(agent)
                .ip(ip)
                .loginTime(LocalDateTime.now())
                .userId(userId)
                .build();
        historyRepository.save(history);
    }

    public List<HistoryDto> list(String userId){
        List<History> historyList = historyRepository.findAllByUserIdOrderByLoginTimeDesc(userId);
        List<HistoryDto> historyDtoList = historyList.stream().map(
                e -> HistoryDto.builder()
                        .agent(e.getAgent())
                        .loginTime(e.getLoginTime())
                        .ip(e.getIp())
                        .historyId(e.getHistoryId())
                        .build())
                .collect(Collectors.toList());
        return historyDtoList;
    }
}
