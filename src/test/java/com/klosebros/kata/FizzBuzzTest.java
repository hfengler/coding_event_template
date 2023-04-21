package com.klosebros.kata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class FizzBuzzTest {

    @Test
    void shouldCountOne() {
        Assertions.assertThat(FizzBuzz.count(1)).isEqualTo("1");
    }
}