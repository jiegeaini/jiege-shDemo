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
 * @title 歌曲的实体类
 * @author jiege
 *
 */
@Entity
@Table(name = "music")
public class Music {
	/**歌曲的id*/
	private int id;
	/**歌曲的名称*/
	private String name;
	/**歌曲的地址*/
	private String path;
	/**歌曲的作者/歌手*/
	private Singer singer;
	/**歌曲所对应的歌单*/
	private Set<Musicpage> Musicpage;
	/**有哪些用户喜欢这个歌曲*/
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
	 * @return the singer
	 */
	 @ManyToOne
	 @JoinColumn(name="singerID") 
	public Singer getSinger() {
		return singer;
	}
	/**
	 * @param singer the singer to set
	 */
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	
	/**
	 * @return the musicpage
	 */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name="musicandpage",
            joinColumns=@JoinColumn(name="musicId"),
            inverseJoinColumns=@JoinColumn(name="muiscpageId")
    )    
	public Set<Musicpage> getMusicpage() {
		return Musicpage;
	}
	/**
	 * @param musicpage the musicpage to set
	 */
	
	public void setMusicpage(Set<Musicpage> musicpage) {
		Musicpage = musicpage;
	}
	/**
	 * @return the users
	 */
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name="likemusic",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="musicId")
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Music [id=" + id + ", name=" + name + ", path=" + path + ", singer=" + singer + ", Musicpage="
				+ Musicpage + ", users=" + users + "]";
	}
	
}
