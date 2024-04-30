package cse364.group10.project.ChatGPT;

import jakarta.persistence.Entity;

@Entity
public class ChatGptResponseChoice {
    private String text;
    private int index;
    private Object logprobs;
    private String finish_Reason;

    ChatGptResponseChoice() {}

    ChatGptResponseChoice(String text, int index, Object logprobs, String finish_Reason) {
        this.text = text;
        this.index = index;
        this.logprobs = logprobs;
        this.finish_Reason = finish_Reason;
    }

    public String getText() {
        return text;
    }

    public int getIndex() {
        return index;
    }

    public Object getLogprobs() {
        return logprobs;
    }

    public String getFinish_Reason() {
        return finish_Reason;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    public void setFinish_Reason(String finish_Reason) {
        this.finish_Reason = finish_Reason;
    }
}
