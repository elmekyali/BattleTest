package com.sqli.challenge.nespresso.battle.battleStrategy;

import com.sqli.challenge.nespresso.battle.teams.Team;

public class LocalizedBattleStrategy implements BattleStrategy {
    @Override
    public void startBattle(Team firstTeam, Team secondTeam) {

        while (!firstTeam.isSunk() && !secondTeam.isSunk()) {
            double firstTeamDamage = firstTeam.getTotalDamage();
            double secondTeamDamage = secondTeam.getTotalDamage();
            firstTeam.NextShip().takeLocalizedDamage(secondTeamDamage);
            secondTeam.NextShip().takeLocalizedDamage(firstTeamDamage);
        }

    }
}
