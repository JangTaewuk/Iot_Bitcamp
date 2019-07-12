package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	@Insert("insert into tbl_reply(bno,reply,replyer) values(#{bno}, #{reply} , #{replyer} )")
	public int insert(ReplyVO vo);
	
	@Select("select * from tbl_reply where bno = #{bno} order by rno asc limit #{page},10")
	public List<ReplyVO> list(@Param("bno") Integer bno,@Param("page") Integer page);
	
	@Select("select * from tbl_reply where bno = #{bno} && rno2 is not null order by rno2 asc;")
	public List<ReplyVO> listrere(@Param("bno") Integer bno);
	
	@Select("select * from tbl_reply where rno=#{rno}")
	public ReplyVO select(@Param("rno") Integer rno);
	
	
	@Insert("insert into tbl_reply(bno,rno2,reply,replyer) values(#{bno},#{rno2}, #{reply} , #{replyer} )")
	public int rereply(ReplyVO vo);
	
	@Delete("delete from tbl_reply where rno = #{rno}")
	public int delete(@Param("rno") Integer rno);
	
	
	@Insert("insert into tbl_s1 (col1) values (#{str})")
	public void insert1(@Param("str") String str);
	
	@Insert("insert into tbl_s2 (col2) values (#{str})")
	public void insert2(@Param("str") String str);
	
	@Update("update tbl_reply set reply= #{reply}, replyer=#{replyer} where rno = #{rno}")
	public int update(ReplyVO vo);

}
