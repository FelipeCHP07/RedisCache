package uptc.frw.aparatoselectronicos.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "REPARACION")
public class Repair {
    @Id
    @Column(name = "ID_REPARACION", insertable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "FECHA_REPARACION")
    private Date dateRepair;
    @Column(name = "ID_CLIENTE", insertable = false, updatable = false)
    private long idCustomer;
    @Column(name = "ID_APARATOELECTRONICO", insertable = false, updatable = false)
    private long idApplianceElectronic;
    @OneToMany(mappedBy = "repair")
    private List<RepairComponent> repairComponentList;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ID_APARATOELECTRONICO")
    private ApplianceElectronic applianceElectronic;

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

    public long getIdApplianceElectronic() {
        return idApplianceElectronic;
    }

    public void setIdApplianceElectronic(long idApplianceElectronic) {
        this.idApplianceElectronic = idApplianceElectronic;
    }

    public List<RepairComponent> getRepairComponentList() {
        return repairComponentList;
    }

    public void setRepairComponentList(List<RepairComponent> repairComponentList) {
        this.repairComponentList = repairComponentList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ApplianceElectronic getApplianceElectronic() {
        return applianceElectronic;
    }

    public void setApplianceElectronic(ApplianceElectronic applianceElectronic) {
        this.applianceElectronic = applianceElectronic;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateRepair=" + dateRepair +
                ", idCustomer=" + idCustomer +
                ", idAppliance=" + idApplianceElectronic +
                '}';
    }
}
