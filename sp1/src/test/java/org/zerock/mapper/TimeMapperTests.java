package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.service.HelloServiceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class TimeMapperTests {
	
	@Autowired
	TimeMapper timeMapper;
	
	@Autowired
	TimeDiffMapper diffMapper;
	
	@Test
	public void testNow() {
		
		log.info(timeMapper.getClass().getName());
		
		log.info(timeMapper.getTime());
		
	};
	@Test
	public void testDiff() {
		log.info(diffMapper.calcGap());
	}
	@Test
	public void testDiff2() {
		log.info(diffMapper.calcGapDay("2018-04-30"));
	}
	
	@Test
	public void testTime2() {
		log.info(timeMapper.getTime2());
	}
	
	

}
