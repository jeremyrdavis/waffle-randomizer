package io.arrogantprogrammer.randomizer.waffles.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waffle extends PanacheEntity {

    TYPE type;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Topping> toppings;

    public static Waffle from(WaffleJson waffleJson) {

        return new Waffle(waffleJson.type(), waffleJson.toppings());
    }

    public Waffle(TYPE waffletype, List<Topping> toppings) {
        this.type = waffletype;
        this.toppings = toppings;
    }

    public Waffle() {
    }

    public TYPE getType() {
        return type;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    void setType(TYPE waffletype) {
        this.type = waffletype;
    }

    void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
