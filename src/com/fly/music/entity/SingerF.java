package com.fly.music.entity;

/**
 * 
 * @author mrc 歌手分类
 *
 */
public class SingerF {
    /** 用户的id */
    private int id;
    /** 歌手名字 */
    private String name;
    /** 歌手小图 */
    private String smallImg;
    /** 歌手的大图 */
    private String bigImg;
    /** 歌手国家 */
    private String country;
    /** 歌手的分类 */
    private String categroy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getBigImg() {
        return bigImg;
    }

    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategroy() {
        return categroy;
    }

    public void setCategroy(String categroy) {
        this.categroy = categroy;
    }

   

    public SingerF(int id, String smallImg, String name, String country) {
        super();
        this.id = id;
        this.smallImg = smallImg;
        this.name = name;
        this.country = country;
    }

    public SingerF(int id, String name, String smallImg, String bigImg, String country, String categroy) {
        /** 此构造器用于后台传输数据 **/
        super();
        this.id = id;
        this.name = name;
        this.smallImg = smallImg;
        this.bigImg = bigImg;
        this.country = country;
        this.categroy = categroy;
    }

}
