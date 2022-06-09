package cn.wyu.mybatis.binding;

import cn.wyu.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapperRegistry {

    /**
     * 将已添加的映射器代理加入到 HashMap
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knowMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knowMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        /* Mapper 必须是接口才会注册 */
        if (type.isInterface()) {
//            if (hasMapper(type)) {
//                // 如果重复添加了，报错
//                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
//            }
            // 注册映射器代理工厂
            knowMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

//    public void addMappers(String packageName) {
//        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
//        for (Class<?> mapperClass : mapperSet) {
//            addMapper(mapperClass);
//        }
//    }
}
