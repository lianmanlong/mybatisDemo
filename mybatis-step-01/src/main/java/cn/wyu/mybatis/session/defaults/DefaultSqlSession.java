package cn.wyu.mybatis.session.defaults;

import cn.wyu.mybatis.binding.MapperRegistry;
import cn.wyu.mybatis.session.SqlSession;

public class DefaultSqlSession implements SqlSession {
    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
