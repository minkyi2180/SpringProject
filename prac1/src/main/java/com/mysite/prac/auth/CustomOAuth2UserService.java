//package com.mysite.prac.auth;
//
//import java.util.Collections;
//
//import javax.servlet.http.HttpSession;
//import javax.transaction.Transactional;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import com.mysite.prac.user.SiteUser;
//import com.mysite.prac.user.UserRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class CustomOAuth2UserService extends DefaultOAuth2UserService{
//	
//	private HttpSession httpSession;
//	private UserRepositoryImpl userRepository;
//
//	@Override
//	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//		OAuth2UserService<OAuth2UserRequest, OAuth2User> service = new DefaultOAuth2UserService();
//		OAuth2User oAuth2User = service.loadUser(userRequest); // Oath2 정보를 가져옴
//		
//		String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 소셜 정보 가져옴
//        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName(); 
//        
//        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
//
//        SiteUser user = saveOrUpdate(attributes);
//        httpSession.setAttribute("user", new SessionUser(user));
//
//        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(user.getRole().getKey())),
//                attributes.getAttributes(),
//        		attributes.getNameAttributeKey());
//	}
//	
//	private SiteUser saveOrUpdate(OAuthAttributes attributes) {
//	    SiteUser user = userRepository.findOneByEmail(attributes.getEmail())
//	            .map(entity -> entity.update(attributes.getName()))
//	            .orElse(attributes.toEntity());
//
//	    return userRepository.save(user);
//	}
//
//	
//	
//}
