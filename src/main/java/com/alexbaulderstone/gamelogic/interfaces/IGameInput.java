package com.alexbaulderstone.gamelogic.interfaces;

import com.alexbaulderstone.gamelogic.PlayerAction;

public interface IGameInput {
    public String getValidCoordinate(byte gridSize, InvalidInputCallback cb);

    public byte getGridSize();

    public boolean getConfirmation();

    public PlayerAction getAction();
}
