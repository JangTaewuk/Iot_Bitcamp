package org.zerock.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class BoardMapperTests {

	@Autowired
	BoardMapper mapper;


	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();

		vo.setTitle("1231231");
		vo.setContent("JTW");
		vo.setWriter("user121");

		mapper.insert(vo);
	}

	@Test
	public void testlist() {

		BoardVO vo = mapper.select(8);

		log.info(vo);
	}
	@Test
	public void testupdate() {
		BoardVO vo = mapper.select(18);
		vo.setTitle("수정된제목");
		vo.setContent("수정된내용");
		
		int count = mapper.update(vo);
		log.info("update count" + count);
		
	}
	@Test
	public void testdelete() {
		int count = mapper.delete(19);
		log.info("delete count" + count);
	}
	@Test
	public void testpage() {
		// 1page 10amount , 0skip
		Criteria cti = new Criteria();
		cti.setPage(2);
		
		mapper.selectPage(cti).forEach(vo->log.info(vo));
		
	}
	@Test
	public void testpagemaker() {
		Criteria cri = new Criteria();
		cri.setPage(11);
		PageMaker pm = new PageMaker(cri, 201);
		
		log.info(pm);
		log.info(pm.getLink("/board/list", 3));
		
	}
	

}
