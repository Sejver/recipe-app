package jasko.jasmin.recipe.repositories;

import jasko.jasmin.recipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {


    Optional<UnitOfMeasure> findByDescription(String description);
}
