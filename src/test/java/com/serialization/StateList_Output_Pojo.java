package com.serialization;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateList_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<StateNameId> data;

}
