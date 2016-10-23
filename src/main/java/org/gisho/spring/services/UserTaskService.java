/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.spring.services;

import org.gisho.model.entity.FacebookDTO;

/**
 *
 * @author ZO-PC
 */
public interface UserTaskService {

	void loginOrCreateFacebookUser(FacebookDTO dto);
	
}
