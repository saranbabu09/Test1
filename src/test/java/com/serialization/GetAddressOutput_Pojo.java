package com.serialization;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressOutput_Pojo {
	private int status;
    private String message;
    private ArrayList<Datum> data;

}
