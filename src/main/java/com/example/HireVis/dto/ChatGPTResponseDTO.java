package com.example.HireVis.dto;


import java.util.List;

public class ChatGPTResponseDTO {
    public static class Choice{
        private int index;
        private ChatGPTMessageDTO message;
        public Choice(){}

        public Choice(int index, ChatGPTMessageDTO message) {
            this.index = index;
            this.message = message;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public ChatGPTMessageDTO getMessage() {
            return message;
        }

        public void setMessage(ChatGPTMessageDTO message) {
            this.message = message;
        }
    }
    private List<Choice> choices;

    public ChatGPTResponseDTO(){}

    public ChatGPTResponseDTO(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
