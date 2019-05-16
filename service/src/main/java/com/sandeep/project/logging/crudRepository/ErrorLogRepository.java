/**
 * 
 */
package com.sandeep.project.logging.crudRepository;

import org.springframework.data.repository.CrudRepository;

import com.sandeep.project.logging.beans.ErrorLogBean;

/**
 * @author USER
 *
 */
public interface ErrorLogRepository extends CrudRepository<ErrorLogBean, Long> {


}
