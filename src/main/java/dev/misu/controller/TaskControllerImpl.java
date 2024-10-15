package dev.misu.controller;

import dev.misu.entities.Task;
import dev.misu.services.TaskService;

import java.util.List;

public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    public TaskControllerImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String createTask(String description) {
        return taskService.createTask(description);
    }

    @Override
    public Task updateTask(int id, String description) {
        return taskService.updateTask(id, description);
    }

    @Override
    public boolean delete(int id) {
        return taskService.delete(id);
    }

    @Override
    public String markInProgress(int id) {
        return taskService.markInProgress(id);
    }

    @Override
    public String markDone(int id) {
        return taskService.markDone(id);
    }

    @Override
    public List<Task> listOfAllTasks() {
        return taskService.listOfAllTasks();
    }

    @Override
    public List<Task> listOfTasksStatusDone() {
        return taskService.listOfTasksStatusDone();
    }

    @Override
    public List<Task> listOfTasksStatusTodo() {
        return taskService.listOfTasksStatusTodo();
    }

    @Override
    public List<Task> listOfTasksStatusInProgress() {
        return taskService.listOfTasksStatusInProgress();
    }
}
