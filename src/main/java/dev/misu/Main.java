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
                Task task = taskController.updateTask(id, args[2]);
                System.out.println(task);
                break;
            case "delete":
                int deleteId = Integer.parseInt(args[1]);
                boolean deleted = taskController.delete(deleteId);
                System.out.println("Deleted? " + deleted);
                break;
        }

    }
}