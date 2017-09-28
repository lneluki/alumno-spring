package com.ejercicios.integradores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.integradores.model.Alumno;

public interface UserRepository extends JpaRepository<Alumno, Integer> {
	List<Alumno> findAlumnoByDniOrNombreOrApellidoOrAnoOrCurso(String dni,
			String nombre, String apellido, int ano, int curso);
}
