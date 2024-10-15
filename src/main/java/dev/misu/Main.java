package dev.misu;

import dev.misu.controller.TaskController;
import dev.misu.controller.TaskControllerImpl;
import dev.misu.entities.Task;

public class Main {

    public static void main(String[] args) {

        TaskController taskController = new TaskControllerImpl();

        if (args.length < 2) {
            System.out.println("Usage: task-cli <command> <parameters>");
            return;
        }

        String command = args[0];
        switch (command) {
            case "add":
                String taskRes = taskController.createTask(args[1]);
                System.out.println(taskRes);
                break;
            case "update":
                int id = Integer.parseInt(args[1]);
                
        }

    }
}