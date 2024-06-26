package uptc.frw.aparatoselectronicos.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "APARATOELECTRONICO")
public class ApplianceElectronic {
    @Id
    @Column(name = "ID_APARATOELECTRONICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "ID_TIPOELECTRODOMESTICO", insertable = false, updatable = false)
    private long idHouseholdApplianceType;

    @Column(name="DESCRIPCION_APARATOELECTRONICO")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "applianceElectronic")
    private List<ApplianceComponent> applianceComponentList;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_TIPOELECTRODOMESTICO")
    private HouseholdApplianceType householdApplianceType;
    @JsonIgnore
    @OneToMany(mappedBy = "applianceElectronic")
    private List<Repair> repairs;

    public ApplianceElectronic() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdHouseholdApplianceType() {
        return idHouseholdApplianceType;
    }

    public void setIdHouseholdApplianceType(long idHouseholdApplianceType) {
        this.idHouseholdApplianceType = idHouseholdApplianceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ApplianceComponent> getApplianceComponentList() {
        return applianceComponentList;
    }

    public void setApplianceComponentList(List<ApplianceComponent> applianceComponentList) {
        this.applianceComponentList = applianceComponentList;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public HouseholdApplianceType getHouseholdApplianceType() {
        return householdApplianceType;
    }

    public void setHouseholdApplianceType(HouseholdApplianceType householdApplianceType) {
        this.householdApplianceType = householdApplianceType;
    }

    @Override
    public String toString() {
        return "ApplianceElectronic{" +
            "id=" + id +
            ", idHouseholdApplianceType=" + idHouseholdApplianceType +
            ", description='" + description + '\'' +
            '}';
    }
}
