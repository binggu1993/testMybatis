package com.mybatis;

import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.bean.User;
import com.mybatis.common.SqlSessionFactoryConfig;

public class mybatisTest {

	// mybatis的配置文件
	SqlSessionFactory sessionFactory;

	@Before
	public void initSessionFactory() {
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		// 构建sqlSession的工厂
		sessionFactory = SqlSessionFactoryConfig.getInsance();
	}

	@Test
	public void testCreate()
	{
		
			SqlSession session = sessionFactory.openSession(true);
			try {	String statement = "com.mybatis.mapping.UserMapping.insertUser";//映射sql的标识字符串
			User user=new User();
//		user.setId(2);
			user.setName("binggu");
			user.setAge(11);
			int result=session.insert(statement, user);
			System.out.println(result);
			session.close();
		} catch (Exception e) {
			fail("mybatis create test failed:" + e);
		}finally {
			session.close();
		}
	}

	@Test
	public void testRetrieve() {
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		// Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession

		SqlSession session = sessionFactory.openSession();
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		try {
			String statement = "com.mybatis.mapping.UserMapping.getUser";// 映射sql的标识字符串
			// 执行查询返回一个唯一user对象的sql
			User user = session.selectOne(statement, 1);
			System.out.println(user.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("mybatis retrieve test failed:" + e);
		} finally {
			session.close();

		}

	}

	@Test
	public void testUpdate() {

		SqlSession session = sessionFactory.openSession(true);
		try {
			String sql = "com.mybatis.mapping.UserMapping.updateUser";
			User user = new User();
			user.setId(3);
			user.setAge(26);
			user.setName("一江秋水寒");
			int result = session.update(sql, user);
			System.out.println(result);

		} catch (Exception e) {
			fail("mybatis update test failed:" + e);
		} finally {
			session.close();
		}
	}

	@Test
	public void testDelete() {

		SqlSession session = sessionFactory.openSession(true);
		try {
			String sql = "com.mybatis.mapping.UserMapping.deleteUser";
			int result = session.delete(sql, 4);
			System.out.println(result);
		} catch (Exception e) {
			fail("mybatis delete test failed:" + e);
		} finally {
			session.close();
		}
	}

}
