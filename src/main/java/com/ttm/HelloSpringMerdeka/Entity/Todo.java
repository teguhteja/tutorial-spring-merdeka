package com.ttm.HelloSpringMerdeka.Entity;

public class Todo {
    private Long userId;
    private Long Id;
    private String Title;
    private Boolean completed;

    public Todo() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", Id=" + Id +
                ", Title='" + Title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
