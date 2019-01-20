package paymentmicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Netbanking {

    @Id
    private int id;

    private String name;
    private boolean isActive;

    public  Netbanking(){}

    public Netbanking(int id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setName(String name) {
        this.name = name;
    }
}
