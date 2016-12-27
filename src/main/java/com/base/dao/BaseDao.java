package com.base.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author gbq
 * 2016年3月24日
 */
public interface BaseDao {
	
     /**
     * 
     * @param hql
     * @return
     */
    <T> T findObject(String hql);
     
    /**
     * 删除
     * @param hql
     */
    void delete(String hql);
    
    /**
     * 删除
     * @param entity
     */
    <T> void delete(Object entity);
    
    /**
     * 删除
     * @param hql
     * @param objects
     */
    void delete(String hql, Object... objects);
    
    /**
     * 
     * @param hql
     * @param objects
     * @return
     */
    <T> T findObject(String hql, Object... objects);
     
    /**
     * 
     * @param id
     * @return
     */
    <T> T getObject(Class<T> entity, Serializable id);
     
    /**
     * 
     * @param sql
     * @return
     */
    <T> T findObjectBySql(String sql);
     
    /**
     * 
     * @param sql
     * @param objects
     * @return
     */
    <T> T findObjectBySql(String sql, Object... objects);
     
    /**
     * 
     * @param hql
     * @return
     */
    <T> List<T> findList(String hql);
     
    /**
     * 
     * @param hql
     * @param objects
     * @return
     */
    <T> List<T> findList(String hql, int page, int rows, Object... objects);
     
    /**
     * 
     * @return
     */
    <T> List<T> findList(Class<T> entity);
     
    /**
     * 
     * @param sql
     * @return
     */
    <T> List<T> findListBySql(String sql);
     
    /**
     * 
     * @param sql
     * @param objects
     * @return
     */
    <T> List<T> findListBySql(String sql, Object... objects);
     
    /**
     * 
     */
    <T> void saveObject(T entity);
     
    /**
     * 
     */
    <T> void updateObject(T entity);
     
    /**
     * 
     */
    <T> void saveOrUpdateObject(T entity);
     
    /**
     * 
     * @param sql
     * @return
     */
    int executeSql(String sql);
     
    /**
     * 
     * @param sql
     * @param objects
     * @return
     */
    int executeSql(String sql, Object... objects);
     
    /**
     * 
     * @param hql
     * @return
     */
    int coutObjects(String hql);
     
    /**
     * 
     * @param hql
     * @param objects
     * @return
     */
    int countObjects(String hql, Object... objects);
     
    /**
     * 
     * @param hql
     * @param page
     * @param rows
     * @return
     */
    <T> Pager<T> findPager(String hql, int page, int rows);
     
    /**
     * 
     * @param hql
     * @param page
     * @param rows
     * @param objects
     * @return
     */
    <T> Pager<T> findPager(String hql, int page, int rows, Object... objects);
}
