package net.hlw5a.TinMan.Contributor;

public class Publisher implements IPublisher {

	private String name;
	private Address address;
	
    public String getName() { return name; }
    public String getAddress() { return address.toString(); }

    public Publisher(String Name, String Address) {
        this.name = Name;
        this.address = net.hlw5a.TinMan.Contributor.Address.Create(Address);
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
