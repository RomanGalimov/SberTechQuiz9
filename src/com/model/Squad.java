package com.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Someone on 25.11.2016.
 */
public class Squad implements Cloneable{
    public ArrayList<Warrior> squad;
    private String squadName;

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getSquadName() {
        return squadName;
    }

    public void addWarriorToSquad(Warrior warrior) {
        squad.add(warrior);
        warrior.setSquadName(squadName);
    }

    public Warrior getRandomWarrior() {
        Random random = new Random();
        while (true) {
            Warrior warrior = squad.get(random.nextInt(squad.size()));
            if (warrior.isAlive())
                return warrior;
        }
    }

    public boolean hasAliveWarriors() {
        for (Warrior warrior : squad) {
            if (warrior.isAlive())
                return true;
        }
        return false;
    }

    public Squad() {
        squad = new ArrayList<>();
    }

    public Squad(String squadName) {
        squad = new ArrayList<>();
        setSquadName(squadName);
    }

    public ArrayList<String> getSquadWarriorsClassNames() {
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i < squad.size(); i++) {
            s.add(squad.get(i).getWarriorClassName());
        }
        return s;
    }

    @Override
    public String toString() {
        return squadName;
    }

    @Override
    public Squad clone() {
        Squad sq = new Squad(squadName);
        for (Warrior warrior : squad)
            sq.addWarriorToSquad(warrior.clone());
        return sq;
    }
}
