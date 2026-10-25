package cl.technofix.technofix_server.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.technofix.technofix_server.dto.ReparacionDTO;
import cl.technofix.technofix_server.entity.Reparacion;
import cl.technofix.technofix_server.mapper.ReparacionMapper;
import cl.technofix.technofix_server.service.ReparacionService;

@RestController
@RequestMapping("/api/reparaciones")
@CrossOrigin(origins = "http://localhost:5173")
public class ReparacionController {

    @Autowired
    private ReparacionService reparacionService;

    @Autowired
    private ReparacionMapper reparacionMapper;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Reparacion> reparaciones = reparacionService.findAll();
        List<ReparacionDTO> reparacionesDTO = reparaciones.stream().map(rep -> reparacionMapper.toDTO(rep))
                .collect(Collectors.toList());
        return ResponseEntity.ok(reparacionesDTO);
    }

}
