<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>services Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Service List</h1>

<c:if test="${!empty listServices}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Description</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listServices}" var="service">
            <tr>
                <td>${service.id}</td>
                <td><a href="/servicedata/${service.id}" target="_blank">${service.serviceTitle}</a></td>
                <td>${service.serviceDescription}</td>
                <td>${service.price/100}${service.price%100}</td>
                <td><a href="<c:url value='/edit/${service.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${service.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a service</h1>

<c:url var="addAction" value="/service/add"/>
a
<%--@elvariable id="service" type=""--%>
<form:form action="${addAction}" commandName="service">
    <table>
        <c:if test="${!empty service.serviceTitle}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="serviceTitle">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="serviceTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="serviceDescription">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="serviceDescription"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty service.serviceTitle}">
                    <input type="submit"
                           value="<spring:message text="Edit service"/>"/>
                </c:if>
                <c:if test="${empty service.serviceTitle}">
                    <input type="submit"
                           value="<spring:message text="Add service"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
