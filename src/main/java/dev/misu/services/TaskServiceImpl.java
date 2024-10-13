package dev.misu.services;

import dev.misu.entities.Task;

import java.util.Random;

public class TaskServiceImpl implements TaskService {

    private final Random random;

    public TaskServiceImpl(Random random) {
        this.random = random;
    }

    public String createTask() {
        int id = generatingId();
        return "";
    }

    private int generatingId() {
        double id = random.nextDouble() * 100000;
        return (int) id;
    }

}
