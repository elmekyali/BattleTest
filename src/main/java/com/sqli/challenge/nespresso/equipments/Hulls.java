package com.sqli.challenge.nespresso.equipments;

public class Hulls extends Equipment{

    public static final int HIT_POINT = 1;

    public Hulls(int numberOfEquipment) {
        super(numberOfEquipment);
        hitPoint = HIT_POINT;
    }
}
