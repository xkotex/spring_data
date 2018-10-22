package com.example.NumberGame.dto;

import com.example.NumberGame.entity.RequestTable;

import java.time.LocalDateTime;

public class ResponseDTO {

    private boolean isWin;
    private LocalDateTime localDateTime;
    private RequestTable requestTable;

    public RequestTable getRequestTable() {
        return requestTable;
    }

    public void setRequestTable(RequestTable requestTable) {
        this.requestTable = requestTable;
    }

    public ResponseDTO(boolean isWin, LocalDateTime localDateTime, RequestTable requestTable) {
        this.isWin = isWin;
        this.localDateTime = localDateTime;
        this.requestTable = requestTable;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
