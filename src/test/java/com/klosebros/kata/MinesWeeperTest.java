package com.klosebros.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinesWeeperTest {

    private MinesWeeper game;

    @BeforeEach
    void setUp() {
        game = new MinesWeeper();
    }

    @Test
    void Scenario1()
    {
        assertThat(game.getHints(".")).isEqualTo("0");
    }

    @Test
    void singleNeighbourOfMineShouldBeOne() {
        assertThat(game.getHints("..*")).isEqualTo("01*");
    }

    @Test
    void shouldCountMinesOnOneLine() {
        assertThat(game.getHints("..*.*")).isEqualTo("01*2*");
    }
}