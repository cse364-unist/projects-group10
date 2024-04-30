package cse364.group10.project.ChatGPT;

import jakarta.persistence.Entity;

@Entity
public class ChatGptRequest {
    private String model;
    private String prompt;
    private int temperature;
    private int max_tokens;

    ChatGptRequest() {}

    ChatGptRequest(String model, String prompt, int temperature, int max_tokens) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
    }

    public String getModel() {
        return model;
    }

    public String getPrompt() {
        return prompt;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }
}
