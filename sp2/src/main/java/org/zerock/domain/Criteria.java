package org.zerock.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Criteria {
	
	private int page;
	private int amount;
	private Integer bno; // 인트는 0 인티저는 null
	private String type;
	private String keyword;
	
	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public void setPage(int page) {
		this.page = page<=0 ? 1: page;
	}

	public void setAmount(int amount) {
		this.amount = amount <= 10 ? 10 : amount;
	}
	
	public int getskip() {
		
		return (this.page -1)* this.amount;
	}
	public Map<String,String> getMap() {
		if(type==null || type.trim().length()==0) {
			 return null;
		}
		// T,C,W
		String[] arr = type.split("");
	
		Map<String,String> map = new HashMap<>();
		
		for (String word : arr) {
			map.put(word, keyword);
		}
		return map;
	}
	
	public String getLink() {
		// get방식으로 처리되는 링크 관리 
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("page", page)
				.queryParam("amount", amount)
		.queryParam("type", type)
		.queryParam("keyword", keyword);
		
		
		return builder.toUriString();
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	


}
