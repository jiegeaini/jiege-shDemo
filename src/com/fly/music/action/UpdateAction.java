package com.fly.music.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fly.music.dao.DBDao;
import com.fly.music.entity.Music;
import com.fly.music.entity.Singer;
import com.fly.music.impl.DBDaoImpl;
import com.fly.music.service.MusicService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class UpdateAction extends ActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File uploadImage; //得到上传的文件
    private String uploadImageContentType; //得到文件的类型
    private String uploadImageFileName; //得到文件的名称
    private String name;
	private String singername;
	private String id;
    
    public String execute(){
        System.out.println("fileName:"+this.getUploadImageFileName());
        System.out.println("contentType:"+this.getUploadImageContentType());
        System.out.println("File:"+this.getUploadImage());
        
        DBDao dao = new DBDaoImpl();
		MusicService service = new MusicService();
		if (singername != null) {
			boolean bl = service.getMusicSingerMess(singername);
			if (bl) {
				int id1 = service.getSingerId(singername);
				try {
					Singer singer = (Singer) dao.getObject(id1, Singer.class);
					Music music = (Music) dao.getObject(Integer.parseInt(id), Music.class);
					music.setName(name);
					music.setPath(uploadImageFileName);
					music.setSinger(singer);
					dao.updateObject(music);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				return NONE;
			}
			
		}	
        
        //获取要保存文件夹的物理路径(绝对路径)
        String realPath=ServletActionContext.getRequest().getRealPath("/") 
        		+ "../flymusicImg/music";
        File file = new File(realPath);
        
        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())file.mkdirs();
        
        try {
            //保存文件
            FileUtils.copyFile(uploadImage, new File(file,uploadImageFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(name+" "+singername);
        return SUCCESS;
    }

    public File getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(File uploadImage) {
        this.uploadImage = uploadImage;
    }

    public String getUploadImageContentType() {
        return uploadImageContentType;
    }

    public void setUploadImageContentType(String uploadImageContentType) {
        this.uploadImageContentType = uploadImageContentType;
    }

    public String getUploadImageFileName() {
        return uploadImageFileName;
    }

    public void setUploadImageFileName(String uploadImageFileName) {
        this.uploadImageFileName = uploadImageFileName;
    }

	/**
	 * @return the name
	 */
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
	 * @return the singername
	 */
	public String getSingername() {
		return singername;
	}

	/**
	 * @param singername the singername to set
	 */
	public void setSingername(String singername) {
		this.singername = singername;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
    
}