package com.alexbaulderstone.cli;

public enum ColorText {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    ORANGE("\u001B[38;5;208m"),
    BROWN("\u001B[38;5;94m"),
    TEAL("\u001B[38;5;30m");

    private final String code;

    ColorText(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
