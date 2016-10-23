/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.spring.repositories;

import java.io.Serializable;
import org.gisho.model.entity.Consommateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ZO-PC
 */
public interface gishoUserRepository extends JpaRepository<Consommateur, Serializable>{
    @Transactional
    Consommateur findByLogin(String login);
    Consommateur findByFacebookId(String facebookId);
}
