package com.example.restfullapi.repository;

import com.example.restfullapi.dto.TeacherDto;
import com.example.restfullapi.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Integer>{
    @Override
    Optional<Teacher> findById(Integer id);
}
