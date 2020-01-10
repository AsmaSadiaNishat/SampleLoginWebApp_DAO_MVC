
package com.login.controller;

import com.login.bean.LoginBean;
import com.login.dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doPost(request, response);
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        LoginBean bean = new LoginBean();
        LoginDao dao = new LoginDao();
        
        bean.setUserName(userName);
        bean.setPassword(password);
        
        if(dao.validateLogin(bean)){
            Cookie cookie1 = new Cookie("userName", userName);
            Cookie cookie2 = new Cookie("password", password);
            
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            
            response.sendRedirect("/Model2Architecture/ContentServlet");
        }
        else{
            request.setAttribute("errMessage", "Invalid User or Password");
            request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
