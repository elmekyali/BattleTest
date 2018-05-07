package com.sqli.challenge.nespresso.equipments;

public abstract class Equipment {
    protected int numberOfEquipment;
    protected int hitPoint;

    public Equipment(int numberOfEquipment) {
        this.numberOfEquipment = numberOfEquipment;
    }

    public int getNumberOfEquipment() {
        return numberOfEquipment;
    }

    public int totalPoints() {
        return numberOfEquipment * hitPoint;
    }

    public double deductNumberOfEquipment(double damage) {
        numberOfEquipment -= damage / hitPoint;
        damage = damage % hitPoint;
        damage = numberOfEquipment < 0 ? damage + Math.abs(numberOfEquipment) * hitPoint : 0;
        numberOfEquipment = numberOfEquipment < 0 ? 0 : numberOfEquipment;
        return damage;
    }
}
