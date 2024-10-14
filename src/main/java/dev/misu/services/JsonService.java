package dev.misu.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.misu.entities.Task;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import com.google.gson.reflect.TypeToken;
import dev.misu.utils.AppConstant;

public class JsonService {

    private final Gson gson;

    public JsonService(Gson gson) {
        this.gson = gson;
    }

    public Task findTaskById(Integer id) {
        Type taskTypeList = new TypeToken<List<Task>>(){}.getType();

        try(FileReader reader = new FileReader(AppConstant.JSON_FILE_PATH)) {
            List<Task> tasks = gson.fromJson(reader, taskTypeList);

            Optional<Task> optionalTask = tasks.stream()
                    .filter(task -> task.getId() == id)
                    .findFirst();

        } catch (IOException ex) {
            System.out.println("Error while reading a file: " + ex.getMessage());
        }


    }

}
