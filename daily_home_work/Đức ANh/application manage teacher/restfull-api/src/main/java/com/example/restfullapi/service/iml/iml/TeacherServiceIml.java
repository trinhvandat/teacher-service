package com.example.restfullapi.service.iml.iml;

import com.example.restfullapi.model.Teacher;
import com.example.restfullapi.repository.TeacherRepository;
import com.example.restfullapi.service.iml.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceIml implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceIml(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(int teacherId, Teacher teacherReq) {
        return teacherRepository.findById(teacherId)
                .map(teacher -> {
                    teacher.setName(teacherReq.getName());
                    teacher.setGmail(teacherReq.getGmail());
                    teacher.setAge(teacherReq.getAge());
                    return teacher;
                })
                .map(teacherRepository::save)
                .orElse(null);
    }

    @Override
    public Teacher deleteTeacher(int teacherId) {
        return teacherRepository.findById(teacherId)
                .map(teacher -> {
                    teacherRepository.delete(teacher);
                    return teacher;
                })
                .orElse(null);
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherRepository.findAll();
    }
}

