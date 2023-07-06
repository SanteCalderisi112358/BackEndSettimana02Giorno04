package Esercizio01;

public class Customer {
	long id;
	String name;
	Integer tier;

	public Customer(long _id, String _name, Integer _tier) {

		this.id = _id;
		this.name = _name;
		this.tier = _tier;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", tier=" + tier + "]";
	}
}
