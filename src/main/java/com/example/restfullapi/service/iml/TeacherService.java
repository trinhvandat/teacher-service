package com.example.restfullapi.service.iml;

import com.example.restfullapi.model.Teacher;
import com.example.restfullapi.dto.TeacherDto;

import java.util.List;

    public interface TeacherService {

        TeacherDto createTeacher(TeacherDto teacherDto);

        TeacherDto updateTeacher(int teacherId, TeacherDto teacherDto);

        Teacher deleteTeacher(int teacherId);

        List<Teacher> listTeachers();

    }


