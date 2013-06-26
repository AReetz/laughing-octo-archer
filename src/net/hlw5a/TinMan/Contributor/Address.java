package net.hlw5a.TinMan.Contributor;

public class Address {
	
	public static Address Create(String Address)  {
        if (Address != null) return new Address(Address);
        return new Address("[CITY],[COUNTRY]");
    }
    
	private String suite;
	private String number;
    private String street;
    private String city;
    private String state;
    private String country;
    
    public String getCity() { return city; }
	public String getState() { return state; }
	public String getCountry() { return country; }

    public Address(String Address)  {
        String[] address = Address.split(",");
        this.city = address[0].trim();
        if (address.length == 2) {
            this.country = address[1].trim();
        }
        else if (address.length == 3)  {
            this.state = address[1].trim();
            this.country = address[2].trim();
        }
    }

    @Override
	public String toString() {
    	StringBuilder sb = new StringBuilder();
    	if (suite != null) sb.append("#").append(suite).append("-");
    	if (number != null) sb.append(number).append(" ");
    	if (street != null) sb.append(street).append(", ");
    	sb.append(city).append(", ");
    	if (state != null) sb.append(state).append(", ");
    	sb.append(country);
    	return sb.toString();
	}
}

