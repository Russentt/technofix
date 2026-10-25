package cl.technofix.technofix_server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import lombok.Data;

@Entity
@Table(name = "repuesto")
@Data
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repuesto")
    private Long id;

    @Column(length = 100, nullable = false, name = "nombre_repuesto")
    private String nombre;

    @Column(length = 200, nullable = false)
    private String descripcion;

    @Max(10)
    @Column(name = "stock_disponible")
    private int stockDisponible;

    @Max(10)
    @Column(name = "stock_minimo")
    private int stockMinimo;

}
