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

        //WHEN

        //THEN

        assertThat(false).isTrue();
    }
}