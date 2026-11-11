CREATE TABLE IF NOT EXISTS tests (
                                   id BIGSERIAL PRIMARY KEY,
                                   codigo VARCHAR(20) NOT NULL UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT,
  activo BOOLEAN NOT NULL DEFAULT TRUE
  );

CREATE TABLE IF NOT EXISTS subpruebas (
                                        id BIGSERIAL PRIMARY KEY,
                                        codigo VARCHAR(20) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT,
  orden_aplicacion INT NOT NULL,
  duracion_minutos INT,
  id_test BIGINT NOT NULL,
  CONSTRAINT fk_subpruebas_test FOREIGN KEY (id_test) REFERENCES tests(id) ON DELETE CASCADE
  );
