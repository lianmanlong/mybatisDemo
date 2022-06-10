package org.example;

import cn.wyu.mybatis.binding.MapperRegistry;
import cn.wyu.mybatis.session.SqlSession;
import cn.wyu.mybatis.session.SqlSessionFactory;
import cn.wyu.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.example.dao.IUserDao;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("org.example.dao");
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        String userName = userDao.queryUserName("100");
        System.out.println(userName);
    }
}
