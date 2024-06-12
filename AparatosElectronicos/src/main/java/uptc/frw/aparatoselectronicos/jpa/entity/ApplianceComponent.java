package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "APARATOCOMPONENTE")
public class ApplianceComponent {
    @Id
    @Column(name = "ID_COMPONENTE")
    private long id;
    @Column(name = "ID_COMPONENTE")
    private long quantity;
    @Column(name = "ID_COMPONENTE")
    private double price;
    @Column(name = "ID_COMPONENTE")
    private long idComponent;
    @Column(name = "ID_COMPONENTE")
    private long idManufacturer;
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE", nullable = false)
    private Component component;

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

    public long getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "ApplianceComponent{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", idComponent=" + idComponent +
                ", idManufacturer=" + idManufacturer +
                '}';
    }
}
