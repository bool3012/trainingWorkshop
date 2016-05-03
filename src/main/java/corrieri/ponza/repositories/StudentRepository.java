package corrieri.ponza.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import corrieri.ponza.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
   

}
