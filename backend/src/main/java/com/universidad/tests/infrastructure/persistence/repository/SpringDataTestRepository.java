package com.universidad.tests.infrastructure.persistence.repository;

import com.universidad.tests.infrastructure.persistence.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpringDataTestRepository extends JpaRepository<TestEntity, Long> {

    List<TestEntity> findByActivoTrue();

    @Query("SELECT DISTINCT t FROM TestEntity t LEFT JOIN FETCH t.subpruebas WHERE t.activo = true")
    List<TestEntity> findActivosWithSubpruebas();

    @Query("SELECT DISTINCT t FROM TestEntity t LEFT JOIN FETCH t.subpruebas WHERE t.id = :id AND t.activo = true")
    Optional<TestEntity> findActivoByIdWithSubpruebas(@Param("id") Long id);
}
