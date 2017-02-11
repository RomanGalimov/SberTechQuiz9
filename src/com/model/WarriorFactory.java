package com.model;

/**
 * Created by Someone on 04.02.2017.
 */
public class WarriorFactory {
    public Warrior makeNewWarrior(String warriorType) {
        Warrior warrior = null;
        switch (warriorType) {
            case "Archer":
                warrior = new Archer();
                break;
            case "Knight":
                warrior = new Knight();
                break;
            case "Viking":
                warrior = new Viking();
                break;
        }
        return warrior;
    }

}
