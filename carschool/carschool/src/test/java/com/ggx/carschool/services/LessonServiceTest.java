package com.ggx.carschool.services;

import com.ggx.carschool.entities.Car;
import com.ggx.carschool.entities.CarLesson;
import com.ggx.carschool.entities.User;
import com.ggx.carschool.entities.Vehicle;
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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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

        Mockito.when(lessonRepository.save(Mockito.any(CarLesson.class))).thenAnswer(i-> i.getArguments()[0]);

        CarLesson createdLesson = lessonService.createCarLesson(instructorId, studentId, carId);

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
            lessonService.createCarLesson(instructorId, studentId, carId);
        });

    }
}
