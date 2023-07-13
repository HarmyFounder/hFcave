package com.hF.hFcave.repositories;

import com.hF.hFcave.models.Task;
import com.hF.hFcave.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTag(String tag);

    List<Task> findByTaskStatus(TaskStatus taskStatus);

}
