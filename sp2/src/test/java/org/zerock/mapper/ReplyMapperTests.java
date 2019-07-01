package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
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
		mapper.list(2030).forEach(vo -> log.info(vo));	
				
	}
	
	

}
