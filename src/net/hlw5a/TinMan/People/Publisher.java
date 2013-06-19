package net.hlw5a.TinMan.People;

public class Publisher {

	private String name;
	private Address address;
	
    public String getName() { return name; }
    public Address getAddress() { return address; }

    public Publisher(String Name, String Address) {
        this.name = Name;
        this.address = net.hlw5a.TinMan.People.Address.Create(Address);
    }
    
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != Publisher.class) return false;
		else return ((Publisher)obj).name == this.name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
