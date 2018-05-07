package com.sqli.challenge.nespresso;

import com.sqli.challenge.nespresso.equipments.*;

public class Ship {

    private static final double percentOfPenalty = 0.005;
    private Hulls hulls;
    private Masts masts;
    private Cannons cannons;

    public Ship(int numberOfHulls, int numberOfMasts, int numberOfCannons) {
        hulls = new Hulls(numberOfHulls);
        masts = new Masts(numberOfMasts);
        cannons = new Cannons(numberOfCannons);
    }

    public Ship(int numberOfHulls, int numberOfMasts) {
        this(numberOfHulls, numberOfMasts, 0);
    }

    public double speed() {
        int numberOfHulls = hulls.getNumberOfEquipment();
        int numberOfMasts = masts.getNumberOfEquipment();
        int numberOfCannons = cannons.getNumberOfEquipment();
        int normalSpeed = numberOfHulls / numberOfMasts;
        double penalty = normalSpeed * (percentOfPenalty * numberOfCannons);
        return normalSpeed + penalty;
    }

    public int totalHitPoints() {
        return hulls.totalPoints() + masts.totalPoints() + cannons.totalPoints();
    }

    public int damage() {
        return cannons.damage();
    }

    public boolean isSunk() {
        return totalHitPoints() == 0;
    }

    public void takeNormalDamage(double damage) {
        damage = hulls.deductNumberOfEquipment(damage);
        damage = masts.deductNumberOfEquipment(damage);
        cannons.deductNumberOfEquipment(damage);
    }

    public void takeLocalizedDamage(double damage) {
        damage = masts.deductNumberOfEquipment(damage);
        damage = cannons.deductNumberOfEquipment(damage);
        hulls.deductNumberOfEquipment(damage);
    }

}
