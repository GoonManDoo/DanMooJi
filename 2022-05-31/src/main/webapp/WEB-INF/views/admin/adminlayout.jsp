<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <tiles:getAsString name="title"/> </title>
</head>
<body>
<div align="center">
	<div>
		<table border="1">
			<tr>
				<td width="100%" height="20">
					<tiles:insertAttribute name="header"/>
				</td>
			</tr>
			<tr>
				<td width="100%" height="120">
					<tiles:insertAttribute name="body"/>
				</td>
			</tr>
			<tr>
				<td width="100%" height="20">
					<tiles:insertAttribute name="footer"/>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>