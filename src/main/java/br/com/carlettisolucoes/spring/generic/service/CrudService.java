package br.com.carlettisolucoes.spring.generic.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.carlettisolucoes.spring.generic.model.CrudModel;

@Service
public abstract class CrudService<T extends CrudModel<ID>, ID> {
	
	private static final Logger log = LoggerFactory.getLogger(CrudService.class);

	private CrudRepository<T, ID> repo;
	
	@Autowired
	public CrudService(CrudRepository<T, ID> repo) {
		this.repo = repo;
	}
	
	public T create(T t) {
		log.info("Creating {} {}", t.getClass().getName(), t);
		t = repo.save(t);
		log.info("{} created {}", t.getClass().getName(), t);
		return t;
	}
	
	public Optional<T> read(ID id) {
		return repo.findById(id);
	}
	
	public T update(T t, ID id) {
		if(t.getId() == null) {
			throw new IllegalArgumentException("Id is null");
		}
		log.info("updating entity {}", t);
		t = repo.save(t);
		log.info("entity has been updated");
		return t;
	}
	
	public void delete(ID id) {
		repo.deleteById(id);
	}
	
	public Iterable<T> findAll() {
		return repo.findAll();
	}

}