package com.controller;

import com.model.Warrior;
import com.model.WarriorFactory;
import com.view.BattleView;
import com.model.Battle;
import com.model.Squad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Someone on 04.02.2017.
 */
public class BattleController {
    private BattleView battleView;
    private Battle battle;

    public BattleController (BattleView battleView, Battle battle) {
        this.battle = battle;
        this.battleView = battleView;
        this.battleView.addStartBattleListener(e -> {
                    battle.squad1.setSquadName(battleView.getFirstSquadName());
                    battle.squad2.setSquadName(battleView.getSecondSquadName());
                    battle.startBattle();
                    battleView.setBattleResults(battle.battleResults);
        }
        );
        this.battleView.addWarriorToSquadButtonListener(e -> {
            WarriorFactory warriorFactory = new WarriorFactory();
            Warrior warrior = warriorFactory.makeNewWarrior(battleView.getWarriorTypeComboBoxValue());
            if (battleView.getSquadComboBoxValue().equals("Squad 1")) {
                battle.squad1.addWarriorToSquad(warrior);
            }
            else {
                battle.squad2.addWarriorToSquad(warrior);
            }
        });
    }
}