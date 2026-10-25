package cl.technofix.technofix_server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import lombok.Data;

@Entity
@Table(name = "tecnico")
@Data
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private Long id;

    @Column(precision = 8, nullable = false)
    private int rut;

    @Column(length = 1, nullable = false)
    private String dv_run;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String apellido;

    @Column(nullable = false, precision = 9)
    @Max(9)
    private int telefono;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, precision = 10)
    private int sueldo;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 100)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;

}
