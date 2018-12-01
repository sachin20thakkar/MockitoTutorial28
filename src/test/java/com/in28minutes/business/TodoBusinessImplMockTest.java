package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class TodoBusinessImplMockTest {

    @Test
    public void retrieveTodosRelatedToSpring() {

        TodoService todoService = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        when(todoService.retrieveTodos("Ranga")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> filteredtodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, filteredtodos.size());

    }

    @Test
    public void retrieveTodosRelatedToSpringWithEmptyList() {

        TodoService todoService = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList();
        when(todoService.retrieveTodos("Ranga")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> filteredtodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(0, filteredtodos.size());
    }
}