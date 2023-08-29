package com.devchw.fitlogix.exercise;

import com.devchw.fitlogix.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Exercise extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    private int count;

    private int setCount;

    private String name;

    @Builder
    public Exercise(ExerciseType exerciseType, int count, int setCount, String name) {
        this.exerciseType = exerciseType;
        this.count = count;
        this.setCount = setCount;
        this.name = name;
    }

}
