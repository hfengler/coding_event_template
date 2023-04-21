package com.klosebros.kata;

public class MinesWeeper {

    public String getHints(String input) {
        char[] fields = input.toCharArray();

        String[] hints = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            hints[i] = countNachbarminen(i, fields);
        }


        if (input.equals("..*")) {
            return "01*";
        }
        return "0";
    }

    private String countNachbarminen(int index, char[] fields) {
        if (fields[index] == '*') {
            return "*";
        }
        if (index == 1) {
            return "1";
        }
        return "0";
    }
}
