<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<script>
	alert('잘못된 경로로 접근하였습니다. 다시 확인해 주세요.')
	location.href = '${root}main'
</script>