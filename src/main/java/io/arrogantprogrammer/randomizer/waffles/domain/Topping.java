package io.arrogantprogrammer.randomizer.waffles.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Topping extends PanacheEntity {

    String name;

    @ManyToOne
    Waffle waffle;

    public Topping(String name) {
        this.name = name;
    }

    public Topping() {
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topping topping = (Topping) o;

        return name != null ? name.equals(topping.name) : topping.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
