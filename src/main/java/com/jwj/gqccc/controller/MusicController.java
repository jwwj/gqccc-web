package com.jwj.gqccc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jwj.gqccc.bean.Msg;
import com.jwj.gqccc.bean.Music;
import com.jwj.gqccc.bean.User;
import com.jwj.gqccc.service.MusicService;
import com.jwj.gqccc.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ����indexҳ���music��CRUD����
 * 
 * @author len
 *
 */
@Controller
public class MusicController {

	@Autowired
	MusicService musicService;
	@Autowired
	UserService userService;

	/**
	 * ����jackson������PageInfo����ת��ΪJson����
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping("/api/musics")
	@ResponseBody // @RequestParam(value = "pn", defaultValue = "1")
	public Msg getMusicWIthJson(Integer pn, String uid) {
		if (pn == -1) {
			return Msg.fail();
		}
		if (!userService.isUserExist(uid)) {
			return Msg.fail().add("music", "����ʧ�ܣ��û������ڣ�������");
		} else {
			// �ⲻ��һ����ҳ��ѯ
			// ����PageHelper��ҳ��ѯ���
			// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
			PageHelper.startPage(pn, 5);
			// startPage��������Ĳ�ѯ����һ����ҳ��ѯ
			List<Music> musics = musicService.getAll();
			// ʹ��pageInfo ��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
			// ��װ����ϸ�ķ�ҳ��Ϣ���������ǲ����������
			// 5:������ʾ��ҳ��
			PageInfo page = new PageInfo(musics, 5);
			if (page.getSize() != 0)
				return Msg.success().add("music", "���û��Ѵ���").add("pageInfo", page);
			else
				return Msg.fail();
		}

	}

	/**
	 * ��ѯ�������ݣ���ҳ��ѯ��
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/musics")
	public String getMusics(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// �ⲻ��һ����ҳ��ѯ
		// ����PageHelper��ҳ��ѯ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		// startPage��������Ĳ�ѯ����һ����ҳ��ѯ
		List<Music> musics = musicService.getAll();
		// ʹ��pageInfo ��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ���������ǲ����������
		// 5:������ʾ��ҳ��
		PageInfo page = new PageInfo(musics, 5);
		// �����ݴ���ҳ��
		// ������
		model.addAttribute("pageInfo", page);

		return "musiclist";
	}

	@ResponseBody
	@RequestMapping("/insertmusics")
	public Msg getMusics(@RequestParam("datalist") String str,HttpServletRequest request) {
		String data = "{data:" + str + "}";
		JSONObject json = JSONObject.fromObject(data);
		int jsonlength = json.getJSONArray("data").size();
		String failinfo = null;
		int failNum=0;
		//System.out.println(json.getJSONArray("data").size());
		int[] responses = new int[jsonlength-1];
		for (int i = 1; i <jsonlength ; i++) {
			JSONObject jdata = json.getJSONArray("data").getJSONObject(i);
			int mid = jdata.getInt("mid");
			String mAddress = jdata.getString("mAddress");
			String mName = jdata.getString("mName");
			System.out.println(mAddress + " : " + mName);

			
			Music music = new Music(mid,mAddress, mName,null);
			if(musicService.selectMusic(mid)==null)
				 musicService.insertMusics(music);
			else{
				failinfo += "�ϴ�ʧ��,mid="+mid+"�Ѵ���; <br>";
				failNum++;
				String ext = "/"+mAddress.replace("http://gqccc.reallct.cn/Resourse/Music/", "");
				String url = request.getSession().getServletContext().getRealPath("/Resourse/Music");
				deleteFile(url+ext);
//				 msg.add("failinfo"+failNum, "mid="+mid+"�Ѵ���");
		}
		}
//		for (int j = 0; j < jsonlength-1; j++) {
//			if (responses[j] != 1)
//				return Msg.fail().add("failinfo", "��������" + j);
//		}
		if(failNum!=0){
			
			return Msg.fail(201).add("failinfo", failinfo).add("failNum", failNum);
			}else
			return Msg.success();
	}

	@ResponseBody
	@RequestMapping(value = "/delmusic/{mid}", method = RequestMethod.DELETE)
	public Msg deleteMusicById(@PathVariable("mid") Integer mid,HttpServletRequest request) {
		String ext = "/"+musicService.getMusic(mid).getMaddress().replace("http://gqccc.reallct.cn/Resourse/Music/", "");
		String url = request.getSession().getServletContext().getRealPath("/Resourse/Music");
		System.out.println("delmusic");
		System.out.println(url+ext);
		boolean flag  = deleteFile(url+ext);
		if(flag){
			musicService.deleteMusic(mid);	
			return Msg.success();
		}else
			return Msg.fail();
	}

	@ResponseBody
	@RequestMapping("/updatemusic")
	public Msg updateMusicById(@RequestParam("datalist") String str) {
		String data = "{data:" + str + "}";
		JSONObject json = JSONObject.fromObject(data);

		//��һ������Ϊ��
		JSONObject jdata = json.getJSONArray("data").getJSONObject(1);
		int mid = jdata.getInt("mid");
		String mAddress = jdata.getString("mAddress");
		String mName = jdata.getString("mName");
		System.out.println(mAddress + " : " + mName);

		Music music = new Music(mid,mAddress, mName,null);
		int msg = musicService.updateMusic(music);
		if(msg == 1)
		return Msg.success();
		else return Msg.fail();
	}
	
	
	public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
                return true;
            } else {
                System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
                return false;
            }
        } else {
            System.out.println("ɾ�������ļ�ʧ�ܣ�" + fileName + "�����ڣ�");
            return false;
        }
    }

}
