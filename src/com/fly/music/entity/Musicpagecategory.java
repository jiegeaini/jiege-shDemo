package com.fly.music.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @title �赥����ʵ����
 * @author jiege
 *
 */
@Entity
@Table(name = "musicpagecategory")
public class Musicpagecategory {
	/**�赥�����id*/
	private int id;
	/**�赥�ķ�������*/
	private String name;
	/**
	 * @return the id
	 */
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 @Column(name = "id")  
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	@Column(name = "name")  
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
