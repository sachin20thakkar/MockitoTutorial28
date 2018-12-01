package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;

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

    @Test
    public void retrieveTodosRelatedToSpringWithBDD() {

        //GIVEN
        TodoService todoService = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC4", "Learn Spring",
                "Learn to Dance");
        given(todoService.retrieveTodos("Ranga")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);


        //WHEN
        List<String> filteredtodos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");

        //THEN
        assertThat(filteredtodos.size(), is(2));

    }
}