package dev.misu.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.misu.entities.Task;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import dev.misu.utils.AppConstant;

public class JsonService {

    private final Gson gson = new Gson();

    public Task findTaskById(Integer id) {
        Type taskTypeList = new TypeToken<List<Task>>(){}.getType();

        try(FileReader reader = new FileReader(AppConstant.JSON_FILE_PATH)) {
            List<Task> tasks = gson.fromJson(reader, taskTypeList);

            Optional<Task> optionalTask = tasks.stream()
                    .filter(task -> task.getId() == id)
                    .findFirst();

            return optionalTask.orElse(null);

        } catch (IOException ex) {
            System.out.println("Error while reading a file: " + ex.getMessage());
        }

        return null;
    }

    public void saveTask(Task newTask) {
        try(FileWriter fileWriter = new FileWriter(AppConstant.JSON_FILE_PATH)) {
            gson.toJson(newTask, fileWriter);
        } catch (IOException ex) {
            System.out.println("Error while saving tasks: " + ex.getMessage());
        }
    }



}
