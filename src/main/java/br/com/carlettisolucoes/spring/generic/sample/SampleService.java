package br.com.carlettisolucoes.spring.generic.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlettisolucoes.spring.generic.service.CrudService;

@Service
public class SampleService extends CrudService<SampleModel, Integer> {

	@Autowired
	public SampleService(SampleRepository repo) {
		super(repo);
	}

}
