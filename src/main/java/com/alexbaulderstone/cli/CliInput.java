package com.alexbaulderstone.cli;

import java.util.Scanner;

import com.alexbaulderstone.gamelogic.IGameInput;
import com.alexbaulderstone.gamelogic.PlayerAction;

public class CliInput implements IGameInput {
    private Scanner s;

    public CliInput() {
        s = new Scanner(System.in);
    }

    @Override
    public String getValidCoordinate(byte gridSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValidCoordinate'");
    }

    @Override
    public byte getGridSize() {
        byte gridSize = 0;
        while (gridSize < 2 || gridSize > 10) {
            System.out.println("Please enter a grid size between 2-10");
            gridSize = s.nextByte();
        }
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
