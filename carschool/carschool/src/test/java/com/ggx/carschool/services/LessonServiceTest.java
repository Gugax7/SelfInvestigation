package com.ggx.carschool.services;

import com.ggx.carschool.entities.*;
import com.ggx.carschool.enums.VehicleType;
import com.ggx.carschool.repositories.CarRepository;
import com.ggx.carschool.repositories.LessonRepository;
import com.ggx.carschool.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class LessonServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private LessonRepository lessonRepository;
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private LessonService lessonService;


    @Test
    void shouldCreateCarLessonWhenInstructorIsAuthorized() {
        Long instructorId = 1L;
        Long carId = 10L;
        Long studentId = 2L;

        User instructor = new User();
        instructor.setId(instructorId);
        instructor.setAuthorizedVehicleType(List.of(VehicleType.CAR));

        User student = new User();
        student.setId(studentId);

        Car car = new Car();
        car.setId(carId);

        Mockito.when(userRepository.findById(instructorId)).thenReturn(Optional.of(instructor));
        Mockito.when(carRepository.findById(carId)).thenReturn(Optional.of(car));
        Mockito.when(userRepository.findById(studentId)).thenReturn(Optional.of(student));

        Mockito.when(lessonRepository.save(any(CarLesson.class))).thenAnswer(i-> i.getArguments()[0]);

        CarLesson createdLesson = lessonService.createCarLesson(instructorId, studentId, carId, LocalDateTime.of(12001,10,10,10,0));

        assertNotNull(createdLesson);
        assertEquals(instructor, createdLesson.getInstructor());
        assertEquals(student, createdLesson.getStudent());
        assertEquals(car, createdLesson.getCar());
    }

    @Test
    void shouldThrowExceptionWhenInstructorIsNotAuthorized(){
        Long instructorId = 1L;
        Long carId = 10L;
        Long studentId = 2L;

        User student = new User();
        student.setId(studentId);

        User badInstructor = new User();
        badInstructor.setId(instructorId);
        badInstructor.setAuthorizedVehicleType(List.of(VehicleType.MOTORCYCLE));

        Mockito.when(userRepository.findById(instructorId)).thenReturn(Optional.of(badInstructor));
        Mockito.when(carRepository.findById(carId)).thenReturn(Optional.of(new Car()));

        assertThrows(RuntimeException.class, () -> {
            lessonService.createCarLesson(instructorId, studentId, carId, LocalDateTime.of(2000, 10,10,10,0));
        });

    }

    @Test
    void shouldThrowExceptionWhenInstructorIsNotAvailable() {
        Long instructorId = 1L;
        Long studentId = 2L;
        LocalDateTime desiredTime = LocalDateTime.of(2025, 10,10,10,0);

        User instructor = new User();
        instructor.setId(instructorId);
        instructor.setAuthorizedVehicleType(List.of(VehicleType.CAR));

        Lesson existingLesson = new CarLesson();
        existingLesson.setStartTime(LocalDateTime.of(2025,10,10,9,30));

        Mockito.when(userRepository.findById(instructorId)).thenReturn(Optional.of(instructor));
        Mockito.when(userRepository.findById(studentId)).thenReturn(Optional.of(new User()));
        Mockito.when(carRepository.findById(anyLong())).thenReturn(Optional.of(new Car()));

        Mockito.when(lessonRepository
                .findConflicts(eq(instructor), any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(List.of(existingLesson));

        assertThrows(RuntimeException.class, () -> {
            lessonService.createCarLesson(instructorId, studentId, 1L, desiredTime);
        });

    }

    @Test
    void shouldCreateLessonIfInstructorJustFinishedAClass(){
        long instructorId = 1L;
        long studentId = 2L;
        long carId = 1L;

        LocalDateTime classAt10 = LocalDateTime.of(2026, 10, 10, 10, 0);
        LocalDateTime classAt11 = LocalDateTime.of(2026, 10, 10, 11, 0);

        User instructor = new User();
        instructor.setId(instructorId);
        instructor.setAuthorizedVehicleType(List.of(VehicleType.CAR));

        Mockito.when(userRepository.findById(instructorId)).thenReturn(Optional.of(instructor));
        Mockito.when(userRepository.findById(studentId)).thenReturn(Optional.of(new User()));
        Mockito.when(carRepository.findById(anyLong())).thenReturn(Optional.of(new Car()));

        Mockito.when(lessonRepository.findConflicts(
                eq(instructor),
                eq(classAt11.minusHours(1)),
                eq(classAt11.plusHours(1))
        )).thenReturn(Collections.emptyList());

        CarLesson result = lessonService.createCarLesson(instructorId, 2L, 3L, classAt11);

        assertNotNull(result);
        assertEquals(classAt11, result.getStartTime());
    }

    // TODO: improve last test with DataJpaTest
    // TODO: if student not available, throws a exception too
    // TODO: if some dont exist throw exception
    // TODO: if car is unavailable throw a exception too

    @Test
    void shouldThrowExceptionWhenStudentIsNotAvailable() {

    }

    @Test
    void shouldThrowExceptionWhenSomeDoNotExists() {

    }
}
