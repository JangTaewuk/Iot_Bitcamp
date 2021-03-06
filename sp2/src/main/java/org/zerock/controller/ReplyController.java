package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies/*")
@AllArgsConstructor
@Log4j
@CrossOrigin
public class ReplyController {
	
	private ReplyService service;
	
	@PutMapping(value = "/modify" , consumes = "application/json;charset=UTF-8",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> update(@RequestBody ReplyVO vo) {
		log.info("수정:" + vo);
		
		service.modify(vo);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable(name="rno") Integer rno){
		
		service.remove(rno);
		
		return new ResponseEntity<String>("sucess", HttpStatus.OK);
	}
	
	@PostMapping(value = "/reply" , consumes = "application/json;charset=UTF-8",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> rereply(@RequestBody ReplyVO vo){
		
		service.reply2(vo);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	@GetMapping("/{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable(name="rno") Integer rno){
		
		log.info("rno: "+rno);
		
		return new ResponseEntity<>(service.get(rno),HttpStatus.OK);
	}
	
	@GetMapping("/{bno}/{page}")
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable(name="bno") Integer bno,
			@PathVariable(name="page") Integer page
			){
		
		return new ResponseEntity<>(service.sampleList(bno,page),HttpStatus.OK);
		
	}
	@GetMapping("/re/{bno}")
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable(name="bno") Integer bno
			){
		
		return new ResponseEntity<>(service.rereplyList(bno),HttpStatus.OK);
		
	}
	
	
	
	@PostMapping(value = "/new" , consumes = "application/json;charset=UTF-8",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		
		log.info(vo);
		
		service.register(vo);
		
		return new ResponseEntity<String>("success",HttpStatus.OK);
		
	}
	
	
	
	


	
}
