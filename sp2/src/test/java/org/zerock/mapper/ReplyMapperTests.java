package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private ReplyService service;
	
	@Test
	public void testTX() {
		// 성공하는 코드 
		service.addTest("hong Gil Dong");
	}
	
	private int[] bnoArr = {2032 , 2031, 2030, 1676, 1674};
	
	@Test
	public void insetTest() {
		
		IntStream.rangeClosed(1, 10).forEach(i->{
			
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글"+i);
			vo.setReplyer("쓴사람"+i);
			
			mapper.insert(vo);
		});		
}
	
	@Test
	public void testList() {
		mapper.list(2030,2).forEach(vo -> log.info(vo));	
	}
	@Test
	public void testrereply() {
		ReplyVO vo = new ReplyVO();
		int rno = 12;
		vo.setBno(2030);
		vo.setRno2(rno);
		vo.setReply("대댓글");
		vo.setReplyer("대댓글자");
		
		mapper.rereply(vo);
		
	}
	@Test
	public void testupdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(17);
		vo.setReply("수정댓글");
		service.modify(vo);
		
	}
	
	

}
