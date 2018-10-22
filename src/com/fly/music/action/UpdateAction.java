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
	private File uploadImage; //�õ��ϴ����ļ�
    private String uploadImageContentType; //�õ��ļ�������
    private String uploadImageFileName; //�õ��ļ�������
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
        
        //��ȡҪ�����ļ��е�����·��(����·��)
        String realPath=ServletActionContext.getRequest().getRealPath("/") 
        		+ "../flymusicImg/music";
        File file = new File(realPath);
        
        //���Դ˳���·������ʾ���ļ���Ŀ¼�Ƿ���ڡ��������ڣ������˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��
        if(!file.exists())file.mkdirs();
        
        try {
            //�����ļ�
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