package com.ggx.carschool.services;

import com.ggx.carschool.entities.CarLesson;
import com.ggx.carschool.repositories.CarRepository;
import com.ggx.carschool.repositories.LessonRepository;
import com.ggx.carschool.repositories.UserRepository;

public class LessonService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final LessonRepository lessonRepository;

    public LessonService(UserRepository userRepo, CarRepository carRepo, LessonRepository lessonRepo){
        this.carRepository = carRepo;
        this.lessonRepository = lessonRepo;
        this.userRepository = userRepo;
    }

    public CarLesson createCarLesson(Long instructorId, Long studentId, Long carId){
        return null;
    }
}
