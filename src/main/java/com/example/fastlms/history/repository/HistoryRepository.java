package com.example.fastlms.history.repository;

import com.example.fastlms.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, String> {
    List<History> findAllByUserIdOrderByLoginTimeDesc(String username);
}
