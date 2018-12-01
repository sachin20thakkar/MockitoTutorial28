package com.in28minutes.business;


import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

public class ListTest {

    @Test
    public void listMockSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        Assert.assertEquals(2, listMock.size());

    }

    @Test
    public void listMockSizeMethodReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        Assert.assertEquals(2, listMock.size());
        Assert.assertEquals(3, listMock.size());

    }

    @Test
    public void listMockGet() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("in28minutes");

        Assert.assertEquals("in28minutes", listMock.get(0));


    }

    @Test
    public void listMockGetArgumentMatcher() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("in28minutes");

        Assert.assertEquals("in28minutes", listMock.get(5));


    }

    @Test(expected = RuntimeException.class)
    public void listMockGetArgumentMatcherThrowException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Failed"));

        listMock.get(0);



    }
}
