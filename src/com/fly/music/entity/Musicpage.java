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
import javax.persistence.Table;

/**
 * @title �赥ʵ����
 * @author jiege
 *
 */
@Entity
@Table(name = "musicpage")
public class Musicpage {
	/**�赥��id*/
	private int id;
	/**�赥������*/
	private String name;
	/**�赥�Ľ���*/
	private String introduce;
	/**�赥��СͼƬ*/
	private String smallImg;
	/**�赥�ĸ���ͼ*/
	private String bigImg;
	/**�赥�ķ���*/
	private Musicpagecategory musicpagecategory;
	/**�赥�Ķ�Ӧ�û�*/
	private User user;
	/**�赥�Ķ�Ӧ����*/
	private Set<Music> musics;
	/**����Щ�û�ϲ������赥*/
	private Set<User> users;
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
	 * @return the introduce
	 */
	@Column(name = "introduce")
	public String getIntroduce() {
		return introduce;
	}
	/**
	 * @param introduce the introduce to set
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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
	 * @return the musicpagecategory
	 */
	 @ManyToOne
	 @JoinColumn(name="musicpageFID") 
	public Musicpagecategory getMusicpagecategory() {
		return musicpagecategory;
	}
	/**
	 * @param musicpagecategory the musicpagecategory to set
	 */
	public void setMusicpagecategory(Musicpagecategory musicpagecategory) {
		this.musicpagecategory = musicpagecategory;
	}
	/**
	 * @return the user
	 */
	 @ManyToOne
	 @JoinColumn(name="userID") 
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the musics
	 */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name="musicandpage",
            joinColumns=@JoinColumn(name="muiscpageId"),
            inverseJoinColumns=@JoinColumn(name="musicId")
    )    
	public Set<Music> getMusics() {
		return musics;
	}
	/**
	 * @param musics the musics to set
	 */
	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}
	/**
	 * @return the users
	 */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name="likemuiscpage",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="musicpageId")
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
	
}
