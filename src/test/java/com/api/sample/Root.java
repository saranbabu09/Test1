package com.api.sample;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root {
	private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private ArrayList<Datas> data;
    private Support support;
}
