package corrieri.ponza.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import corrieri.ponza.model.Problem;

public interface ProblemRepository extends MongoRepository<Problem, String> {
   

}
