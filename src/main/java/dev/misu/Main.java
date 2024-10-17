package dev.misu;

import dev.misu.controller.TaskController;
import dev.misu.controller.TaskControllerImpl;
import dev.misu.entities.Task;
import dev.misu.services.TaskServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        TaskController taskController = new TaskControllerImpl(new TaskServiceImpl());

        if (args.length == 0) {
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
            case "mark-done":
                int taskDoneId = Integer.parseInt(args[1]);
                String resDone = taskController.markDone(taskDoneId);
                System.out.println(resDone);
                break;
            case "mark-in-progress":
                int taskInProgress = Integer.parseInt(args[1]);
                String inProgress = taskController.markDone(taskInProgress);
                System.out.println(inProgress);
                break;
            case "list":
                if (args.length > 1) {
                    String listType = args[1];
                    switch (listType) {
                        case "done":
                            printList(taskController.listOfTasksStatusDone());
                            break;
                        case "todo":
                            printList(taskController.listOfTasksStatusTodo());
                            break;
                        case "in-progress":
                            printList(taskController.listOfTasksStatusInProgress());
                            break;
                        default:
                            System.out.println("List Type: done, todo, in-progress");
                    }
                } else {
                    printList(taskController.listOfAllTasks());
                }
            default:
                System.out.println("Enter a valid commands!");
                break;
        }

    }

    private static void printList(List<Task> tasks) {
        for (Task task: tasks) {
            System.out.println(task);
        }
    }
}