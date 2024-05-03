package com.example.HireVis.dto;

import java.util.ArrayList;
import java.util.List;

public class ChatGPTRequestDTO {
    private String model;
    private List<ChatGPTMessageDTO> messages;

    public ChatGPTRequestDTO(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new ChatGPTMessageDTO("user",prompt));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatGPTMessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatGPTMessageDTO> messages) {
        this.messages = messages;
    }
}
