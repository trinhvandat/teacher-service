package com.example.restfullapi.controller;

import com.example.restfullapi.dto.TeacherDto;
import com.example.restfullapi.model.Teacher;
import com.example.restfullapi.service.iml.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {


    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) {
        final TeacherDto createdTeacher = teacherService.createTeacher(teacherDto);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/{teacher_id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable("teacher_id") int teacherId,
                                                    @RequestBody TeacherDto teacherDto) {
        final TeacherDto updatedTeacher = teacherService.updateTeacher(teacherId, teacherDto);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);

    }

    @DeleteMapping("/{teacher_id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("teacher_id") int teacherId) {
        teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Teacher>> listTeachers() {
        final List<Teacher> teachers = teacherService.listTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/{teacher_id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("teacher_id") int teacherId) {
        final TeacherDto getTeacherById = teacherService.getTeacherById(teacherId);
        return new ResponseEntity<>(getTeacherById, HttpStatus.OK);
    }
}

