package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Criteria {
	
	private int page;
	private int amount;
	
	public Criteria() {
		this.page = 1;
		this.amount = 10;
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
	
	public String getLink() {
		// get방식으로 처리되는 링크 관리 
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("page", page)
				.queryParam("amount", amount);
		
		
		return builder.toUriString();
	}

}
