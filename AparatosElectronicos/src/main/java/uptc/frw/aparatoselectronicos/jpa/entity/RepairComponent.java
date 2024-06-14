package uptc.frw.aparatoselectronicos.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "REPARACIONCOMPONENTE")
public class RepairComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REPARACIONCOMPONENTE")
    private long id;
    @Column(name = "ID_REPARACION", insertable = false, updatable = false)
    private long idRepair;
    @Column(name = "ID_COMPONENTE", insertable = false, updatable = false)
    private  long idComponent;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_REPARACION")
    private Repair repair;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE")
    private Component component;

    public RepairComponent() {
    }

    public RepairComponent(Repair repair, Component component) {
        this.repair = repair;
        this.component = component;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public long getIdRepair() {
        return idRepair;
    }

    public void setIdRepair(long idRepair) {
        this.idRepair = idRepair;
    }

    public long getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(long idComponent) {
        this.idComponent = idComponent;
    }

    @Override
    public String toString() {
        return "RepairComponent{" +
                "id=" + id +
                ", idRepair=" + idRepair +
                ", idComponent=" + idComponent +
                '}';
    }
}
