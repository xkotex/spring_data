package com.example.NumberGame.dto;

public class RequestDTO {
    private int number;
    private String username;

    public RequestDTO(int number, String username) {
        this.number = number;
        this.username = username;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
