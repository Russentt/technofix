package cl.technofix.technofix_server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.technofix.technofix_server.entity.Cliente;
import cl.technofix.technofix_server.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente save(Cliente c) {
        return clienteRepository.save(c);
    }

    @Transactional
    public Cliente update(Long id, Cliente c) {
        Cliente cliActualizado = clienteRepository.findById(id).orElse(null);
        cliActualizado.setNombre(c.getNombre());
        cliActualizado.setApellido(c.getApellido());
        cliActualizado.setCorreo(c.getCorreo());
        cliActualizado.setDireccion(c.getDireccion());
        cliActualizado.setTelefono(c.getTelefono());
        return clienteRepository.save(cliActualizado);
    }

    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}
