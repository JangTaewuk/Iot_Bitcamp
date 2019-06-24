package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.StoreVO;

public interface StoreMapper {
	
	public void insert(StoreVO vo);
	
	
	public String getTime();
	
	public List<StoreVO> getList();
	
	public void delete(Integer sno);

}
