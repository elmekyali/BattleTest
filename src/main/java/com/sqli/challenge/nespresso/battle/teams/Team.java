package com.sqli.challenge.nespresso.battle.teams;

import com.sqli.challenge.nespresso.Ship;

import java.util.*;

public class Team {
    private List<Ship> shipList;

    public Team() {
        this.shipList = new ArrayList<>();
    }

    public void addShips(Ship... ships) {
        shipList.addAll(Arrays.asList(ships));
    }


    public double getTotalDamage() {
        return shipList
                .stream()
                .mapToDouble(Ship::damage)
                .sum();
    }

    public Ship NextShip () {
        return shipList
                .stream()
                .filter(ship -> !ship.isSunk())
                .findFirst()
                .get();
    }

    public double getTotalHitPoints () {
        return shipList
                .stream()
                .mapToDouble(Ship::totalHitPoints)
                .sum();
    }

    public static Team winningTeam (Team firstTeam , Team secondTeam) {
       return firstTeam.isSunk() ? secondTeam : firstTeam;
    }

    public boolean isSunk () {
        return AvailableShips() == 0;
    }

    public int AvailableShips () {
        return shipList.size() - ((int) shipList.stream().filter(Ship::isSunk).count());
    }

    public boolean contains (Ship ship) {
        return shipList.contains(ship);
    }
}
