package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.StoreVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class BoardMapperTests {
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	StoreMapper smapper;
	
	
	@Test
	public void testInsert(){
		BoardVO vo = new BoardVO();
		
		vo.setTitle("샘플");
		vo.setContent("샘플내용");
		vo.setWriter("user121");
		
		mapper.insert(vo);
		}
	@Test
	public void testlist() {
		
		BoardVO vo = mapper.select(5);
		
		log.info(vo);
		
		
		
		
	}
	@Test
	public void gettimeTest() {
		smapper.getTime();		
		
	}
	
	@Test
	public void inserttest() {
		StoreVO vo = new StoreVO();
		
		vo.setName("장태욱");
		vo.setMenu("소주");
		vo.setLat(36.12);
		vo.setLng(127.125);
		
		smapper.insert(vo);
		
	}
	@Test
	public void getlisttest() {
		List<StoreVO> list = smapper.getList();
		
		for(int i=0; i<list.size();i++) {
			log.info(list.get(i));
		}
	}
	@Test
	public void deleteTest() {
		smapper.delete(8);
		
	}
	
	
	
	
}
