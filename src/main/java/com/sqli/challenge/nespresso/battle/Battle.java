package com.sqli.challenge.nespresso.battle;

import com.sqli.challenge.nespresso.Ship;
import com.sqli.challenge.nespresso.battle.battleStrategy.BattleStrategy;
import com.sqli.challenge.nespresso.battle.battleStrategy.LocalizedBattleStrategy;
import com.sqli.challenge.nespresso.battle.battleStrategy.NormalBattleStrategy;
import com.sqli.challenge.nespresso.battle.teams.Team;

public class Battle {
    public static boolean LOCALIZED_DAMAGES = false;
    private Team firstSide;
    private Team secondSide;

    public Battle(boolean localizedDamages) {
        this();
        LOCALIZED_DAMAGES = true;
    }

    public Battle() {
        firstSide = new Team();
        secondSide = new Team();
    }

    public Battle side(Ship... ships) {
        firstSide.addShips(ships);
        return this;
    }

    public Battle against(Ship... ships) {
        secondSide.addShips(ships);
        return this;
    }

    public boolean isInTheWinningSide(Ship ship) {
        BattleStrategy battleStrategy = LOCALIZED_DAMAGES ? new LocalizedBattleStrategy() : new NormalBattleStrategy();
        battleStrategy.startBattle(firstSide , secondSide);
        Team winningSide = Team.winningTeam(firstSide , secondSide);
        return winningSide.contains(ship);
    }

}
