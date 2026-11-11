package com.universidad.tests.infrastructure.persistence.repository;

import com.universidad.tests.domain.model.Subprueba;
import com.universidad.tests.domain.model.Test;
import com.universidad.tests.domain.repository.TestRepository;
import com.universidad.tests.infrastructure.persistence.entity.SubpruebaEntity;
import com.universidad.tests.infrastructure.persistence.entity.TestEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TestRepositoryImpl implements TestRepository {

    private final SpringDataTestRepository springDataTestRepository;

    public TestRepositoryImpl(SpringDataTestRepository springDataTestRepository) {
        this.springDataTestRepository = springDataTestRepository;
    }

    @Override
    public List<Test> findActivos() {
        return springDataTestRepository.findByActivoTrue().stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Test> findActivoById(Long id) {
        return springDataTestRepository.findActivoByIdWithSubpruebas(id)
            .map(this::toDomain);
    }

    private Test toDomain(TestEntity entity) {
        List<Subprueba> subpruebas = entity.getSubpruebas().stream()
            .map(this::toSubpruebaDomain)
            .collect(Collectors.toList());

        return new Test(
            entity.getId(),
            entity.getCodigo(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getActivo(),
            subpruebas
        );
    }

    private Subprueba toSubpruebaDomain(SubpruebaEntity entity) {
        return new Subprueba(
            entity.getId(),
            entity.getCodigo(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getOrden(),
            entity.getDuracionMinutos()
        );
    }
}