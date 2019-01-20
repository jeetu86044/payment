package paymentmicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class DebitCard {
    @Id
    private int id;

    private String name;
    private boolean isActive;

    public  DebitCard(){}

    public DebitCard(int id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public void setName(String name) {
        this.name = name;
    }
}
