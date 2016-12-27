package com.base;

import com.base.dao.BaseDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;

/**
 * 基础的service,主要包含日志和baseDao的调用
 * @author gbq
 * 2016年3月24日
 */
public class BaseService {
	@Resource
	protected BaseDao dao;
	protected Log log = LogFactory.getLog(BaseController.class);
}
