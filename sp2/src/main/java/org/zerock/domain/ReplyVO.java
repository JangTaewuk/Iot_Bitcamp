package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private Integer rno;
	private Integer rno2;
	private Integer bno;
	private String reply;
	private String replyer;
	private boolean gubun;
	private Date replyDate;
	private Date updateDate;

}
