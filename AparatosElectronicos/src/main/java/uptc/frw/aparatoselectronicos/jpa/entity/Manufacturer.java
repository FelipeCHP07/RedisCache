package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FABRICANTE")
public class Manufacturer {
    @Id
    @Column(name = "ID_FABRICANTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "RIF")
    private String rif;

    @Column(name = "DOMICILIO")
    private String domicilio;

    @OneToMany(mappedBy = "manufacturer")
    private List<Component> components;

    public Manufacturer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
            "id=" + id +
            ", rif='" + rif + '\'' +
            ", domicilio='" + domicilio + '\'' +
            '}';
    }
}
