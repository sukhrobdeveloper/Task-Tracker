package dev.misu.services;

import dev.misu.entities.Task;

import java.util.List;

public interface TaskService {

    String createTask(String description);

    Task updateTask(int id, String description);

    boolean delete(int id);

    String markInProgress(int id);

    String markDone(int id);

    List<Task> listOfAllTasks();

    List<Task> listOfTasksStatusDone();

    List<Task> listOfTasksStatusTodo();

    List<Task> listOfTasksStatusInProgress();


}
