package io.arrogantprogrammer.randomizer.waffles.domain;

import java.util.List;

public record WaffleJson(Long id, TYPE type, List<Topping> toppings) {
}
