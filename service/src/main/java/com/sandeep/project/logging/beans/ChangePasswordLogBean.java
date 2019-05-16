package com.sandeep.project.logging.beans;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="changePasswordLog")
public class ChangePasswordLogBean implements AbstractLogBeanFactory{

	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="createdAt",nullable=false,columnDefinition="TimeStamp default Current_Time")
	private Time createdAt;
}
