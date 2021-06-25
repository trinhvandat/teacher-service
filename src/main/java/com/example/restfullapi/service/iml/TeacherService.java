package com.example.restfullapi.service.iml;

import com.example.restfullapi.model.Teacher;
import java.util.List;

    public interface TeacherService {

        Teacher createTeacher(Teacher teacher);

        Teacher updateTeacher(int teacherId, Teacher teacher);

        Teacher deleteTeacher(int teacherId);

        List<Teacher> listTeacher();
    }


