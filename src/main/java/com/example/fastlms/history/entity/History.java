package com.example.fastlms.history.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "login_history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long historyId;

    LocalDateTime loginTime;
    String userId;

    String ip;
    String agent;
}
