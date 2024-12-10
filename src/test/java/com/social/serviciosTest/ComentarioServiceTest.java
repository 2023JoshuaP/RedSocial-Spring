package com.social.serviciosTest;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.social.servicios.ComentarioService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.social.entidades.Comentario;
import com.social.repositorios.ComentarioRepository;

public class ComentarioServiceTest {

    @Mock
    private ComentarioRepository comentarioRepository;

    @InjectMocks
    private ComentarioService comentarioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetComentarios() {
        List<Comentario> comentarios = new ArrayList<>();
        comentarios.add(new Comentario());
        comentarios.add(new Comentario());

        when(comentarioRepository.findAll()).thenReturn(comentarios);

        List<Comentario> result = comentarioService.getComentarios();
        assertNotNull(result);
        assertEquals(2, result.size());

        verify(comentarioRepository, times(1)).findAll();
    }

    @Test
    public void testGetComentario() {
        Comentario comentario = new Comentario();
        comentario.setContenido("Nuevo comentario");

        when(comentarioRepository.findOne(1L)).thenReturn(comentario);

        Comentario result = comentarioService.getComentario(1L);
        assertNotNull(result);
        assertEquals(Long.valueOf(1), result.getId());

        verify(comentarioRepository, times(1)).findOne(1L);
    }

    @Test
    public void testAddComentario() {
        Comentario comentario = new Comentario();

        comentarioService.addComentario(comentario);
        verify(comentarioRepository, times(1)).save(comentario);
    }

    @Test
    public void testDeleteComentario() {
        Long id = 1L;

        comentarioService.deleteComentario(id);
        verify(comentarioRepository, times(1)).delete(id);
    }

    @Test
    public void testFindAllByPost() {
        Long postId = 1L;
        Page<Comentario> comentarios = new PageImpl<>(new ArrayList<>());
        PageRequest pageRequest = new PageRequest(0, 10);

        when(comentarioRepository.findAllByPost(pageRequest, postId)).thenReturn(comentarios);

        Page<Comentario> result = comentarioService.findAllByPost(pageRequest, postId);
        assertNotNull(result);

        verify(comentarioRepository, times(1)).findAllByPost(pageRequest, postId);
    }
}

