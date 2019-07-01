package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	@Insert("insert into tbl_reply(bno,reply,replyer) values(#{bno}, #{reply} , #{replyer} )")
	public int insert(ReplyVO vo);
	
	@Select("select * from tbl_reply where bno = #{bno} order by rno asc; ")
	public List<ReplyVO> list(@Param("bno") Integer bno);
	
	@Select("select * from tbl_reply where rno=#{rno}")
	public ReplyVO select(@Param("rno") Integer rno);
	

}
