package com.universidad.tests.controller;

import com.universidad.tests.application.service.TestCatalogService;
import com.universidad.tests.dto.response.TestDetalleResponse;
import com.universidad.tests.dto.response.TestResumenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tests")
public class TestCatalogController {

    private final TestCatalogService testCatalogService;

    public TestCatalogController(TestCatalogService testCatalogService) {
        this.testCatalogService = testCatalogService;
    }

    @GetMapping
    public ResponseEntity<List<TestResumenResponse>> listarTests() {
        List<TestResumenResponse> catalogo = testCatalogService.obtenerCatalogoActivo();
        return ResponseEntity.ok(catalogo);
    }

    @GetMapping("/{testId}")
    public ResponseEntity<TestDetalleResponse> obtenerDetalleTest(@PathVariable Long testId) {
        TestDetalleResponse detalle = testCatalogService.obtenerDetalleTest(testId);
        return ResponseEntity.ok(detalle);
    }
}