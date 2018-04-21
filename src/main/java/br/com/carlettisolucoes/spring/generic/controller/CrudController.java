package br.com.carlettisolucoes.spring.generic.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import br.com.carlettisolucoes.spring.generic.model.CrudModel;
import br.com.carlettisolucoes.spring.generic.service.CrudService;

public abstract class CrudController<T extends CrudModel<ID>, ID> {

	private CrudService<T, ID> service;
	
	@Autowired
	public CrudController(CrudService<T, ID> service) {
		this.service = service;
	}
	
	private URI uriLocationResponse(ID id) {
		UriComponents ucb = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + id).build();
		return ucb.toUri();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody T t) {
		T obj = service.create(t);
		return ResponseEntity.created(uriLocationResponse(obj.getId())).build();
	}
		
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<T> read(@PathVariable ID id) {
		Optional<T> t = service.read(id);
		if(t.isPresent())
			return ResponseEntity.ok(t.get());
		else 
			return ResponseEntity.notFound().build();
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Iterable<T>> findAll() {
		Iterable<T> ts = service.findAll();
		return ResponseEntity.ok(ts);
	}	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Void> update(@PathVariable ID id, @RequestBody T t) {
		service.update(t, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable ID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}