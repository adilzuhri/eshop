package vttp2022.paf.assessment.eshop.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;

// DO NOT CHANGE THIS CLASS
public class Customer {

	private String name;
	private String address;
	private String email;

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }

	public String getAddress() { return this.address; }
	public void setAddress(String address) { this.address = address; }

	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }
	
	public static Customer create(SqlRowSet rs) {
		Customer c = new Customer();
		c.setName(rs.getString("Name"));
		c.setAddress(rs.getString("Address"));
		c.setEmail(rs.getString("Email"));
		return c;
	}

	public JsonObject toJSON() {
		return Json.createObjectBuilder()
				.add("Name", getName())
				.add("Company", getAddress())
				.add("Email", getEmail())
				.build();
	}

}

