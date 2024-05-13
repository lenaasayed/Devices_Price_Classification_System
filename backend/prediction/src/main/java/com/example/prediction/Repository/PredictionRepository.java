package com.example.prediction.Repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.prediction.Model.Prediction;

@Repository
//repository interface to handle mongo database operations
public interface PredictionRepository  extends MongoRepository<Prediction,Integer> {
    @Query("{count:?0}")
    Optional<Prediction>  findByCount(Integer count);

}