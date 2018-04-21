package br.com.carlettisolucoes.spring.generic.sample;

import br.com.carlettisolucoes.spring.generic.model.CrudModel;

public class SampleModel implements CrudModel<Integer> {

	private static final long serialVersionUID = -1019290640920099046L;

	private Integer someId;
	
	private String someAttribute;

	public SampleModel() {
	}
	
	public SampleModel(Integer someId, String someAttribute) {
		super();
		this.someId = someId;
		this.someAttribute = someAttribute;
	}

	public Integer getSomeId() {
		return someId;
	}

	public void setSomeId(Integer someId) {
		this.someId = someId;
	}

	public String getSomeAttribute() {
		return someAttribute;
	}

	public void setSomeAttribute(String someAttribute) {
		this.someAttribute = someAttribute;
	}

	@Override
	public String toString() {
		return "SampleModel [someId=" + someId + ", someAttribute=" + someAttribute + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((someId == null) ? 0 : someId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SampleModel other = (SampleModel) obj;
		if (someId == null) {
			if (other.someId != null)
				return false;
		} else if (!someId.equals(other.someId))
			return false;
		return true;
	}

	@Override
	public Integer getId() {
		return this.someId;
	}

	@Override
	public void setId(Integer id) {
		this.someId = id;
	}
	
}
