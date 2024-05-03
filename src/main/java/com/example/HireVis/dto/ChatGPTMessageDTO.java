package com.example.HireVis.dto;

public class ChatGPTMessageDTO {
    private String role;
    private String content;
    public ChatGPTMessageDTO(){}
    public ChatGPTMessageDTO(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
