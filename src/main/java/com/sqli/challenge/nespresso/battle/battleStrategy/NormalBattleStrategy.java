package com.sqli.challenge.nespresso.battle.battleStrategy;

import com.sqli.challenge.nespresso.battle.teams.Team;

public class NormalBattleStrategy implements BattleStrategy {

    private static final double DAMAGE_BONUS = 0.15;

    @Override
    public void startBattle(Team firstTeam, Team secondTeam) {

        while (!firstTeam.isSunk() && !secondTeam.isSunk()) {
            double firstTeamDamage = firstTeam.AvailableShips() > secondTeam.AvailableShips() ? firstTeam.getTotalDamage() + firstTeam.getTotalDamage() * DAMAGE_BONUS : firstTeam.getTotalDamage();
            double secondTeamDamage = secondTeam.AvailableShips() > firstTeam.AvailableShips() ? secondTeam.getTotalDamage() + secondTeam.getTotalDamage() * DAMAGE_BONUS : secondTeam.getTotalDamage();
            firstTeam.NextShip().takeNormalDamage(secondTeamDamage);
            secondTeam.NextShip().takeNormalDamage(firstTeamDamage);
        }
    }
}
