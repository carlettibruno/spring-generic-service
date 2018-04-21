package br.com.carlettisolucoes.spring.generic.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository implements CrudRepository<SampleModel, Integer> {

	@Override
	public <S extends SampleModel> S save(S entity) {
		return entity;
	}

	@Override
	public <S extends SampleModel> Iterable<S> saveAll(Iterable<S> entities) {
		entities.forEach(e -> e.setId(1));
		return entities;
	}

	@Override
	public Optional<SampleModel> findById(Integer id) {
		return Optional.of(new SampleModel(1, null));
	}

	@Override
	public boolean existsById(Integer id) {
		return true;
	}

	@Override
	public Iterable<SampleModel> findAll() {
		List<SampleModel> list = new ArrayList<>();
		list.add(new SampleModel(1, null));
		list.add(new SampleModel(2, null));
		return list;
	}

	@Override
	public Iterable<SampleModel> findAllById(Iterable<Integer> ids) {
		return Arrays.asList(new SampleModel());
	}

	@Override
	public long count() {
		return 1;
	}

	@Override
	public void deleteById(Integer id) {
	}

	@Override
	public void delete(SampleModel entity) {
	}

	@Override
	public void deleteAll(Iterable<? extends SampleModel> entities) {
	}

	@Override
	public void deleteAll() {
	}
	
}