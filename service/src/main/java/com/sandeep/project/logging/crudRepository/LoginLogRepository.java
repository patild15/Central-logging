/**
 * 
 */
package com.sandeep.project.logging.crudRepository;

import org.springframework.data.repository.CrudRepository;

import com.sandeep.project.logging.beans.LoginLogBean;

/**
 * @author Sandeep
 *
 */
public interface LoginLogRepository extends CrudRepository<LoginLogBean, Long> {


}
