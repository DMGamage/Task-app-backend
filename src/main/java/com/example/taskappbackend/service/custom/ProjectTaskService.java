package com.example.taskappbackend.service.custom;

import com.example.taskappbackend.dto.TaskDTO;
import com.example.taskappbackend.dto.ProjectDTO;
import com.example.taskappbackend.service.SuperService;

import java.util.List;

public interface ProjectTaskService extends SuperService {
    ProjectDTO createNewProject(ProjectDTO projectDTO);

    List<ProjectDTO> getAllProjects(String username);

    ProjectDTO getProjectDetails(String username, int projectId);

    void renameProject(ProjectDTO project);

    void deleteProject(String username, int projectId);

    TaskDTO createNewTask(String username, TaskDTO task);

    void renameTask(String username, TaskDTO task);

    void deleteTask(String username, TaskDTO taskDTO);

    TaskDTO getTaskDetails(String username, TaskDTO taskDTO);

    List<TaskDTO> getAllTasks(String username, int projectId);

    void updateTaskStatus(String username, TaskDTO taskDTO, boolean completed);
}
