package cl.technofix.technofix_server.entity;

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
@Table(name = "repuesto_utilizado")
@Data
public class RepuestoUtilizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repuesto_utilizado")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_reparacion", nullable = false)
    private Reparacion reparacion;

    @ManyToOne
    @JoinColumn(name = "id_repuesto", nullable = false)
    private Repuesto repuesto;

    @Column(name = "cantidad_utilizada", nullable = false)
    private int cantidadUtilizada;
}
