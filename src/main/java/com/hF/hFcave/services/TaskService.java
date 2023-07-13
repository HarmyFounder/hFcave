package com.hF.hFcave.services;

import com.hF.hFcave.models.Task;
import com.hF.hFcave.models.TaskStatus;
import com.hF.hFcave.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private Map<Integer, TaskStatus> statuses;

    {
        statuses = new HashMap<>();

        statuses.put(0, TaskStatus.NO_STATUS);
        statuses.put(1, TaskStatus.NEXT_UP);
        statuses.put(2, TaskStatus.IN_PROGRESS);
        statuses.put(3, TaskStatus.COMPLETED);

    }

    private Map<Integer, List<Task>> tasksWithStatuses;

    {
        tasksWithStatuses = new HashMap<>();

        tasksWithStatuses.put(0, taskRepository.findByTaskStatus(TaskStatus.NO_STATUS));
        tasksWithStatuses.put(1, taskRepository.findByTaskStatus(TaskStatus.NEXT_UP));
        tasksWithStatuses.put(2, taskRepository.findByTaskStatus(TaskStatus.IN_PROGRESS));
        tasksWithStatuses.put(3, taskRepository.findByTaskStatus(TaskStatus.COMPLETED));

    }


    public List<List<Task>> getAll() {
        List<List<Task>> allTasksWithStatuses = new ArrayList<>();
        allTasksWithStatuses.add(tasksWithStatuses.get(0));
        allTasksWithStatuses.add(tasksWithStatuses.get(1));
        allTasksWithStatuses.add(tasksWithStatuses.get(2));
        allTasksWithStatuses.add(tasksWithStatuses.get(3));
        return allTasksWithStatuses;
    }

    public List<Task> getByTag(String filter){
        if(filter != null && !filter.isEmpty()){
            return taskRepository.findByTag(filter);
        }
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task taskToBeUpdated, Task updatedTask) {
        BeanUtils.copyProperties(updatedTask, taskToBeUpdated, "id");
        return taskRepository.save(taskToBeUpdated);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public Task upgradeTaskStatus(Task task) {
        if (task.getTaskStatus().equals(statuses.get(3))) {
            return task;
        } else {
            task.setTaskStatus(statuses.get(task.getStatusKey() + 1));
            return taskRepository.save(task);
        }
    }

    public Task downgradeTaskStatus(Task task) {
        if (task.getTaskStatus().equals(statuses.get(0))) {
            return task;
        } else {
            task.setTaskStatus(statuses.get(task.getStatusKey() - 1));
            return taskRepository.save(task);
        }
    }
}
