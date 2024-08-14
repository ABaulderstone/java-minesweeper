package com.alexbaulderstone.gamelogic;

public class Game {
    private IGameInput input;
    private GameState gameState;

    enum GameState {
        PLAYING,
        WON,
        LOST
    }

    public Game(IGameInput input) {
        this.input = input;
    }

    public void run() {
        this.setUp();
        while (gameState == GameState.PLAYING) {

        }
    }

    private void setUp() {
        byte gridSize = input.getGridSize();
        this.gameState = GameState.PLAYING;

    }

    private void playerTurn() {
        PlayerAction action = input.getAction();
        switch (action) {
            case FLAG:
                break;
            case REVEAL:
                break;
            case GIVEUP:
                break;
        }
    }
}
