package kr.or.ddit.cookie.utill;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CookieUtillTest {

	private String cookie;
	
	@Before
	public void setup(){
		cookie = "userId=brown; rememberMe=y; checkYn=n";
	}
	
	@Test
	public void cookieSplitTest(){
		/***Given***/
		String[] cookies = cookie.split("; ");
		/***When***/

		/***Then***/
		assertEquals(3, cookies.length);
		assertEquals("userId=brown", cookies[0]);
		assertEquals("rememberMe=y", cookies[1]);
		assertEquals("checkYn=n", cookies[2]);
		
		assertEquals("userId", cookies[0].split("=")[0]);
		assertEquals("rememberMe", cookies[1].split("=")[0]);
		assertEquals("checkYn", cookies[2].split("=")[0]);

	}
	
	/**
	* Method : cookieNameValueSplitTest
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC01
	* 변경이력 :
	* Method 설명 : 쿠키의 이름과 값을 분리 테스트
	*/
	@Test
	public void cookieNameValueSplitTest(){
		/***Given***/
		String cookie = "userId=brown";

		/***When***/
		//cookieArr[0] = userId
		//cookieArr[1] = brown
		String[] cookieArr = cookie.split("=");

		/***Then***/
		assertEquals("userId", cookieArr[0]);
		assertEquals("brown", cookieArr[1]);

	}
	
	@Test
	public void getCookietest() {
		
		/***Given***/
		String cookie = "userId=brown; rememberMe=y";
		CookieUtil cookieUtil = new CookieUtil();

		/***When***/
		//userId ==> brown
		String cookieValue = cookieUtil.getCookie(cookie, "userId");
		String cookieValue2 = cookieUtil.getCookie(cookie, "rememberMe");
		
		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("y", cookieValue2);

		
		
	}

}
