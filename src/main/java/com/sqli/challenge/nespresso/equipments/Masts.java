package com.sqli.challenge.nespresso.equipments;

public class Masts extends Equipment {

    public static final int HIT_POINT = 1000;

    public Masts(int numberOfEquipment) {
        super(numberOfEquipment);
        hitPoint = HIT_POINT;
    }
}
