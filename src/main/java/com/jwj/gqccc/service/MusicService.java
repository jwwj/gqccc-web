package com.jwj.gqccc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwj.gqccc.bean.Music;
import com.jwj.gqccc.bean.MusicExample;
import com.jwj.gqccc.bean.UserExample;
import com.jwj.gqccc.bean.UserExample.Criteria;
import com.jwj.gqccc.dao.MusicMapper;

@Service
public class MusicService {
	
	@Autowired
	MusicMapper musicMapper;
	/**
	 * ≤È—ØÀ˘”–“Ù¿÷
	 * @return
	 */
	public List<Music> getAll() {
	
		
		return musicMapper.selectByExample(null);
	}

	public int insertMusics(Music music){
		return musicMapper.insertSelective(music);
	}

	public void deleteMusic(Integer mid) {
		musicMapper.deleteByPrimaryKey(mid);
		
	}

	public int updateMusic(Music muisc) {
		return musicMapper.updateByPrimaryKeySelective(muisc);
		
	}
	
	public Music getMusic(Integer mid){
		return musicMapper.selectByPrimaryKey(mid);
	}
	public int getCount(){
		
		return (int)musicMapper.countByExample(null);
	}
	public Music selectMusic(Integer mid){
		return musicMapper.selectByPrimaryKey(mid);
	}
}
