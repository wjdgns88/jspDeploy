<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
		ResultSet rs = null;	//쿼리문이 'select'일 경우 필요
		
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
			String sql = "select * from student"; //string안에다 ; 쓰면 안됏
			rs = stmt.executeQuery(sql);
			
			//5. 결과 처리 : ResultSet객체에 저장되어있는 자료를 반복문을 이용하여 차례로 읽어와 처리한다.
			System.out.println("== 실행 결과 ==");
			//ResultSet객체에 담겨있는 데이터(레코드)에 접근하기위해
			//현재 작업을 진행하는 레코드를 가리키는 것이 있는데 이것을 커서(Cursor)라 한다.
			//next()메서드는 이 커서의 위치를 다음 레코드 위치로 이동시키고 그 자리에 데이터가 있으면 true, 없으면 false를 반환한다.
			
//			rs.afterLast(); 커서를 이동시켜주는 명령어들인데 , , 잘 안쓴다 ㅇㅅㅇ
//			rs.beforeFirst();
//			rs.first();
//			rs.last();
//			rs.previous();
			
			while(rs.next()){
				//컬럼의 데이터를 가져오기 위한 메서드는 'get자료형이름()'메서드를 사용하는데
				//이 메서드의 매개값으로 '컬럼명'또는 '컬럼번호'를 지정하면 된다.(컬럼번호는 1번부터 시작한다.)
				out.write("<tr>");
				out.write("Std_num : " + rs.getInt("STD_NUM")+"<br>");
				out.write("Std_name : " + rs.getString("STD_NAME")+"<br>");
				out.write("Std_kor : " + rs.getInt("STD_KOR")+"<br>");
				out.write("Std_eng : " + rs.getInt("STD_ENG")+"<br>");
				out.write("Std_mat : " + rs.getInt("STD_MAT")+"<br>");
				out.write("--------------------------------------"+"<br>");
			}
			


%>

<!-- oracle db의 student 테이블을 조회하여 화면에 출력 -->
</body>
</html>