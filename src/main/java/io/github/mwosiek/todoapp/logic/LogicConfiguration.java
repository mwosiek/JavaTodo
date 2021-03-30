package io.github.mwosiek.todoapp.logic;

import io.github.mwosiek.todoapp.TaskConfigurationProperties;
import io.github.mwosiek.todoapp.model.ProjectRepository;
import io.github.mwosiek.todoapp.model.TaskGroupRepository;
import io.github.mwosiek.todoapp.model.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LogicConfiguration {
    @Bean
    ProjectService projectService(
            final ProjectRepository repository,
            final TaskGroupRepository taskGroupRepository,
            final TaskConfigurationProperties config,
            final TaskGroupService taskGroupService
            ) {
        return new ProjectService(repository, taskGroupRepository, config, taskGroupService);
    }

    @Bean
    TaskGroupService taskGroupService(
            final TaskGroupRepository taskGroupRepository,
            final TaskRepository taskRepository
    ) {
        return new TaskGroupService(taskGroupRepository, taskRepository);
    }
}
