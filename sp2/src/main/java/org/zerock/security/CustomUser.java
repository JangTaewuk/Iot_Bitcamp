//package org.zerock.security;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.zerock.domain.AuthVO;
//import org.zerock.domain.MemberVO;
//
//import lombok.Data;
//import lombok.extern.log4j.Log4j;
//
//@Log4j
//@Data
//public class CustomUser extends User {
//
//	private MemberVO vo;
//
//	private static List<GrantedAuthority> convert(List<AuthVO> authList){
//		if(authList == null || authList.size() ==0) {
//			return null;
//		}
//		else {
//			List<GrantedAuthority> result = new ArrayList<>();
//			for (AuthVO auth : authList) {
//				result.add(new SimpleGrantedAuthority(auth.getAuth()));
//			}
//			return result;
//		}
//		
//	}
//
//	public CustomUser(MemberVO vo) {
//		super(vo.getUserid(), vo.getUserpw(), convert(vo.getAuthList()));
//		this.vo = vo;
//	}
//
//	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//	}
//
//}
