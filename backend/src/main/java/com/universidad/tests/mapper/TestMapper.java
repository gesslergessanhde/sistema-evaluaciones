package com.universidad.tests.mapper;

import com.universidad.tests.domain.model.Subprueba;
import com.universidad.tests.domain.model.Test;
import com.universidad.tests.dto.response.SubpruebaDetalleResponse;
import com.universidad.tests.dto.response.TestDetalleResponse;
import com.universidad.tests.dto.response.TestResumenResponse;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TestMapper {

    public TestResumenResponse toResumenResponse(Test test) {
        return new TestResumenResponse(
            test.getId(),
            test.getCodigo(),
            test.getNombre(),
            test.getNumeroSubpruebas()
        );
    }

    public TestDetalleResponse toDetalleResponse(Test test) {
        var subpruebasDto = test.getSubpruebas().stream()
            .map(this::toSubpruebaDetalleResponse)
            .collect(Collectors.toList());

        return new TestDetalleResponse(
            test.getId(),
            test.getCodigo(),
            test.getNombre(),
            test.getDescripcion(),
            subpruebasDto
        );
    }

    private SubpruebaDetalleResponse toSubpruebaDetalleResponse(Subprueba subprueba) {
        return new SubpruebaDetalleResponse(
            subprueba.getId(),
            subprueba.getCodigo(),
            subprueba.getNombre(),
            subprueba.getDescripcion(),
            subprueba.getOrden(),
            subprueba.getDuracionMinutos()
        );
    }
}