package org.example.dto;

import org.example.dao.UserStatus;

import java.util.Objects;

public class ResponseTransfer {
    private long userId;
    private UserStatus previousStatus;
    private UserStatus currentStatus;

    public ResponseTransfer() {
    }

    public ResponseTransfer(long userId, UserStatus previousStatus, UserStatus currentStatus) {
        this.userId = userId;
        this.previousStatus = previousStatus;
        this.currentStatus = currentStatus;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public UserStatus getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(UserStatus previousStatus) {
        this.previousStatus = previousStatus;
    }

    public UserStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(UserStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseTransfer that = (ResponseTransfer) o;
        return userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "ResponseTransfer{" +
                "userId=" + userId +
                ", previousStatus=" + previousStatus +
                ", currentStatus=" + currentStatus +
                '}';
    }
}
