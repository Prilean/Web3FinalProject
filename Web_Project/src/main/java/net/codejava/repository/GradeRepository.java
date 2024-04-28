package net.codejava.repository;

import org.springframework.data.repository.CrudRepository;
import net.codejava.model.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long>{

}
