package com.sandeep.project.logging.crudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandeep.project.logging.dto.AbstractLog;

public interface LoggerRepository extends JpaRepository<AbstractLog, Long>{

	@Query("select logs from logRecord as logs where logs.logType = (:logType)")
	List<AbstractLog> findByLogType(@Param("logType")	String logType);
}

