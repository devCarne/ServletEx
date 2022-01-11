package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LifeCycle", value = "/LifeCycle")
public class LifeCycle extends HttpServlet {

    int initCount = 1;
    int doGetCount = 1;
    int destroyCount = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get 수신");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post 수신");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 메소드는 톰캣이 종료될 때만 호출됨 : " + destroyCount++);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init 메소드는 첫 요청에만 호출됨 : " + initCount++);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
