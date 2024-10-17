package dev.misu.services;

import dev.misu.entities.Task;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final JsonService jsonService = new JsonService();

    public String createTask(String description) {
        Task newTask = new Task(description);
        jsonService.saveTask(newTask);
        return newTask.toString();
    }

    public Task updateTask(int id, String description) {
        Task task = jsonService.findTaskById(id);
        task.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        task.setDescription(description);
        jsonService.saveTask(task);
        return task;
    }

    public boolean delete(int id) {
        return true;
    }

    public String markInProgress(int id) {

        return "";
    }

    public String markDone(int id) {

        return "";
    }

    public List<Task> listOfAllTasks() {

        return new ArrayList<>();
    }

    public List<Task> listOfTasksStatusDone() {

        return new ArrayList<>();
    }

    public List<Task> listOfTasksStatusTodo() {
        return new ArrayList<>();
    }

    public List<Task> listOfTasksStatusInProgress() {
        return new ArrayList<>();
    }

}
