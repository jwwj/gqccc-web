package com.jwj.gqccc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jwj.gqccc.bean.Msg;
import com.jwj.gqccc.bean.Music;
import com.jwj.gqccc.bean.User;
import com.jwj.gqccc.service.MusicService;
import com.jwj.gqccc.service.UserService;

/**
 * ����indexҳ���music��CRUD����
 * @author len
 *
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * ����jackson������PageInfo����ת��ΪJson����
	 * @param pn
	 * @return
	 */
	@RequestMapping("/api/user")
	@ResponseBody
	public Msg insertUser(String uid,String uphone,Integer uscore, Integer ulevel, Integer udelnum, Integer uidenum){
				
				if(!userService.isUserExist(uid)){
					userService.insertNewUser(new User(uid,uphone,uscore,ulevel,udelnum,uidenum));
					return Msg.success().add("user", "���û���Ϣ�Ѵ���");
				}else{
					return Msg.success().add("user","���û��Ѵ���");
				}
	}
	
	@RequestMapping("/api/updateuser")
	@ResponseBody
	public Msg updateUser(String uid,Integer uscore, Integer ulevel, Integer udelnum, Integer uidenum){
				
				if(userService.isUserExist(uid)){
					userService.update(new User(uid,uscore,ulevel,udelnum,uidenum));
					return Msg.success().add("userUpdate", "�û���Ϣ�Ѹ���");
				}else{
					return Msg.fail().add("userUpdate","�û���Ϣ����ʧ��");
				}
				
				
	}
	
}
