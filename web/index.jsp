<%--
  Created by IntelliJ IDEA.
  User: Sergiy
  Date: 21.02.2017
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cartNameBean" class="ghub.boiko.beans.CartNameBean" scope="session"/>
<jsp:useBean id="cartMessageBean" class="ghub.boiko.beans.CartMessageBean" scope="session"/>
<jsp:useBean id="cartDropDownOptionsBean" class="ghub.boiko.beans.CartDropDownOptionsBean" scope="session"/>
<html>
<head>
    <title>Simple page</title>
</head>
<body>
<div>
    <form action="/redirect" method="post">
        <p><b>Enter name:</b><br>
            <input name="name" placeholder="Name" type="text" size="40"/>
        </p>
        <p><b>Enter message:</b><br>
            <textarea name="message" placeholder="Message" cols="31" rows="3"></textarea>
        </p>
        <p><select name="dropdownoptions">
            <option disabled>Choose options</option>
            <option value="1" selected>1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select></p>
        <p><input type="submit" value="Enter"></p>
            <table>
                <tr>
                    <td>
                        <c:forEach items="${cartDropDownOptionsBean.dropDownOption}" var="dropdownoptions">
                            <span>${dropdownoptions}</span> </br />
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${cartNameBean.name}" var="name">
                            <span>${name}</span> </br />
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${cartMessageBean.message}" var="massege">
                            <span>${massege}</span> </br />
                        </c:forEach>
                    </td>
                </tr>
            </table>
    </form>
</div>
</body>
</html>
