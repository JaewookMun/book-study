package com.github.jaewookmun.tdd.ch07_mock.autodebit.dto;

import java.time.LocalDateTime;

public class AutoDebitInfo {
    private String userId;
    private String cardNumber;
    private LocalDateTime registTime;
    private LocalDateTime updateTime;

    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime now) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.registTime = now;
        this.updateTime = now;
    }

    public void changeCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        this.updateTime = LocalDateTime.now();
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
