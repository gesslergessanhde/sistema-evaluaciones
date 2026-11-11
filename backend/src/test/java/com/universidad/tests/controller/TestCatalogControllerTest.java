package com.universidad.tests.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.universidad.tests.application.service.TestCatalogService;
import com.universidad.tests.dto.response.SubpruebaDetalleResponse;
import com.universidad.tests.dto.response.TestDetalleResponse;
import com.universidad.tests.dto.response.TestResumenResponse;
import com.universidad.tests.exception.ResourceNotFoundException;

@WebMvcTest(TestCatalogController.class)
class TestCatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestCatalogService testCatalogService;

    @Test
    void debeRetornarListaDeTestsResumen() throws Exception {
        TestResumenResponse testDto = new TestResumenResponse(1L, "BFA", "Batería Factorial de Aptitudes", 13);
        Mockito.when(testCatalogService.obtenerCatalogoActivo()).thenReturn(List.of(testDto));

        mockMvc.perform(get("/api/v1/tests").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].codigo").value("BFA"))
            .andExpect(jsonPath("$[0].numeroSubpruebas").value(13));
    }

    @Test
    void debeRetornarDetalleDeTest() throws Exception {
        SubpruebaDetalleResponse subprueba = new SubpruebaDetalleResponse(10L, "VOC1", "Vocabulario I", "Test de vocabulario", 1, 10);
        TestDetalleResponse detalleDto = new TestDetalleResponse(1L, "BFA", "Batería Factorial", "Descripción BFA", List.of(subprueba));

        Mockito.when(testCatalogService.obtenerDetalleTest(1L)).thenReturn(detalleDto);

        mockMvc.perform(get("/api/v1/tests/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.subpruebas[0].codigo").value("VOC1"));
    }

    @Test
    void debeRetornar404CuandoTestNoExiste() throws Exception {
        Mockito.when(testCatalogService.obtenerDetalleTest(99L))
            .thenThrow(new ResourceNotFoundException("Test no encontrado"));

        mockMvc.perform(get("/api/v1/tests/99").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }
}