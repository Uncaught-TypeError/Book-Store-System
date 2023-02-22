//package com.software.test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.software.test.Entity.User;
//import com.software.test.Repository.UserRepository;
//
//public class CustomUserDetailService implements UserDetailsService {
//	@Autowired
//	private UserRepository userRepo;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		User user = userRepo.getUserbyUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException(username);
//		}
//			
//		return new CustomUserDetails(user);
//	}
//
//}
