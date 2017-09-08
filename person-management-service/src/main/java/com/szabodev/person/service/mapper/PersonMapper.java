package com.szabodev.person.service.mapper;

import com.szabodev.person.model.Person;
import com.szabodev.person.service.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO toDTO(Person person);

    Person toEntity(PersonDTO personDTO);

    List<PersonDTO> toDTOs(List<Person> persons);

}
