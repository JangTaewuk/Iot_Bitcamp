package org.zerock.mapper;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	public void insert(BoardVO vo);
	
	public BoardVO select(Integer bno);

}
