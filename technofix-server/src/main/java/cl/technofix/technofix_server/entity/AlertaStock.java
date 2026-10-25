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
@Table(name = "alerta_stock")
@Data
public class AlertaStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long id;

    @Column(name = "fecha_alerta", nullable = false)
    private LocalDate fechaAlerta = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_reparacion", nullable = false)
    private Reparacion reparacion;

    @ManyToOne
    @JoinColumn(name = "id_repuesto", nullable = false)
    private Repuesto repuesto;

    @Column(name = "nombre_repuesto", length = 100, nullable = false)
    private String nombreRepuesto;

    @Column(name = "cantidad_requerida", nullable = false, precision = 10)
    private int cantidadRequerida;

    @Column(nullable = false, name = "stock_disponible", precision = 10)
    private int stockDisponible;

    @Column(nullable = false, name = "stock_minimo", precision = 10)
    private int stockMinimo;

    @Column(nullable = false, length = 30)
    private String nivelAlerta;

    @Column(nullable = false, length = 250)
    private String detalle;

}
