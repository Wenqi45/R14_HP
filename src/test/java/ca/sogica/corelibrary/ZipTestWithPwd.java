package ca.sogica.corelibrary;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ZipTestWithPwd {

	@Test
	public void testZip() throws IOException {
		String dest = "C:\\Works\\INVTRATest\\Archive\\sevenZipTest_WithPWD.zip";
		String source = "C:\\Works\\INVTRATest\\Archive\\TestWithPWD\\*.pdf";
		String password = "password";
		ZipUtil.zip(dest, source, password);
		File file = new File(dest);
		assertTrue(file.exists() && file.isFile());
		FileUtils.deleteDirectory(new File("C:\\Works\\INVTRATest\\Archive\\TestWithPWD"));
	}

	@Test
	public void testUnzip() throws IOException {
		String unzipSource = "C:\\Works\\INVTRATest\\Archive\\sevenZipTest_WithPWD.zip";
		String unzipDest =   "C:\\Works\\INVTRATest\\Archive\\TestWithPWD\\";
		String pwd = "password";
		ZipUtil.unZip(unzipSource, unzipDest, pwd);
		
		File zipDir = new File(unzipDest);		
        assertTrue(zipDir.exists()&&zipDir.isDirectory());
        FileUtils.forceDelete(new File(unzipSource));
	}
	
	public static void main(String[] args) throws IOException {
		ZipTestWithPwd z = new ZipTestWithPwd();
		z.testZip();
	}

}
