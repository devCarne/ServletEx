<%@ page import="java.util.ArrayList" %>
<%@ page import="DBPKG.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section>
    <div>
        <h2>회원목록조회/수정</h2>
    </div>
    <div>
        <table border="1">
            <tr>
                <th>회원번호</th><th>회원성명</th><th>회원전화</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주도시</th>
            </tr>
            <c:forEach var="m" items="${members}">
                <tr>
                    <td>${m.custno}</td>
                    <td>${m.custname}</td>
                    <td>${m.phone}</td>
                    <td>${m.address}</td>
                    <td>${m.joindate}</td>
                    <td><c:choose>
                        <c:when test="${m.grade eq 'A'}">
                            VIP
                        </c:when>
                        <c:when test="${m.grade eq 'B'}">
                            일반
                        </c:when>
                        <c:when test="${m.grade eq 'C'}">
                            직원
                        </c:when>
                    </c:choose></td>
                    <td>${m.city}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>