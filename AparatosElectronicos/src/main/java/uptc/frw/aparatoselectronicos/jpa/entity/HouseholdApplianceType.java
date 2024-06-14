package uptc.frw.aparatoselectronicos.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TIPOELECTRODOMESTICO")
public class HouseholdApplianceType {
    @Id
    @Column(name = "ID_TIPOELECTRODOMESTICO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_TIPOELECTRODOMESTICOGENERAL", referencedColumnName = "ID_TIPOELECTRODOMESTICO")
    private HouseholdApplianceType typeHouseholdApplianceType;

    @JsonIgnore
    @OneToMany(mappedBy = "typeHouseholdApplianceType")
    private List<HouseholdApplianceType> subtypeHouseholdApplianceTypes;

    @Column(name = "NOMBRE_TIPOELECTRODOMESTICO")
    private String typeName;

    @Column(name = "CARACTERISTICAS_TIPOELECTRODOMESTICO")
    private String typeDescription;

    public HouseholdApplianceType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public HouseholdApplianceType getTypeHouseholdApplianceType() {
        return typeHouseholdApplianceType;
    }

    public void setTypeHouseholdApplianceType(HouseholdApplianceType typeHouseholdApplianceType) {
        this.typeHouseholdApplianceType = typeHouseholdApplianceType;
    }

    public List<HouseholdApplianceType> getSubtypeHouseholdApplianceTypes() {
        return subtypeHouseholdApplianceTypes;
    }

    public void setSubtypeHouseholdApplianceTypes(List<HouseholdApplianceType> subtypeHouseholdApplianceTypes) {
        this.subtypeHouseholdApplianceTypes = subtypeHouseholdApplianceTypes;
    }

    @Override
    public String toString() {
        return "HouseholdApplianceType{" +
            "id=" + id +
           // ", typeId=" + subTypeId +
            ", typeName='" + typeName + '\'' +
            ", typeDescription='" + typeDescription + '\'' +
            '}';
    }
}
