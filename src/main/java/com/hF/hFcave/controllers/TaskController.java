package com.hF.hFcave.controllers;

import com.hF.hFcave.models.Task;
import com.hF.hFcave.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<List<Task>> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getCertain(@PathVariable("id") Task task) {
        return task;
    }

    @GetMapping("/byTag")
    public List<Task> getByTag(@RequestParam String filter) {
        return taskService.getByTag(filter);
    }

    @PostMapping("/new")
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}/update")
    public Task update(@PathVariable("id") Task taskToBeUpdated, @RequestBody Task updatedtask){
        return taskService.update(taskToBeUpdated,updatedtask);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Task task){
        taskService.delete(task);
    }

    @PostMapping("/{id}/upgradeTaskStatus")
    public Task upgradeTaskStatus(@PathVariable("id")Task task){
        return taskService.upgradeTaskStatus(task);
    }

    @PostMapping("/{id}/downgradeTaskStatus")
    public Task downgradeTaskStatus(@PathVariable("id")Task task){
        return taskService.downgradeTaskStatus(task);
    }

}
