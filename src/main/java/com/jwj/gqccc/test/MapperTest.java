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
 * 测试dao层的工作
 * @author len
 *
 *推荐：自动注入需要的组建
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	UserMapper usermapper;
	
	@Autowired
	MusicMapper musicmapper;
	
	/**
	 *  测试UserMapper
	 */
	@Test
	public void testGqccc(){
//		//1.创建SpringICO容器
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2.从容器中获取mapper
//		UserMapper bean = ioc.getBean(UserMapper.class);
		
		//System.out.println(usermapper);
		
		//3、插入user
		//usermapper.insertSelective(new User("aaaaa","huawei aaaxbbb ccc",1000,10,500,500));
		
		//4、插入music
		for(int i=0;i<30;i++)
		musicmapper.insertSelective(new Music(null,"https://media.shanbay.com/audio/us/game.mp3","game",null));
		
	//	for(int i=0;i<32;i++)
	//		musicmapper.deleteByPrimaryKey(32);
	}
}
