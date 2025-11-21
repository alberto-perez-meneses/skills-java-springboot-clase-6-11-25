package com.ennovate.clase6.service.impl;

import com.ennovate.clase6.model.Note;
import com.ennovate.clase6.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class NoteServiceImplTest {
    @Mock
    private NoteRepository repository;

    @InjectMocks
    private NoteServiceImpl service;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTest(){
        Note note = getNote();
        Mockito.when(repository.save(note)).thenReturn(note);

        Note saved = service.create(note);
        assertEquals("hello", saved.getTitle());
        verify(repository, times(1)).save(note);
    }

    private Note getNote(){
        Note note = new Note();
        note.setId(1L);
        note.setOwner("alice");
        note.setTitle("hello");
        return note;
    }
}
