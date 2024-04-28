package net.codejava.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Grade;
import net.codejava.repository.GradeRepository;

@Service
public class GradeService {
	@Autowired 
	GradeRepository repo;
	
	public void save(Grade grade) {
		repo.save(grade);
	}
	public Grade get(Long id) {
		return repo.findById(id).get();
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
}


