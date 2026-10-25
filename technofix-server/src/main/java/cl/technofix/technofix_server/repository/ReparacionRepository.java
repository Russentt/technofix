package cl.technofix.technofix_server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.technofix.technofix_server.entity.Reparacion;

@Repository
public interface ReparacionRepository extends JpaRepository<Reparacion, Long> {

    @EntityGraph(attributePaths = { "orden", "tecnico" })
    @Override
    List<Reparacion> findAll();
}
