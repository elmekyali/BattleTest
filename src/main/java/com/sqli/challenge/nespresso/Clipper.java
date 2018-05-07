package com.sqli.challenge.nespresso;

public class Clipper extends Ship{

    public static final double speedToadd = 0.2;

    public Clipper(int numberOfHulls, int numberOfMasts) {
        super(numberOfHulls, numberOfMasts);
    }

    @Override
    public double speed() {
        double normalShipSpeed = super.speed();
        return normalShipSpeed - (normalShipSpeed * speedToadd);
    }
}
