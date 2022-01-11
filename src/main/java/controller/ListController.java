package controller;

import DBPKG.DBCon;
import DBPKG.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "ListController", value = "/ListController")
public class ListController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement statement;
        ResultSet resultSet;
        try {
            statement = DBCon.getConnection().createStatement();
            String sql = "SELECT * FROM member_tbl_02";
            resultSet = statement.executeQuery(sql);
            ArrayList<Member> members = new ArrayList<>();
            while (resultSet.next()) {
                Member m = new Member();
                m.setCustno(resultSet.getInt("회원번호"));
                m.setCustname(resultSet.getString("회원성명"));
                m.setPhone(resultSet.getString("회원전화"));
                m.setAddress(resultSet.getString("주소"));
                m.setJoindate(resultSet.getDate("가입일자"));
                m.setGrade(resultSet.getString("고객등급"));
                m.setCity(resultSet.getString("거주도시"));
                members.add(m);
            }
            req.setAttribute("members", members);
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
