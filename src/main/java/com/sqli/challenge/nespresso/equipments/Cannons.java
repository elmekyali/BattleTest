package com.sqli.challenge.nespresso.equipments;

public class Cannons extends Equipment {

    private static final int HIT_POINT = 100;
    private static final int DAMAGE_POWER = 200;

    public Cannons(int numberOfEquipment) {
        super(numberOfEquipment);
        hitPoint = HIT_POINT;
    }

    public int damage () {
        return DAMAGE_POWER * numberOfEquipment;
    }
}
