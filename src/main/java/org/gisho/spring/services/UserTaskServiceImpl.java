/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.spring.services;

import java.util.Arrays;
import java.util.UUID;
import org.gisho.model.entity.Consommateur;
import org.gisho.model.entity.FacebookDTO;
import org.gisho.model.entity.SocialUserDetails;
import org.gisho.spring.repositories.gishoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZO-PC
 */
@Service
@Component
public class UserTaskServiceImpl implements UserTaskService {

	@Autowired
	private gishoUserRepository userRepository;
	
	@Autowired
	private ConnectionRepository connectionRepository;
			
	@Override
	public void loginOrCreateFacebookUser(FacebookDTO dto) {

		Consommateur user = this.userRepository.findByFacebookId(dto.getId());

		if(null == user){
			user = new Consommateur();

			String facebookUserId = dto.getId();

			user.setLogin(dto.getDisplayName());
			user.setPassword(UUID.randomUUID().toString());
			user.setEmailConsomateur(dto.getEmail());

			user.setFacebookId(facebookUserId);
			user.setFacebookImage(dto.getImageURL());

			user = this.userRepository.save(user);
		}

		SocialUserDetails userDetails = new SocialUserDetails(user.getIdConsommateur().longValue(), Arrays.asList(new SimpleGrantedAuthority("USER")));
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		
		//not neccesary any more
		Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);		
		connectionRepository.removeConnection(connection.getKey());		
		
		SecurityContextHolder.clearContext();
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
