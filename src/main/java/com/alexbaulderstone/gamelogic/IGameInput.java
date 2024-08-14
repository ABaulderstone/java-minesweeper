package com.alexbaulderstone.gamelogic;

public interface IGameInput {
    public String getValidCoordinate(byte gridSize);

    public byte getGridSize();

    public boolean getConfirmation();

    public PlayerAction getAction();
}
