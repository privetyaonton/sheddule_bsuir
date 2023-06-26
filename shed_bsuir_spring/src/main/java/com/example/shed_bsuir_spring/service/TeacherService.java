package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.dto.DepartamentDTO;
import com.example.shed_bsuir_spring.dto.FacultyDTO;
import com.example.shed_bsuir_spring.dto.FailedSetDTO;
import com.example.shed_bsuir_spring.dto.TeacherDTO;
import com.example.shed_bsuir_spring.entity.DepartamentEntity;
import com.example.shed_bsuir_spring.entity.FacultyEntity;
import com.example.shed_bsuir_spring.entity.TeacherEntity;
import com.example.shed_bsuir_spring.repo.DepartamentRepository;
import com.example.shed_bsuir_spring.repo.FacultyRepository;
import com.example.shed_bsuir_spring.repo.TeacherRepository;
import com.example.shed_bsuir_spring.request.TeacherRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartamentRepository departamentRepository;
    @Autowired
    private FacultyRepository facultyRepository;

    @Transactional
    public void deleteById (int id) throws NotFoundException{
        if (teacherRepository.existsById(id)){

            teacherRepository.deleteById(id);
        } else throw new NotFoundException();
    }
    public void add (TeacherRequest teacherRequest) throws NoContentException{
        if (teacherRequest.getName() != null && teacherRequest.getSurname() != null &&
        teacherRequest.getParentName() != null && departamentRepository.existsById(
                teacherRequest.getDepartamentID()
        )){
            teacherRepository.save(new TeacherEntity(teacherRequest.getName(),
                    teacherRequest.getSurname(), teacherRequest.getParentName(),
                    departamentRepository.findById(teacherRequest.getDepartamentID())));
        } else throw new NoContentException();
    }
    public List<TeacherDTO> listAll (){
        List<TeacherEntity> teacherEntityList = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        for (TeacherEntity teacherEntity : teacherEntityList){
            teacherDTOList.add(new TeacherDTO(teacherEntity.getName(),
                    teacherEntity.getSurname(), teacherEntity.getParentName(),
                    teacherEntity.getDepartamentEntity().getName(), teacherEntity.getId()));
        }
        return teacherDTOList;
    }

}
