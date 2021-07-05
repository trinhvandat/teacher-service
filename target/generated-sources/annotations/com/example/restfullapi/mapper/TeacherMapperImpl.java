package com.example.restfullapi.mapper;

import com.example.restfullapi.dto.TeacherDto;
import com.example.restfullapi.model.Teacher;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-30T14:36:22+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDto convertToDto(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setId( teacher.getId() );
        teacherDto.setName( teacher.getName() );
        teacherDto.setAge( teacher.getAge() );
        teacherDto.setGmail( teacher.getGmail() );

        return teacherDto;
    }

    @Override
    public Teacher convertToEntity(TeacherDto teacherDto) {
        if ( teacherDto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherDto.getId() );
        teacher.setName( teacherDto.getName() );
        teacher.setAge( teacherDto.getAge() );
        teacher.setGmail( teacherDto.getGmail() );

        return teacher;
    }
}
