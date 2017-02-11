package com.model;

import java.util.ArrayList;

/**
 * Created by Someone on 25.11.2016.
 */
public class Battle {
    public ArrayList<String> battleResults;
    public Squad squad1;
    public Squad squad2;


    public Battle() {
        squad1 = new Squad();
        squad2 = new Squad();
        battleResults = new ArrayList<>();
    }

    public void startBattle() {
        Warrior warrior1;
        Warrior warrior2;
        int i = 0;
        // Дата начала сражения
        DateHelper dateHelper = new DateHelper();
        battleResults.add(dateHelper.getFormattedStartDate());


        while (true) {
            if (squad1.hasAliveWarriors() && squad2.hasAliveWarriors()) {
                warrior1 = squad1.getRandomWarrior();
                warrior2 = squad2.getRandomWarrior();
                dateHelper.skipTime();

                if (i % 2 == 0) {
                    battleResults.add(warrior1 + " отряда " + squad1.getSquadName()
                            + " атакует " + warrior2 + " отряда " + squad2.getSquadName());
                    warrior1.attack(warrior2);
                } else {
                    battleResults.add(warrior2 + " отряда " + squad2.getSquadName()
                            + " атакует " + warrior1 + " отряда " + squad1.getSquadName());
                    warrior2.attack(warrior1);
                }
                i++;
                //System.out.println(i);
            } else {
                break;
            }
        }
        // Время окончания сражения
        battleResults.add(dateHelper.getFormattedDiff() + "\n");

        if (squad1.hasAliveWarriors())
            battleResults.add("Отряд " + squad1.getSquadName() + " победил!\n");
        else
            battleResults.add("Отряд " + squad2.getSquadName() + "  победил!\n");
    }
}
