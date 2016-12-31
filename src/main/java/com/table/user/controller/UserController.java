package com.table.user.controller;

import com.base.BaseController;
import com.base.dao.PageBean;
import com.base.dao.Pager;
import com.table.user.entity.User;
import com.table.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    /*
     * 在配置文件中， userManager会绑定bean中id为userManager的类 有注解就不需要set方法
     */
    @Autowired
    private UserService userService;

    @RequestMapping("/goList")
    public String goList() {
        return "table/user/list";
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public Pager<User> getAllUser(Integer page, Integer rows) {
        PageBean pageBean = new PageBean();
        pageBean.setPageNo(page);
        pageBean.setPageSize(rows);
        return userService.getByPage(pageBean);
    }

    @RequestMapping("/getUser")
    public String getUser(String id, HttpServletRequest request) {
        request.setAttribute("user", userService.getUser(id));
        return "/editUser";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "/addUser";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public boolean saveOrUpdate(User user) {
        userService.saveOrUpdate(user);
        return true;
    }

    @RequestMapping("/delUser")
    public void delUser(String id, HttpServletResponse response) {

        String result = "{\"result\":\"error\"}";

        if (userService.deleteUser(id)) {
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

