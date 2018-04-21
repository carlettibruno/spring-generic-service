package br.com.carlettisolucoes.spring.generic.app;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.carlettisolucoes.spring.generic.sample.SampleModel;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
public class AppTest {

    @Autowired
    private TestRestTemplate restTemplate;	
	
	@Test
	public void whenRetrieveById_thenReturnModel() {
		ResponseEntity<SampleModel> entity = restTemplate.getForEntity("/samples/1", SampleModel.class);
		
		Assert.assertEquals(entity.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(entity.getBody().getId(), new SampleModel(1, null).getId());
	}
	
	@Test
	public void whenRetrieveAll_thenReturnList() {
		ResponseEntity<SampleModel[]> entity = restTemplate.getForEntity("/samples", SampleModel[].class);
		
		Assert.assertEquals(entity.getStatusCode(), HttpStatus.OK);
		Assert.assertTrue(entity.getBody().length > 1);
	}
	
	@Test
	public void whenDelete_thenReturnNoContent() throws Exception {
		ResponseEntity<Void> entity = restTemplate.exchange(new RequestEntity<String>(HttpMethod.DELETE, new URI("/samples/1")), Void.class);
		
		Assert.assertEquals(entity.getStatusCode(), HttpStatus.NO_CONTENT);
	}
	
	@Test
	public void whenCreate_thenReturnLocation() throws Exception {
		ResponseEntity<Void> entity = restTemplate.postForEntity("/samples", new SampleModel(1, null), Void.class);
		
		Assert.assertEquals(entity.getStatusCode(), HttpStatus.CREATED);
		Assert.assertEquals(entity.getHeaders().getLocation().toString(), restTemplate.getRootUri() + "/samples/1");
	}
	
	@Test
	public void whenUpdate_thenReturnLocation() throws Exception {
		ResponseEntity<Void> entity = restTemplate.exchange("/samples/1", HttpMethod.PUT, new HttpEntity<SampleModel>(new SampleModel(1, null)), Void.class);

		Assert.assertEquals(entity.getStatusCode(), HttpStatus.NO_CONTENT);
	}	
	
}
