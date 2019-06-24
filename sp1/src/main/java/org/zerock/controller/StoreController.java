package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.StoreVO;
import org.zerock.mapper.StoreMapper;

import lombok.extern.java.Log;

@RestController
@Log
@RequestMapping("/store/*")
@CrossOrigin
public class StoreController {
	
	@Autowired
	private StoreMapper mapper;


	@PostMapping("/new")
	public void register(@RequestBody StoreVO todo) {

		log.info("add " + todo);
		
		mapper.insert(todo);		
	}
	
	@GetMapping("/all")
	public List<StoreVO> readAll() {
		List<StoreVO> list = mapper.getList();
		
		log.info("read all");
		
		return list;		
	}
	@PostMapping("/{sno}")
	public void remove(@PathVariable("sno") Integer sno) {

		log.info("delete " + sno);
		
		mapper.delete(sno);		
	}

	
	
//	
//	@PutMapping("/{tno}")
//	public void update(@RequestBody TodoVO vo) {
//		
//		log.info("update" );
//		
//		service.modify(vo);
//	}
//	
//	@DeleteMapping("/{tno}")
//	public void remove(@PathVariable("tno") Integer tno) {
//		
//		log.info("remove" );
//		
//		service.remove(tno);
//		
//	}	
//	

}
