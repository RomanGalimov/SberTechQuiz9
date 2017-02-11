package com.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class BattleView extends JFrame {

    private JButton startBattleButton = new JButton("Start");
    private JTextArea battleResults = new JTextArea();

    private JTextField firstSquadName = new JTextField(10);
    private JTextField secondSquadName = new JTextField(10);

    private String[] warriorTypes = {"Archer", "Viking", "Knight"};
    private String[] squads = {"Squad 1", "Squad 2"};
    private JButton addWarriorToSquadButton = new JButton("Добавить бойца");
    private JComboBox<String> warriorTypeComboBox = new JComboBox<>(warriorTypes);
    private JComboBox<String> squadCombBox = new JComboBox<>(squads);


    public BattleView() {
        JPanel battlePanel = new JPanel();
        JPanel battleResultsPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(battleResults);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setHgap(50);
        gridLayout.setVgap(0);
        this.setLayout(gridLayout);

        battleResults.setPreferredSize(new Dimension(500, 100));
        battleResults.setSize(500, 100);

        battlePanel.add(firstSquadName);
        battlePanel.add(secondSquadName);
        battlePanel.add(warriorTypeComboBox);
        battlePanel.add(squadCombBox);
        battlePanel.add(addWarriorToSquadButton);
        battlePanel.add(startBattleButton);

        this.add(battlePanel);
        this.add(scrollPane);
        pack();

        setVisible(true);
    }

    public String getFirstSquadName() {
        return firstSquadName.getText();
    }

    public String getSecondSquadName() {
        return secondSquadName.getText();
    }



    public void setBattleResults(List<String> list) {
        setTextArea(list, battleResults);
    }

    private void setTextArea(List<String> list, JTextArea textArea) {
        textArea.setText(null); // Очистка
        for (String line: list) {
            textArea.append(line + "\n");
        }
    }

    public void addStartBattleListener(ActionListener listenForStartButton) {
        startBattleButton.addActionListener(listenForStartButton);
    }

    public void addWarriorToSquadButtonListener(ActionListener listenForAddWarriorButton) {
        addWarriorToSquadButton.addActionListener(listenForAddWarriorButton);
    }

    public String getWarriorTypeComboBoxValue() {
        return (String) warriorTypeComboBox.getSelectedItem();
    }

    public String getSquadComboBoxValue() {
        return (String) squadCombBox.getSelectedItem();
    }

    void displayErrorMessage(String errorMessage) {

        JOptionPane.showMessageDialog(this, errorMessage);
    }
}

