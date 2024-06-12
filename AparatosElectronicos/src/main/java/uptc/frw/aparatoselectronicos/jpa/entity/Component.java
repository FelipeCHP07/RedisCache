package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COMPONENTE")
public class Component {
    @Id
    @Column(name = "ID_COMPONENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NOMBRE_COMPONENTE")
    private  String name;
    @Column(name = "ESPECIFICACIONES_COMPONENTE")
    private String specifications;
    @Column(name = "ID_FABRICANTE")
    private long idManufacturer;
    @OneToMany(mappedBy = "component")
    private List<ApplianceComponent>applianceComponentList;



    public Component() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public long getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public List<ApplianceComponent> getApplianceComponentList() {
        return applianceComponentList;
    }

    public void setApplianceComponentList(List<ApplianceComponent> applianceComponentList) {
        this.applianceComponentList = applianceComponentList;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specifications='" + specifications + '\'' +
                ", idManufacturer=" + idManufacturer +
                '}';
    }
}
