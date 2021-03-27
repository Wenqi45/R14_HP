package ca.sogica.corelibrary;

import static org.junit.Assert.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class ZipTestWithOutPwd {

	@Test
	public void testZip() throws IOException {
		String dest = "C:\\Works\\INVTRATest\\Archive\\sevenZip_NoPwd.zip";
		String source = "C:\\Works\\INVTRATest\\Archive\\Test\\*.pdf";
		String password = "";
		ZipUtil.zip(dest, source, "");
		//verify zip file
        File file = new File(dest);	
        assertTrue(file.exists()&&file.isFile());
        //delete source folder for unizp test
        FileUtils.deleteDirectory(new File("C:\\Works\\INVTRATest\\Archive\\Test"));
	}
	
	@Test
	public void testUnzip() throws IOException {
		String unzipSource = "C:\\Works\\INVTRATest\\Archive\\sevenZip_NoPwd.zip";
		String unzipDest = "C:\\Works\\INVTRATest\\Archive\\Test\\";
		String pwd = "";
		ZipUtil.unZip(unzipSource, unzipDest, "");
		
		File file = new File(unzipDest);		
        assertTrue(file.exists()&&file.isDirectory());
        FileUtils.forceDelete(new File("C:\\Works\\INVTRATest\\Archive\\sevenZip_NoPwd.zip"));
	}
	
	@Test
	public void testSouceNull() {
//		String dest = "C:\\Works\\INVTRATest\\Archive\\sevenZipTest_WithPWD.zip";
//		String source = null;
//		String password = "";
//		
//		ZipUtil.zip(dest, source, "");
	}

}
