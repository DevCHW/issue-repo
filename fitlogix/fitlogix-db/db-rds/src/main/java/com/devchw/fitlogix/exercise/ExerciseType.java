package com.devchw.fitlogix.exercise;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExerciseType {

    CHEST("가슴"),
    SHOULDER("어깨"),
    BACK("등"),
    TRICEPS("삼두"),
    BICEP("이두");

    private final String text;

}
