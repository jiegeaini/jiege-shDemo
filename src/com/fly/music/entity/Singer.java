package com.fly.music.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @title ����ʵ����
 * @author jiege
 */
@Entity
@Table(name = "singer")
public class Singer {
	/**����id*/
	private int id;
	/**��������*/
	private String name;
	/**���ֹ���*/
	private String countries;
	/**����ͷ��*/
	private String smallImg;
	/**���ָ���ͼ*/
	private String bigImg;
	/**���ֵķ���*/
	private Singercategory singercategory;
	/**����Щ�û�ϲ���������*/
	private Set<User> users;
	/**��������Ӧ����*/
	private Set<Music> musics;
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
	 * @return the countries
	 */
	@Column(name = "countries")  
	public String getCountries() {
		return countries;
	}
	/**
	 * @param countries the countries to set
	 */
	public void setCountries(String countries) {
		this.countries = countries;
	}
	/**
	 * @return the smallImg
	 */
	@Column(name = "smallImg")  
	public String getSmallImg() {
		return smallImg;
	}
	/**
	 * @param smallImg the smallImg to set
	 */
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	/**
	 * @return the bigImg
	 */
	@Column(name = "bigImg")  
	public String getBigImg() {
		return bigImg;
	}
	/**
	 * @param bigImg the bigImg to set
	 */
	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	/**
	 * @return the singercategory
	 */
	 @ManyToOne
	 @JoinColumn(name="singerFID") 
	public Singercategory getSingercategory() {
		return singercategory;
	}
	/**
	 * @param singercategory the singercategory to set
	 */
	public void setSingercategory(Singercategory singercategory) {
		this.singercategory = singercategory;
	}
	/**
	 * @return the users
	 */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name="likesinger",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="singerId")
    )    
	public Set<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	/**
	 * @return the musics
	 */
	@OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="singerID") 
	public Set<Music> getMusics() {
		return musics;
	}
	/**
	 * @param musics the musics to set
	 */
	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}
	
}
