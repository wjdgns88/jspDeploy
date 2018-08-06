<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//DB작업에 필요한 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; //쿼리문이 'select'일 경우 필요

		String name = "";

		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. DB 접속 => Connection 객체 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//localhost : 내 컴터의 오라클 ㅇㅂㅇ 다른컴이다 그러면 그 컴의 아이피주소 쓰면 끝이쥬 ~ 1521은 포트번호 xe는 sid develop 접속할때 있슴ㅎ 버전에따라 좀 다름 보통 정식오라클은 ocrl
		String user = "pc01";
		String pass = "1234";
		conn = DriverManager.getConnection(url, user, pass);

		//3. Statement객체(는 Connection객체를 이용해서 생성한다) 생성(또는 PreparedStatement)
		stmt = conn.createStatement();

		//4. SQL문을 Statement 객체를 이용하여 실행하고 실행결과를 ResultSet객체에 저장한다.
		StringBuffer sql = new StringBuffer();
		sql.append("select * "); //string안에다 ; 쓰면 안됏
		sql.append("from student ");
		sql.append("where id = ");
		sql.append("(select round(dbms_random.value(1,(select count(*)from student)), 0) from dual)");
		rs = stmt.executeQuery(sql.toString());

		//5. 결과 처리 : ResultSet객체에 저장되어있는 자료를 반복문을 이용하여 차례로 읽어와 처리한다.
		//ResultSet객체에 담겨있는 데이터(레코드)에 접근하기위해
		//현재 작업을 진행하는 레코드를 가리키는 것이 있는데 이것을 커서(Cursor)라 한다.
		//next()메서드는 이 커서의 위치를 다음 레코드 위치로 이동시키고 그 자리에 데이터가 있으면 true, 없으면 false를 반환한다.

		//			rs.afterLast(); 커서를 이동시켜주는 명령어들인데 , , 잘 안쓴다 ㅇㅅㅇ
		//			rs.beforeFirst();
		//			rs.first();
		//			rs.last();
		//			rs.previous();

		//컬럼의 데이터를 가져오기 위한 메서드는 'get자료형이름()'메서드를 사용하는데
		//이 메서드의 매개값으로 '컬럼명'또는 '컬럼번호'를 지정하면 된다.(컬럼번호는 1번부터 시작한다.)

		rs.next();
		name = rs.getString("name");

		// 				out.write("<tr>");
		// 				out.write("Std_id : " + rs.getInt("ID")+"<br>");
		// 				out.write("Std_name : " + rs.getString("NAME")+"<br>");
		// 				out.write("Std_call : " + rs.getInt("CALL")+"<br>");
		// 				out.write("─────────────────────────────────"+"<br>");
	%>

	<canvas id="student" width="200" height="200" style="border: 1px solid #000000;"></canvas>
	<canvas id="student2" width="200" height="200" style="border: 1px solid #000000;"></canvas>
	
	<img id=imgs src="../jsp/img/img.jpg" width="220" height="277" style = "visibility:hidden">

</body>

<script>
	var c = document.getElementById("student");
	var ctx = c.getContext("2d");
	ctx.beginPath();
	ctx.arc(100, 100, 100, 0, 2 * Math.PI);
	ctx.stroke();

	ctx.font = "60px arial";
	ctx.fillText("<%=name%>", 10, 115)
	
	var img = document.getElementById("imgs");
	var c2 = document.getElementById("student2");
	var ctx2 = c2.getContext("2d");
	var grd = ctx2.createLinearGradient(0,0,200,0);
	grd.addColorStop(0,"purple");
	grd.addColorStop(1,"white");
	ctx2.fillStyle = grd;
	ctx2.drawImage(imgs,0,0);
	ctx2.font = "60px arial";
	ctx2.fillText("<%=name%>", 10, 115)
	
	
</script>
</html>

















