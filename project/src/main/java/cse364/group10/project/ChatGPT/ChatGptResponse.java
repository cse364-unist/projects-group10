package cse364.group10.project.ChatGPT;

import jakarta.persistence.Entity;

@Entity
public class ChatGptResponse {
    private String id;
    private String object;
    private int created;
    private String model;
    private ChatGptResponseChoice[] choices;
    private ChatGptResponseUsage usage;

    ChatGptResponse() {}
    ChatGptResponse(String id, String object, int created, String model, ChatGptResponseChoice[] choices, ChatGptResponseUsage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
    }

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public int getCreated() {
        return created;
    }

    public String getModel() {
        return model;
    }

    public ChatGptResponseChoice[] getChoices() {
        return choices;
    }

    public ChatGptResponseUsage getUsage() {
        return usage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setChoices(ChatGptResponseChoice[] choices) {
        this.choices = choices;
    }

    public void setUsage(ChatGptResponseUsage usage) {
        this.usage = usage;
    }
}
