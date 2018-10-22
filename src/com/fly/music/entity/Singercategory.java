package com.fly.music.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @title 歌手分类实体类
 * @author jiege
 *
 */
@Entity
@Table(name = "singercategory")
public class Singercategory {
	/**歌手分类的id*/
	private int id;
	/**歌手分类的名称*/
	private String name;
	private Set<Singer> singerSet;
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
	/**
	 * @return the singerSet
	 */
	@OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="singerFID") 
	public Set<Singer> getSingerSet() {
		return singerSet;
	}
	/**
	 * @param singerSet the singerSet to set
	 */
	public void setSingerSet(Set<Singer> singerSet) {
		this.singerSet = singerSet;
	}
	
}
