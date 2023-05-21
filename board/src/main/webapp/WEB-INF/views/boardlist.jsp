<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring 게시판</title>
<style type="text/css">
h3,h5 { text-align: center; }
table { margin: auto; width: 800px }
#tr_top { background: orange; text-align: center; }
#emptyArea { margin: auto; width: 800px; text-align: center; }
</style>
</head>
<body>

<h3>글 목록 &nbsp;&nbsp;

<a href="./writeform">글쓰기</a>&nbsp;&nbsp;

<c:choose>
	<c:when test="${sessionScope.id eq null }">
		<a href="./loginform">로그인</a>
	</c:when>
	<c:otherwise>
		<a href="./logout">로그아웃</a>
	</c:otherwise>
</c:choose>
&nbsp;&nbsp;
<a href="./joinform">회원가입</a>
</h3>
<form action="./search" method="post">					
<h5>
	<select name="type">
		<option value="title">제목</option>
		<option value="writer">작성자</option>
		<option value="content">내용</option>
	</select>
	<input type="text" name="word"/>
	<input type="submit" value="검색"/>
</h5>
</form>					
		<table>
			<tr id="tr_top"><th>번호</th><th>제목</th><th>작성자</th><th>삭제</th></tr>
			<c:forEach items="${boards}" var="article">
				<tr>
					<td>${article.num }</td>
					<td><a href="boarddetail?num=${article.num}">${article.title }</a></td>
					<td>${article.writer }</td>
					<td>
						<c:if test="${sessionScope.id eq article.writer }">
							<a href="boarddelete?num=${article.num }">삭제</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>