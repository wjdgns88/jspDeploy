<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.DriverManager"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="lgu" type="java.lang.String" required="true"%>


<%

//DB작업에 필요한 객체 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	//쿼리문이 'select'일 경우 필요
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			String user = "pc01";
			String pass = "1234";
			conn = DriverManager.getConnection(url, user, pass);
			
			stmt = conn.createStatement();
			
			String sql = "select * from prod where prod_lgu = '"+lgu+"'";
			rs = stmt.executeQuery(sql);
			
			out.write("<select>");
			while(rs.next()){
				out.write("<option value=\'"+ rs.getString("prod_id")+"\'>"+rs.getString("prod_name")+"</option>");
			}
			out.write("</select>");
%>