package cl.technofix.technofix_server.dto;

import java.util.Optional;

import lombok.Data;

@Data
public class ReparacionDTO {
    private Long id;
    private String diagnostico;
    private String descripcion;
    private String fechaInicio;
    private String fechaTermino;
}
