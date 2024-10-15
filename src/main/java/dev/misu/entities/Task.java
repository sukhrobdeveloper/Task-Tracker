package dev.misu.entities;

import java.sql.Timestamp;

/**
 * @author Sukhrob Tokhirov
 * @since October 13, 2024
 * @version 1.0
 */
public class Task {

    private static int count = 1;

    private int id;
    private String description;
    private Status status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Task(String description) {
        this.id = count++;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Your Task Characteristics:\nId: " + id +
                "\nDescription: " + description +
                "\nStatus: " + status;
    }
}
