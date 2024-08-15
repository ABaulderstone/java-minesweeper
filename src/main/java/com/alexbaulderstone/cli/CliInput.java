package com.alexbaulderstone.cli;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alexbaulderstone.gamelogic.IGameInput;
import com.alexbaulderstone.gamelogic.InvalidInputCallback;
import com.alexbaulderstone.gamelogic.PlayerAction;

public class CliInput implements IGameInput {
    private Scanner s;

    public CliInput() {
        s = new Scanner(System.in);
    }

    @Override
    public String getValidCoordinate(byte gridSize, InvalidInputCallback cb) {
        String coordinate;
        String regex = "^[A-" + (char) ('A' + (gridSize - 1)) + "][0-" + (gridSize - 1) + "]$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            System.out.println("Please enter a coordinate (e.g., A0) within the grid size:");
            coordinate = s.next().toUpperCase();

            Matcher matcher = pattern.matcher(coordinate);
            if (matcher.matches()) {
                break;
            } else {
                cb.onInvalidInput();
                System.out.println("Invalid coordinate. Please try again.");
            }
        }

        return coordinate;
    }

    @Override
    public byte getGridSize() {
        byte gridSize;
        boolean firstAttempt = true;

        do {
            CliOutput.clearScreen();
            if (!firstAttempt) {
                System.out.println("Invalid input. Please try again.");
            }

            System.out.println("Please enter a grid size between 2-10:");
            gridSize = s.nextByte();

            firstAttempt = false;
        } while (gridSize < 2 || gridSize > 10);

        return gridSize;
    }

    @Override
    public boolean getConfirmation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConfirmation'");
    }

    @Override
    public PlayerAction getAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAction'");
    }

    public void close() {
        s.close();
    }
}
