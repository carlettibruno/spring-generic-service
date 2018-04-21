package br.com.carlettisolucoes.spring.generic.model;

import java.io.Serializable;

public interface CrudModel<ID> extends Serializable {

	ID getId();

	void setId(ID id);

}
