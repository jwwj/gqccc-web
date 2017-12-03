package com.jwj.gqccc.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jwj.gqccc.bean.Msg;
import com.jwj.gqccc.service.MusicService;

@Controller
public class UploadController {

	@Autowired
	MusicService musicService;
	
	private int midfag = 0;//1-5
	
	@ResponseBody
	@RequestMapping("/upload")
	public Msg updatePhoto(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("myfile") MultipartFile[] files) {
		try {
			for (MultipartFile myfile : files) {
				
				if (myfile.isEmpty()) {
					return Msg.fail().add("failinfo", "上传失败：文件为空");
				} else {
					// 输出文件后缀名称
					System.out.println(myfile.getOriginalFilename());

					String ext = "/"+myfile.getOriginalFilename();
					// 保存图片 File位置 （全路径） /upload/fileName.jpg
					String url = request.getSession().getServletContext().getRealPath("/Resourse/Music");
					// 相对路径
					System.out.println(url +ext);
					File file = new File(url);
					if (!file.exists()) {
						file.mkdirs();
					}
					File music = new File(url + ext);
					if (music.exists()) {
						return Msg.fail().add("failinfo", "文件已存在");
					} else {
						myfile.transferTo(music);
						
						int mid = musicService.getCount();
						String musicName = ext.replace(".mp3", "");
						String ipaddress = "http://gqccc.reallct.cn" + "/Resourse/Music";
						System.out.println(musicName + " : " + ipaddress + ext);

						return Msg.success().add("mid",mid+midfag).add("mName", musicName).add("maddress", ipaddress + ext);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Msg.fail();

	}
}
