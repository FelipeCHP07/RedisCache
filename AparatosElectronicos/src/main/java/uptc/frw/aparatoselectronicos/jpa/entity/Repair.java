package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "REPARACION")
public class Repair {
    @Id
    @Column(name = "ID_REPARACION")
    private long id;
    @Column(name = "ID_REPARACION")
    private String description;
    @Column(name = "ID_REPARACION")
    private Date dateRepair;
    @Column(name = "ID_REPARACION")
    private long idCustomer;
    @Column(name = "ID_REPARACION")
    private long idAppliance;

    public Repair() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateRepair() {
        return dateRepair;
    }

    public void setDateRepair(Date dateRepair) {
        this.dateRepair = dateRepair;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public long getIdAppliance() {
        return idAppliance;
    }

    public void setIdAppliance(long idAppliance) {
        this.idAppliance = idAppliance;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateRepair=" + dateRepair +
                ", idCustomer=" + idCustomer +
                ", idAppliance=" + idAppliance +
                '}';
    }
}
