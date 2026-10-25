package cl.technofix.technofix_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.technofix.technofix_server.entity.Reparacion;
import cl.technofix.technofix_server.repository.ReparacionRepository;

@Service
public class ReparacionService {

    @Autowired
    private ReparacionRepository reparacionRepository;

    @Transactional(readOnly = true)
    public List<Reparacion> findAll() {
        return reparacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Reparacion> findById(Long id) {
        return reparacionRepository.findById(id);
    }

}
