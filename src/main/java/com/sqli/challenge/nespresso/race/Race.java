package com.sqli.challenge.nespresso.race;

import com.sqli.challenge.nespresso.Ship;

import java.util.*;

public class Race {
    private final List<Ship> shipList;

    public Race(Ship... ships) {
        shipList = new LinkedList<>();
        shipList.addAll(Arrays.asList(ships));
    }

    public Ship winner() {
        return shipList
                .stream()
                .sorted(Comparator.comparing(Ship::speed))
                .findFirst()
                .get();
    }
}
