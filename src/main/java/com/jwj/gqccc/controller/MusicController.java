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
 * 处理index页面对music的CRUD请求
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
	 * 导入jackson包：将PageInfo对象转换为Json对象
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
			return Msg.fail().add("music", "加载失败，用户不存在，请重试");
		} else {
			// 这不是一个分页查询
			// 引入PageHelper分页查询插件
			// 在查询之前只需要调用，传入页码，以及每页的大小
			PageHelper.startPage(pn, 5);
			// startPage后面紧跟的查询就是一个分页查询
			List<Music> musics = musicService.getAll();
			// 使用pageInfo 包装查询后的结果，只需要将pageInfo交给页面就行了。
			// 封装了详细的分页信息，包括我们查出来的数据
			// 5:连续显示的页数
			PageInfo page = new PageInfo(musics, 5);
			if (page.getSize() != 0)
				return Msg.success().add("music", "该用户已存在").add("pageInfo", page);
			else
				return Msg.fail();
		}

	}

	/**
	 * 查询音乐数据（分页查询）
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/musics")
	public String getMusics(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 这不是一个分页查询
		// 引入PageHelper分页查询插件
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, 5);
		// startPage后面紧跟的查询就是一个分页查询
		List<Music> musics = musicService.getAll();
		// 使用pageInfo 包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息，包括我们查出来的数据
		// 5:连续显示的页数
		PageInfo page = new PageInfo(musics, 5);
		// 把数据传给页面
		// 请求域
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
				failinfo += "上传失败,mid="+mid+"已存在; <br>";
				failNum++;
				String ext = "/"+mAddress.replace("http://gqccc.reallct.cn/Resourse/Music/", "");
				String url = request.getSession().getServletContext().getRealPath("/Resourse/Music");
				deleteFile(url+ext);
//				 msg.add("failinfo"+failNum, "mid="+mid+"已存在");
		}
		}
//		for (int j = 0; j < jsonlength-1; j++) {
//			if (responses[j] != 1)
//				return Msg.fail().add("failinfo", "错误数据" + j);
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

		//第一个数据为空
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
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

}
