package com.klosebros.kata;

public class MinesWeeper {

    public String getHints(String input) {
        char[] fields = input.toCharArray();
        String[] hints = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            hints[i] = countNeighbors(i, fields);
        }

        return String.join("", hints);
    }

    private String countNeighbors(int index, char[] fields) {
        if (fields[index] == '*') {
            return "*";
        }
        int counter = 0;

        if (index > 0 && fields[index - 1] == '*') {
            counter++;
        }

        if (index < fields.length - 1 && fields[index + 1] == '*') {
            counter++;
        }
        return String.valueOf(counter);
    }
}
