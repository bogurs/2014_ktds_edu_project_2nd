package com.ktds.closet.service;


import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ktds.closet.dao.EtcDao;
import com.ktds.closet.vo.FriendVO;
import com.ktds.closet.vo.ImageVO;
import com.ktds.closet.vo.JoinVO;
import com.ktds.closet.vo.TagVO;
import com.ktds.closet.vo.WeatherVO;


@Service
public class EtcServiceImpl implements EtcService {
	@Autowired
	EtcDao etcDao;
	
	@Override
	public boolean join(JoinVO joinVO) {
		return etcDao.join(joinVO);
	}

	@Override
	public int login_check(String email, String pass) {
		int status=0;
		if(etcDao.login_check(email)!=null){
			if (pass.equals(etcDao.login_check(email))) {
				status = 1;
			} else {
				status = 2;
			}
		} else {
			status = 3;
		}
		
		return status;
	}

	@Override
	public String getNamebyEmail(String email) {		
		return etcDao.getNamebyEmail(email);
	}
	
	@Override
	public List<WeatherVO> weatherStyleReadList() {
		return etcDao.weatherStyleReadList();
	}
	
	@Override
	public void weatherStyleWrite(WeatherVO weatherVO) {		
		etcDao.weatherStyleWrite(weatherVO);
	}		

	//==길민균 ==//
	//==길민균==//
	@Override
	public List<TagVO> keyword() {
		return etcDao.keyword();
	}	
	@Override
	public List<TagVO> searchid(String name) {
		return etcDao.searchid(name);
	}

	@Override
	public List<FriendVO> fdmanageview(String myemail) {
		return etcDao.fdmanageview(myemail);
	}
	@Override
	public void addfollow(FriendVO friendVO) {
		etcDao.addfollow(friendVO);
	}

	@Override
	public void addactionlog(FriendVO friendVO) {
		etcDao.addactionlog(friendVO);
		
	}
	
	@Override
	public List<FriendVO> actionlogview(String email) {
		return etcDao.actionlogview(email);
	}

	@Override
	public void deletefollow(String myemail,String fdemail) {
		
		FriendVO follow=new FriendVO();
		follow.setEmail(myemail);
		follow.setFdemail(fdemail);
		etcDao.deletefollow(follow);
		
	}
	@Override
	public List<FriendVO> friendlist(String email) {
		return etcDao.friendlist(email);
	}
	

	@Override
	public List<FriendVO> followerlist(String email) {
		return etcDao.followerlist(email);
	}

	@Override
	public List<FriendVO> searchfriend(String name) {
		return etcDao.searchfriend(name);
	}

	@Override
	public List<JoinVO> profileview(String email) {
		return etcDao.profileview(email);
	}
	
	@Override
	public void updateprofile(MultipartHttpServletRequest mreq,
		HttpServletRequest req, String cm, String kg, String status) {
		JoinVO profile = new JoinVO();

		profile.setEmail(req.getSession().getAttribute("email").toString());
		profile.setName(req.getSession().getAttribute("name").toString());
		profile.setStatus(status);
		profile.setCm(cm);
		profile.setKg(kg);
		etcDao.updateprofile(profile);
		List<MultipartFile> filelist = mreq.getFiles("file");
		Iterator<MultipartFile> it = filelist.iterator();
		while (it.hasNext()) {
			MultipartFile mFile = it.next();
			String image_name = mFile.getOriginalFilename();
			if(image_name!="")
			{etcDao.deleteprofileimage(req.getSession().getAttribute("email").toString());
			String physical_name = image_name + "_" + System.currentTimeMillis();
			byte[] imagefile = null;
			try {
				imagefile = new byte[(int) mFile.getSize()];
				imagefile = mFile.getBytes();
				ImageVO image = new ImageVO();
				image.setImage_name(image_name);
				image.setImagefile(imagefile);
				image.setPhysical_name(physical_name);
				image.setEmail(req.getSession().getAttribute("email").toString());
				etcDao.InsertprofileImage(image);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
	}

	@Override
	public ImageVO profileImageDown(String email) {
		return etcDao.profileImageDown(email);
	}
	@Override
	public int searchId(String id){
		int status=0;
		String idcheck;
		idcheck=etcDao.searchId(id);
		if(idcheck!=null){
			status=1; //아이디가 있다는 소리임
		}else status=0; //아이디없다
		return status;
	}

	@Override
	public String searchfollow(FriendVO friend) {
		
		String fdemail2;
		fdemail2=etcDao.searchfollow(friend);
		return fdemail2;
				
	}
	
	
	
}

