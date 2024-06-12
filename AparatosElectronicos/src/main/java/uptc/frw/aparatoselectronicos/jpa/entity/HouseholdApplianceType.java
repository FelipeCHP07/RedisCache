package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPOELECTRODOMESTICO")
public class HouseholdApplianceType {
    @Id
    @Column(name = "ID_TIPOELECTRODOMESTICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
