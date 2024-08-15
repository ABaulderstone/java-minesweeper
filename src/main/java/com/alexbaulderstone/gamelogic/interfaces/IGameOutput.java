package com.alexbaulderstone.gamelogic.interfaces;

import com.alexbaulderstone.gamelogic.board.Board;

public interface IGameOutput {
    public void drawBoard(Board board);

    public void displayLossMessage();
}
