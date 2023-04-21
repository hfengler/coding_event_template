package com.klosebros.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinesweeperTest {

    @Test
    void nonMineFound() {
        //GIVEN
        var matrix = new boolean[][]{ {false, false, false, false},
                                      {false, false, false, false},
                                      {false, false, false, false},
                                      {false, false, false, false}};
        var minesweeper = new Minesweeper();
         //WHEN
        var result = minesweeper.findMines(matrix);
        //THEN

        assertThat(false).isTrue();
    }
}