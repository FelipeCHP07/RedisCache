package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FABRICANTE")
public class Manufacturer {
    @Id
    @Column(name = "ID_FABRICANTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
