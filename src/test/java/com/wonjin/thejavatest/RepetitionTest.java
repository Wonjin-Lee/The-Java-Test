package com.wonjin.thejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RepetitionTest {

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition} / {totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("Test " + repetitionInfo.getCurrentRepetition() + " / " +repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("반복 테스트(파라미터)")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"봄", "여름", "가을", "겨울"})
    void parameterizedTest(String message) {
        System.out.println(message);
    }
}
