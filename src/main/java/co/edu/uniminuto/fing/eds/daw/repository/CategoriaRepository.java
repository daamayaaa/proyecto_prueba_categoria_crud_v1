package co.edu.uniminuto.fing.eds.daw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniminuto.fing.eds.daw.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
