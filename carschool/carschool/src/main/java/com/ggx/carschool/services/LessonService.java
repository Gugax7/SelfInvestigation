package com.ggx.carschool.services;

import com.ggx.carschool.entities.Car;
import com.ggx.carschool.entities.CarLesson;
import com.ggx.carschool.entities.Lesson;
import com.ggx.carschool.entities.User;
import com.ggx.carschool.enums.VehicleType;
import com.ggx.carschool.repositories.CarRepository;
import com.ggx.carschool.repositories.LessonRepository;
import com.ggx.carschool.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public class LessonService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final LessonRepository lessonRepository;

    public LessonService(UserRepository userRepo, CarRepository carRepo, LessonRepository lessonRepo){
        this.carRepository = carRepo;
        this.lessonRepository = lessonRepo;
        this.userRepository = userRepo;
    }

    public CarLesson createCarLesson(Long instructorId, Long studentId, Long carId, LocalDateTime desiredTime){
        Car car = carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException("Car not found with ID: " + carId));
        User instructor = userRepository.findById(instructorId).orElseThrow(() -> new EntityNotFoundException("Instructor not found with ID: " + instructorId));
        User student = userRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));


        LocalDateTime startWindow = desiredTime.minusHours(1);
        LocalDateTime endWindow = desiredTime.plusHours(1);

        List<Lesson> conflicts = lessonRepository.findConflicts(instructor, startWindow, endWindow);

        if(!conflicts.isEmpty()){
            throw new RuntimeException("Instructor is busy at this time");
        }

        if(instructor.getAuthorizedVehicleType() == null ||!instructor.getAuthorizedVehicleType().contains(VehicleType.CAR)){
            throw new RuntimeException("The instructor is not allowed to make a class with a car");
        }

        CarLesson lesson = new CarLesson();
        lesson.setInstructor(instructor);
        lesson.setStudent(student);
        lesson.setCar(car);
        lesson.setStartTime(desiredTime);

        return lessonRepository.save(lesson);
    }
}
