package ca.sogica.corelibrary;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.time.Duration;
import java.time.Instant;



public class ZipPerformanceTest {

//	public static final int MAX = 3;
//
	@Test
	public void test_case1() {
//		String dest = "C:\\Works\\INVTRATest\\Archive\\sevenZipTest1.zip";
//		String srce = "C:\\Works\\INVTRATest\\Archive\\SOA1\\*.pdf";
//		String pwd = "";
//		String fileSize = "1.2G";
//		callSevenZip(dest, srce, pwd, fileSize);
//		File zipFile = new File(dest);
//		assertTrue(zipFile.exists() && zipFile.isFile());
//
	}

	@Test
	public void test_case2() {
//		String dest = "C:\\Works\\INVTRATest\\Archive\\sevenZipTest2.zip";
//		String srce = "C:\\Works\\INVTRATest\\Archive\\SOA2\\*.pdf";
//		String pwd = "";
//		String fileSize = "2.4G";
//		callSevenZip(dest, srce, pwd, fileSize);
//		File zipFile = new File(dest);
//		assertTrue(zipFile.exists() && zipFile.isFile());
	}

	@Test
	public void test_case4() {
//		String dest = "C:\\Works\\INVTRATest\\Archive\\sevenZipTest4.zip";
//		String srce = "C:\\Works\\INVTRATest\\Archive\\SOA4\\*.pdf";
//		String pwd = "";
//		String fileSize = "4.8G";
//		callSevenZip(dest, srce, pwd, fileSize);
//		File zipFile = new File(dest);
//		assertTrue(zipFile.exists() && zipFile.isFile());
	}

	private void callSevenZip(String dest, String srce, String pwd, String fileSize) {
		Instant startTime = Instant.now();
		// long startTime = System.currentTimeMillis();
		ZipUtil.zip(dest, srce, pwd);
		Duration runTime = Duration.between(startTime, Instant.now());
		System.out.println("Total runtime for " + fileSize + runTime.toMillis() + " ms");
		
	}

	public static void main(String[] args) {
		for (String temp : args) {
			System.out.println(temp);
		}
		System.out.println();

	}

}
