package com.example.shed_bsuir_spring.service;

import com.example.shed_bsuir_spring.dto.SpeciallityDTO;
import com.example.shed_bsuir_spring.entity.FacultyEntity;
import com.example.shed_bsuir_spring.entity.SpeciallityEntity;
import com.example.shed_bsuir_spring.repo.FacultyRepository;
import com.example.shed_bsuir_spring.repo.SpeciallityRepository;
import com.example.shed_bsuir_spring.request.SpeciallityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpeciallityService {
    @Autowired
    SpeciallityRepository speciallityRepository;
    @Autowired
    FacultyRepository facultyRepository;

    public List<SpeciallityDTO> listAll (){
        List<SpeciallityEntity> speciallityEntityList = speciallityRepository.findAll();
        List<SpeciallityDTO> speciallityDTOList = new ArrayList<>();
        for (SpeciallityEntity speciallityEntity : speciallityEntityList){
            speciallityDTOList.add(new SpeciallityDTO(speciallityEntity.getId(),
                    speciallityEntity.getName(),
                    speciallityEntity.getFacultyEntity().getShort_name()));
        }
        return speciallityDTOList;
    }
    public void updateName (String name, int id) throws NotFoundException{
        if (speciallityRepository.existsById(id)){
            SpeciallityEntity speciallityEntity = speciallityRepository.findById(id);
            speciallityEntity.setName(name);
        } else throw new NotFoundException();
    }
    public void delete (int id) throws NotFoundException{
        if (speciallityRepository.existsById(id)){
            speciallityRepository.deleteById(id);
        } else throw new NotFoundException();
    }
    public void add (SpeciallityRequest speciallityRequest) throws NoContentException{
        if (speciallityRequest.getName() != null && facultyRepository.existsById(
                speciallityRequest.getFacultyID())){
            speciallityRepository.save(new SpeciallityEntity(facultyRepository.findById(
                    speciallityRequest.getFacultyID()), speciallityRequest.getName()));
        } else throw new NoContentException();
    }


}
