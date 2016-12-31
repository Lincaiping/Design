package com.base.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author gbq
 * 2016年3月24日
 */
@SuppressWarnings("unused")
public interface BaseDao {

    //根据hql查询实体
    <T> T findObject(String hql);

    //根据hql删除
    void delete(String hql);
    
    //删除实体
    <T> void delete(Object entity);
    
    //根据hql删除实体
    void delete(String hql, Object... objects);
    
    //根据hql查找实体
    <T> T findObject(String hql, Object... objects);
     
    //根据id查找实体
    <T> T getObject(Class<T> entity, Serializable id);
     
    //根据sql查找实体
    <T> T findObjectBySql(String sql);
     
    //根据实体和sql查找实体
    <T> T findObjectBySql(String sql, Object... objects);
     
    //根据hql查找记录
    <T> List<T> findList(String hql);
     
    //分页查询
    <T> List<T> findList(String hql, int page, int rows, Object... objects);
     
    //查询所有的实体
    <T> List<T> findList(Class<T> entity);
     
    //根据sql查找记录
    <T> List<T> findListBySql(String sql);
     
    //根据sql查找实体的记录
    <T> List<T> findListBySql(String sql, Object... objects);
     
    //新增
    <T> void saveObject(T entity);
     
    //更新
    <T> void updateObject(T entity);
     
    //保证或者更新，如果id已经存在更新，否则保存
    <T> void saveOrUpdateObject(T entity);
     
    //执行sql
    int executeSql(String sql);
     
    //执行sql
    int executeSql(String sql, Object... objects);
     
    //根据hql查询记录条数
    int countObjects(String hql);
     
    //根据hql查询实体的条数
    int countObjects(String hql, Object... objects);
     
    /**
     * 分页查询
     * @param hql hql
     * @param page 当前页数
     * @param rows 记录条数
     * @return pager
     */
    <T> Pager<T> findPager(String hql, int page, int rows);
     
    /**
     * 分页查询
     * @param hql hql
     * @param page 当前页数
     * @param rows 记录条数
     * @param objects 实体
     * @return pager
     */
    <T> Pager<T> findPager(String hql, int page, int rows, Object... objects);
}
