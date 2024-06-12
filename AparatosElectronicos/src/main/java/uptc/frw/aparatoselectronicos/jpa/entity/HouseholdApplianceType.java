package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TIPOELECTRODOMESTICO")
public class HouseholdApplianceType {
    @Id
    @Column(name = "ID_TIPOELECTRODOMESTICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ID_SUBTIPOELECTRODOMESTICO")
    private long subTypeId;

    @Column(name = "NOMBRE_TIPOELECTRODOMESTICO")
    private String typeName;

    @Column(name = "CARACTERISTICAS_TIPOELECTRODOMESTICO")
    private String typeDescription;



    @OneToMany(mappedBy = "householdApplianceType")
    private List<ApplianceElectronic> applianceElectronics;

    public HouseholdApplianceType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(long typeId) {
        this.subTypeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public List<ApplianceElectronic> getApplianceElectronics() {
        return applianceElectronics;
    }

    public void setApplianceElectronics(List<ApplianceElectronic> applianceElectronics) {
        this.applianceElectronics = applianceElectronics;
    }



    @Override
    public String toString() {
        return "HouseholdApplianceType{" +
            "id=" + id +
            ", typeId=" + subTypeId +
            ", typeName='" + typeName + '\'' +
            ", typeDescription='" + typeDescription + '\'' +
            '}';
    }
}
