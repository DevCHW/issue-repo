package com.devchw.fitlogix.exercise;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exercises")
public class ExerciseController {

    private final ExerciseReader exerciseService;

    @GetMapping
    public String ok() {
        log.info("컨트롤러 호출댐");
        return "ok";
    }

}
