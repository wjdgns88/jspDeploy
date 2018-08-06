package kr.or.ddit.FileUtil;

import static org.junit.Assert.*;
import kr.or.ddit.file.FileUtil;

import org.junit.Test;

public class FileUtilTest {
	
	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"uploadFile\"; filename=\"james.png\"";
		/***When***/
		String fileName = FileUtil.getFileName(contentDisposition);
		/***Then***/
		assertEquals("james.png", fileName);
		
	}

}
