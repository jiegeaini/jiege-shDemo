package com.fly.music.entity;

/**
 * 
 * @author mrc ���ַ���
 *
 */
public class SingerF {
    /** �û���id */
    private int id;
    /** �������� */
    private String name;
    /** ����Сͼ */
    private String smallImg;
    /** ���ֵĴ�ͼ */
    private String bigImg;
    /** ���ֹ��� */
    private String country;
    /** ���ֵķ��� */
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
        /** �˹��������ں�̨�������� **/
        super();
        this.id = id;
        this.name = name;
        this.smallImg = smallImg;
        this.bigImg = bigImg;
        this.country = country;
        this.categroy = categroy;
    }

}
