package org.zerock.mapper;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		cti.setAmount(20);
		cti.setType("W");
		cti.setKeyword("");
		
		
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
	@Test
	public void searchtest() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "샘플");
		map.put("C", "샘플");
		map.put("W", "샘플");
		
		
		mapper.search(map);
	}
	@Test
	public void testMap() {
		String type = "TCW";
		String keyword = "홍길동";
		
		if(type==null || type.trim().length()==0) {
			// return null;
		}
		
		// T,C,W
		String[] arr = type.split("");
		
		log.info(Arrays.toString(arr));
		
		Map<String,String> map = new HashMap<>();
		
		for (String word : arr) {
			map.put(word, keyword);
		}
		
		log.info(map);
		
		
		
		
	}
	

}
