package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyService extends GenericService<ReplyVO,Integer>{
	
	public List<ReplyVO> sampleList(Integer bno,int page);
	
	public List<ReplyVO> rereplyList(Integer bno);
	
	public int reply2(ReplyVO vo);
	
	public void addTest(String str);

}
