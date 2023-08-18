package com.stella.Patient.Service.repository;

import com.stella.Patient.Service.entity.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NotesRepository extends MongoRepository<Notes,String> {

}
