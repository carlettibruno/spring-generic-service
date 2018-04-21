package br.com.carlettisolucoes.spring.generic.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlettisolucoes.spring.generic.controller.CrudController;

@RestController
@RequestMapping("/samples")
public class SampleController extends CrudController<SampleModel, Integer> {
	
	@Autowired
	public SampleController(SampleService service) {
		super(service);
	}

}
