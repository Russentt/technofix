package cl.technofix.technofix_server.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "resumen_tecnico")
@Data
public class ResumenTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resumen_tecnico")
    private Long id;

    @Column(nullable = false, name = "fecha_proceso")
    private LocalDate fechaProceso;

    @ManyToOne
    @JoinColumn(name = "id_tecnico", nullable = false)
    private Tecnico tecnico;

    @Column(nullable = false, name = "nombre_tecnico")
    private String nombreTecnico;

    @Column(precision = 10, nullable = false)
    private int reparaciones;

    @Column(name = "sueldo_base", nullable = false, precision = 10)
    private int sueldoBase;

    @Column(name = "monto_bono", nullable = false, precision = 10)
    private int montoBono;

    @Column(name = "sueldo_total", nullable = false, precision = 10)
    private int sueldoTotal;

}
