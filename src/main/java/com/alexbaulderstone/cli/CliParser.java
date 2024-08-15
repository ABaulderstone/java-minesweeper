package com.alexbaulderstone.cli;

import com.alexbaulderstone.gamelogic.IGameParser;

public class CliParser implements IGameParser {

    @Override
    public byte[] translateCoordinateString(String input) {
        byte[] result = new byte[2];
        result[0] = (byte) (input.charAt(0) - 'A');

        result[1] = Byte.parseByte(input.substring(1));

        return result;
    }

}
