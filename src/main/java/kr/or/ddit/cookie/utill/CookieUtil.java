package kr.or.ddit.cookie.utill;

public class CookieUtil {

	/**
	* Method : getCookie
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC01
	* 변경이력 :
	* @param cookie
	* @param name
	* @return
	* Method 설명 : 쿠키조회
	*/
	public String getCookie(String cookie, String name) {
		//cookie : userId=brown; rememberMe=y
		
		String[] cookies = cookie.split("; ");
		String cookieResult = "";
		
		//cookieStr : userId=brown, rememberMe=y, checkYn=n
		for(String cookieStr : cookies){
			String[] cookieNameValue = cookieStr.split("=");
			
			String cookieName = cookieNameValue[0];
			String cookieValue = cookieNameValue[1];
			
			if(name.equals(cookieName)){
				cookieResult = cookieValue;
				break;
			}
		}
		
		return cookieResult;
	}

}
