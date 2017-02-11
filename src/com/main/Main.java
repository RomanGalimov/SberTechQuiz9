package com.main;

import com.controller.BattleController;
import com.view.BattleView;
import com.model.Battle;

public class Main {

    public static void main(String[] args) {
        BattleView battleView = new BattleView();

        Battle battle = new Battle();

        new BattleController(battleView, battle);
    }
}
