package cl.technofix.technofix_server.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reparacion", indexes = {
        @Index(name = "idx_reparacion_orden", columnList = "id_orden"),
        @Index(name = "idx_reparacion_tecnico", columnList = "id_tecnico")
})
@Data
public class Reparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparacion")
    private Long id;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_finalizacion")
    private LocalDate fechaFinalizacion;

    @Column(nullable = false, length = 100)
    private String diagnostico;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;

}
