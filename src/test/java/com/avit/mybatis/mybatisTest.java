package com.avit.mybatis;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.avit.mybatis.bean.AlarmConfig;


public class mybatisTest {
	
	 //mybatis的配置文件
    String resource = "conf.xml";
    InputStream is;
    SqlSessionFactory sessionFactory;
    
    @Before
    public void initSessionFactory()
    {
    	 //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
         is = AlarmConfig.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
         sessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
	@Test
	public void testMybatisTest()
	{

       
       
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.avit.mybatis.mapping.AlarmConfigMapping.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        AlarmConfig user = session.selectOne(statement, 1);
        System.out.println(user.toString());
    
	}

}
