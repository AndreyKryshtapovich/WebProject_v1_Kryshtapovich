<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="print"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user page</title>
</head>
<body>
	<h1>this is a user page</h1>
	<h2>Hello ${sessionScope.login}</h2>
	<div>
		<form action="Controller" method="post" name="sign-out">
			<div>
				<input type="hidden" name="command" value="sign-out" />
			</div>
			<div>
				<input type="submit" value="SignOut">
			</div>
		</form>
	</div>

	<jsp:useBean id="list"
		class="by.epamtr.totalizator.bean.listbean.JSPListBean"
		scope="request" />
	<div>
		<form action="Controller" method="get" name="create-bet">
			<div>
				<input type="hidden" name="command" value="create-bet" />
			</div>
			<print:jsptable list="${list}" colunmName1="Date" colunmName2="Event" colunmName3="1"
				colunmName4="X" colunmName5="2" />
			<div>
				<input type="submit" value="Create Bet">
			</div>
		</form>
	</div>
</body>
</html>