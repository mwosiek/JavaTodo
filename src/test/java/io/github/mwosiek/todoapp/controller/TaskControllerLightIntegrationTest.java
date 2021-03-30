package io.github.mwosiek.todoapp.controller;

import io.github.mwosiek.todoapp.model.Task;
import io.github.mwosiek.todoapp.model.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(TaskController.class)
class TaskControllerLightIntegrationTest {
        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private TaskRepository repo;

        @Test
        void httpGet_returnsGivenTask() throws Exception
        {
            //given
            when(repo.findById(anyInt()))
                 .thenReturn(Optional.of(new Task("foo", LocalDateTime.now())));
            //int id = repo.save(new Task("foo", LocalDateTime.now())).getId();


            //when + then
            mockMvc.perform(get("/tasks/123"))
                    .andDo(print())
                    .andExpect(content().string(containsString("\"description\":\"foo\"")));
        }
    }
