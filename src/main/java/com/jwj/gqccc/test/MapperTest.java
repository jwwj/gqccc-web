package com.jwj.gqccc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jwj.gqccc.bean.Music;
import com.jwj.gqccc.bean.User;
import com.jwj.gqccc.dao.MusicMapper;
import com.jwj.gqccc.dao.UserMapper;

/**
 * ����dao��Ĺ���
 * @author len
 *
 *�Ƽ����Զ�ע����Ҫ���齨
 *1������SpringTestģ��
 *2��@ContextConfigurationָ��Spring�����ļ���λ��
 *3��ֱ��autowiredҪʹ�õ����
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	UserMapper usermapper;
	
	@Autowired
	MusicMapper musicmapper;
	
	/**
	 *  ����UserMapper
	 */
	@Test
	public void testGqccc(){
//		//1.����SpringICO����
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2.�������л�ȡmapper
//		UserMapper bean = ioc.getBean(UserMapper.class);
		
		//System.out.println(usermapper);
		
		//3������user
		//usermapper.insertSelective(new User("aaaaa","huawei aaaxbbb ccc",1000,10,500,500));
		
		//4������music
		for(int i=0;i<30;i++)
		musicmapper.insertSelective(new Music(null,"https://media.shanbay.com/audio/us/game.mp3","game",null));
		
	//	for(int i=0;i<32;i++)
	//		musicmapper.deleteByPrimaryKey(32);
	}
}
