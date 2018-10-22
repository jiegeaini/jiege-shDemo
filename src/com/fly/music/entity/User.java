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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @title 用户的实体类
 * @author jiege
 *
 */
@Entity
@Table(name = "user")
public class User {
	/**用户的id*/
	private int id;
	/**用户的账号*/
	private String username;
	/**用户的密码*/
	private String password;
	/**用户的手机号*/
	private String phone;
	/**用户的地址*/
	private String path;
	/**用户的简介*/
	private String aboutme;
	/**用户的头像*/
	private String img;
	/**喜欢的歌手*/
	private Set<Singer> singers;
	/**喜欢的歌曲*/
	private Set<Music> musics;
	/**喜欢的歌单*/
	private Set<Musicpage> musicpages;
	/**创作的歌单*/
	private Set<Musicpage> Mmusicpages;
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
	 * @return the username
	 */
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phone
	 */
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the path
	 */
	@Column(name = "path")
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the aboutme
	 */
	@Column(name = "aboutme")
	public String getAboutme() {
		return aboutme;
	}
	/**
	 * @param aboutme the aboutme to set
	 */
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	/**
	 * @return the img
	 */
	@Column(name = "img")
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the singers
	 */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name="likesinger",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="singerId")
    )     
	public Set<Singer> getSingers() {
		return singers;
	}
	/**
	 * @param singers the singers to set
	 */
	public void setSingers(Set<Singer> singers) {
		this.singers = singers;
	}
	/**
	 * @return the musics
	 */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name="likemusic",
            joinColumns=@JoinColumn(name="userId"),
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
	 * @return the musicpages
	 */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name="likemuiscpage",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="musicpageId")
    )  
	public Set<Musicpage> getMusicpages() {
		return musicpages;
	}
	/**
	 * @param musicpages the musicpages to set
	 */
	public void setMusicpages(Set<Musicpage> musicpages) {
		this.musicpages = musicpages;
	}
	/**
	 * @return the mmusicpages
	 */
	@OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="userID") 
	public Set<Musicpage> getMmusicpages() {
		return Mmusicpages;
	}
	/**
	 * @param mmusicpages the mmusicpages to set
	 */
	public void setMmusicpages(Set<Musicpage> mmusicpages) {
		Mmusicpages = mmusicpages;
	}
	
}
