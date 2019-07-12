package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO read(String userid);
	
	@Insert("insert into tbl_member (userid,userpw,username) values (#{userid},#{userpw},#{username})")
	public void register(MemberVO vo);

}
