package com.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilePic_Output_Pojo {
	private int status;
    private String message;
    private ProfilePic data;
    private int cart_count;

}
