package com.wonjin.thejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ConditionCheckTest {

    @Test
    @DisplayName("Assume Assertion")
    void assert_assume() {
        Study study = new Study(2);

        assumingThat(study.getLimit() == 2, () -> {
            System.out.println("Test Start");
        });

        assertEquals(StudyStatus.DRAFT, study.getStatus());
    }

    @DisabledOnOs(OS.WINDOWS)
    @Test
    @DisplayName("OS 체크")
    void check_os() {
        assertThrows(IllegalArgumentException.class, () -> {
            Study study = new Study(-1);
        });
    }

    @DisabledOnJre(JRE.JAVA_11)
    @Test
    @DisplayName("JRE 체크")
    void check_jre_version() {
        assertThrows(IllegalArgumentException.class, () -> {
            Study study = new Study(-1);
        });
    }
}
