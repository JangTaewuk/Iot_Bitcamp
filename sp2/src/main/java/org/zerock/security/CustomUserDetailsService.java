//package org.zerock.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.zerock.domain.MemberVO;
//import org.zerock.mapper.MemberMapper;
//
//import lombok.Setter;
//import lombok.extern.log4j.Log4j;
//
//
//@Log4j
//public class CustomUserDetailsService implements UserDetailsService {
//	
//	@Setter(onMethod_= @Autowired)
//	private MemberMapper mapper;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		log.info("_____________________________________________");
//		log.info("_____________________________________________");
//		log.info(username);
//		log.info("_____________________________________________");
//		log.info("_____________________________________________");
//		
//		MemberVO vo = mapper.read(username);
//		log.info(vo);
//		
//		if(vo == null) {
//			return null;
//		}
//		
//		CustomUser result = new CustomUser(vo);
//		
//		log.info(result);
//		
//		return result;
//	}
//
//}
