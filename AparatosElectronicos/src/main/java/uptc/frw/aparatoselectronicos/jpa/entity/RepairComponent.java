package uptc.frw.aparatoselectronicos.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "REPARACIONCOMPONENTE")
public class RepairComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REPARACIONCOMPONENTE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_REPARACION")
    private Repair repair;

    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE")
    private Component component;

    public RepairComponent() {
    }

    public RepairComponent(Repair repair, Component component) {
        this.repair = repair;
        this.component = component;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "RepairComponent{" +
                "id=" + id +
                ", repair=" + repair +
                ", component=" + component +
                '}';
    }
}
