package com.universidad.tests.application.service;

import com.universidad.tests.domain.model.Test;
import com.universidad.tests.domain.repository.TestRepository;
import com.universidad.tests.dto.response.TestDetalleResponse;
import com.universidad.tests.dto.response.TestResumenResponse;
import com.universidad.tests.exception.ResourceNotFoundException;
import com.universidad.tests.mapper.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCatalogService {

    private final TestRepository testRepository;
    private final TestMapper testMapper;

    public TestCatalogService(TestRepository testRepository, TestMapper testMapper) {
        this.testRepository = testRepository;
        this.testMapper = testMapper;
    }

    public List<TestResumenResponse> obtenerCatalogoActivo() {
        return testRepository.findActivos().stream()
            .map(testMapper::toResumenResponse)
            .collect(Collectors.toList());
    }

    public TestDetalleResponse obtenerDetalleTest(Long id) {
        Test test = testRepository.findActivoById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Test no encontrado o inactivo con ID: " + id));
        return testMapper.toDetalleResponse(test);
    }
}