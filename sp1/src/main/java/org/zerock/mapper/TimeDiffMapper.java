package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeDiffMapper {
	
	@Select("select DATEDIFF(now() ,'2019-04-01')")
	public int calcGap();
	
	
	
	@Select("select DATEDIFF(now() ,#{day} )")
	public int calcGapDay(String day);

}
