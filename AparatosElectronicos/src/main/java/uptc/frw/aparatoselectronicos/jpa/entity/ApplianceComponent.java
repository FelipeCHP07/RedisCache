package uptc.frw.aparatoselectronicos.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "APARATOCOMPONENTE")
public class ApplianceComponent {
    @Id
    @Column(name = "ID_APARATOCOMPONENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "CANTIDAD")
    private long quantity;
    @Column(name = "PRECIO")
    private double price;
    @Column(name = "ID_COMPONENTE", insertable = false,updatable = false)
    private long idComponent;
    @JsonIgnore
    @Column(name = "ID_APARATOELECTRONICO", insertable = false,updatable = false)
    private long idApplianceElectronic;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE")
    private Component component;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_APARATOELECTRONICO", nullable = false)
    private ApplianceElectronic applianceElectronic;

    public ApplianceComponent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(long idComponent) {
        this.idComponent = idComponent;
    }

    public long getIdApplianceElectronic() {
        return idApplianceElectronic;
    }

    public void setIdApplianceElectronic(long idApplianceElectronic) {
        this.idApplianceElectronic = idApplianceElectronic;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public ApplianceElectronic getApplianceElectronic() {
        return applianceElectronic;
    }

    public void setApplianceElectronic(ApplianceElectronic applianceElectronic) {
        this.applianceElectronic = applianceElectronic;
    }

    @Override
    public String toString() {
        return "ApplianceComponent{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", idComponent=" + idComponent +
                ", idManufacturer=" + idApplianceElectronic +
                '}';
    }
}
