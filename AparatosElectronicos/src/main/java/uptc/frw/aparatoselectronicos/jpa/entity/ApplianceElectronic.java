package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "APARATOELECTRONICO")
public class ApplianceElectronic {
    @Id
    @Column(name = "ID_APARATOELECTRONICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
