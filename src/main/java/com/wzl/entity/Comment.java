package com.wzl.entity;

public class Comment {
    private int id;
    private int p_id;
    private int u_id;
    private String text;

    public Comment(int id, int p_id, int u_id, String text) {
        this.id = id;
        this.p_id = p_id;
        this.u_id = u_id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", p_id=" + p_id +
                ", u_id=" + u_id +
                ", text='" + text + '\'' +
                '}';
    }
}
