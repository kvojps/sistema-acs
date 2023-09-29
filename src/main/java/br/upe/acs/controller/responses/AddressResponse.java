package br.upe.acs.controller.responses;

import br.upe.acs.model.Address;
import lombok.Getter;

@Getter
public class AddressResponse {

	private final Long id;
	
	private final String cep;
	
	private final String street;
	
	private final String district;
	
	private final String city;
	
	private final String uf;
	
	private final int number;

	public AddressResponse(Address address) {
		super();
		this.id = address.getId();
		this.cep = address.getCep();
		this.street = address.getStreet();
		this.district = address.getDistrict();
		this.city = address.getCity();
		uf = address.getUf();
		this.number = address.getNumber();
	}
	
}
