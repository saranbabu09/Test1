package com.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressInput_Pojo {
	private String address_id;
    private String first_name;
    private String last_name;
    private String mobile;
    private String apartment;
    private int state;
    private int city;
    private int country;
    private String zipcode;
    private String address;
    private String address_type;

}
