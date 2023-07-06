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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", tier=" + tier + "]";
	}
}
