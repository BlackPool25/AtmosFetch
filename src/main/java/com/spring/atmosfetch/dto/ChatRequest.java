package com.spring.atmosfetch.dto;

public class ChatRequest {
    private String userInfo;
    private String content;

    public ChatRequest() {
    }

    public ChatRequest(String userInfo, String content) {
        this.userInfo = userInfo;
        this.content = content;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ChatRequest{" +
                "userInfo='" + userInfo + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
