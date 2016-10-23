/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gisho.spring.repositories;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author ZO-PC
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface GishoCrudRepository <T, ID extends Serializable> extends CrudRepository<T, ID>{
    
}
