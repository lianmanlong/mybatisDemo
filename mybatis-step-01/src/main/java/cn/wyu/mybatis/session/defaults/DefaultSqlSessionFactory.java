package cn.wyu.mybatis.session.defaults;

import cn.wyu.mybatis.binding.MapperRegistry;
import cn.wyu.mybatis.session.SqlSession;
import cn.wyu.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
