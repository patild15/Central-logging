/**
 * 
 */
package com.sandeep.project.logging.crudRepository;

import org.springframework.data.repository.CrudRepository;

import com.sandeep.project.logging.beans.EmailLogBean;

/**
 * @author USER
 *
 */
public interface EmailLogRepository extends CrudRepository<EmailLogBean, Long> {


}
