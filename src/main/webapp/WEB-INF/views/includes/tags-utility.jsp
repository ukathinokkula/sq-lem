<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="msg" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>
<%
	
 /*  if(session.getAttribute("username") == null){
	 response.sendRedirect(request.getContextPath()+"/lem/login/redirect");
 } */
%>
<c:if test="${username == null}">
  <c:redirect url="lem/login/form" />
</c:if>

