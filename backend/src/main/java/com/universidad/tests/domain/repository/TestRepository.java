package com.universidad.tests.domain.repository;

import com.universidad.tests.domain.model.Test;
import java.util.List;
import java.util.Optional;

public interface TestRepository {
    List<Test> findActivos();
    Optional<Test> findActivoById(Long id);
}