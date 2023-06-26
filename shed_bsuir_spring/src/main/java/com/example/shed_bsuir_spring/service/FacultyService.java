package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.dto.FacultyDTO;
import com.example.shed_bsuir_spring.entity.FacultyEntity;
import com.example.shed_bsuir_spring.repo.FacultyRepository;
import com.example.shed_bsuir_spring.request.FacultyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public List<FacultyDTO> listAll (){
        List<FacultyEntity> facultyEntityList = facultyRepository.findAll();
        List<FacultyDTO> facultyDTOList = new ArrayList<>();
        for (FacultyEntity facultyEntity : facultyEntityList){
            facultyDTOList.add(new FacultyDTO(facultyEntity.getFull_name(),
                    facultyEntity.getShort_name(), facultyEntity.getId()));
        }
        return facultyDTOList;
    }
    public void add (FacultyRequest facultyRequest) throws NoContentException{
        if (facultyRequest.getFullName() != null && facultyRequest.getShortName() != null){
            facultyRepository.save(new FacultyEntity(facultyRequest.getFullName(),
                    facultyRequest.getShortName()));
        } else throw new NoContentException();
    }
    public void update (FacultyRequest facultyRequest, int id) throws NoContentException,
            NotFoundException{
        if (facultyRepository.existsById(id)){
            if (facultyRequest.getShortName() != null && facultyRequest.getFullName() != null){
                FacultyEntity facultyEntity = facultyRepository.findById(id);
                facultyEntity.setFull_name(facultyRequest.getFullName());
                facultyEntity.setShort_name(facultyRequest.getShortName());
                facultyRepository.save(facultyEntity);
            } else throw new NoContentException();
        } else throw new NotFoundException();
    }
    public FacultyDTO getById (int id) throws NotFoundException{
        if (facultyRepository.existsById(id)){
            FacultyEntity facultyEntity = facultyRepository.findById(id);
            return new FacultyDTO(facultyEntity.getFull_name(), facultyEntity.getShort_name(),
                    facultyEntity.getId());
        } else throw new NotFoundException();
    }
    public void delete (Long id) throws NotFoundException{
        if (facultyRepository.existsById(id)){
            facultyRepository.deleteById(id);
        } else throw new NotFoundException();
    }

}
