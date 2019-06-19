package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class BoardMapperTests {
	
	@Autowired
	BoardMapper mapper;
	
	
	@Test
	public void testInsert(){
		BoardVO vo = new BoardVO();
		
		vo.setTitle("»ùÇÃ");
		vo.setContent("»ùÇÃ³»¿ë");
		vo.setWriter("user121");
		
		mapper.insert(vo);
		}
	@Test
	public void testlist() {
		
		BoardVO vo = mapper.select(5);
		
		log.info(vo);
		
		
	}
	
}
