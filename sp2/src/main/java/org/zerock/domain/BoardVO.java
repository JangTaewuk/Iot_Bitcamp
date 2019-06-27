package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	
	private Integer bno;
	private String title,content,writer;
	
	private String regdate;

}
