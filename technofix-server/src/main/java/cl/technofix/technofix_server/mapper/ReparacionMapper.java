package cl.technofix.technofix_server.mapper;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Component;

import cl.technofix.technofix_server.dto.ReparacionDTO;
import cl.technofix.technofix_server.entity.Reparacion;

@Component
public class ReparacionMapper {

    public ReparacionDTO toDTO(Reparacion r) {
        ReparacionDTO dto = new ReparacionDTO();
        dto.setId(r.getId());
        dto.setDescripcion(r.getDescripcion());
        dto.setDiagnostico(r.getDiagnostico());
        dto.setFechaInicio(r.getFechaInicio().toString());

        String termino = (r.getFechaFinalizacion() != null) ? r.getFechaFinalizacion().toString() : "n/a";

        dto.setFechaTermino(termino);

        return dto;
    }

}
