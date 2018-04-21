package br.com.carlettisolucoes.spring.generic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.carlettisolucoes.spring.generic.model.CrudModel;

@Service
public abstract class CrudService<T extends CrudModel<ID>, ID> {

	private CrudRepository<T, ID> repo;
	
	@Autowired
	public CrudService(CrudRepository<T, ID> repo) {
		this.repo = repo;
	}
	
	public T create(T t) {
		return repo.save(t);
	}
	
	public Optional<T> read(ID id) {
		return repo.findById(id);
	}
	
	public T update(T t, ID id) {
		//TODO
		return repo.save(t);
	}
	
	public void delete(ID id) {
		repo.deleteById(id);
	}
	
	public Iterable<T> findAll() {
		return repo.findAll();
	}

}