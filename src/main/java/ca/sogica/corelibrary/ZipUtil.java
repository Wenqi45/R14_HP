package ca.sogica.corelibrary;

import java.io.IOException;

/**
 * 
 * @author Wenqi.Wang
 *
 */
public class ZipUtil {

	/**
	 * Adds files to archive
	 * 
	 * @param dest   -
	 * @param source - the source folder and files with specific extension and its
	 *               subfolders to be archived
	 * @param pwd
	 * 
	 */

	public static void zip(String dest, String source, String pwd) {

		int availableProcessors = Runtime.getRuntime().availableProcessors();
		String multiThread = "-mmt" + availableProcessors;

		ProcessBuilder processBuilder = new ProcessBuilder();
		// System.out.println("Available processors are " + availableProcessors);
		String volumeLimit = "-v1g";
		String tempDir = "-wc:\\temp";
		String compressionLevel = "-mx1";
		String sevenZipCommand = "C:\\Program Files\\7-Zip\\7z.exe";

		// construct commindline
		String[] commandLine = { sevenZipCommand, "a", dest, source, multiThread, tempDir, compressionLevel, "-r" };

		if (pwd.equals(""))
			processBuilder.command(commandLine);
		else {
			// commandline_opt = {sevenZipCommand, "a", dest, source, multiThread,
			// tempDir,compressionLevel,"-p"+pwd, "-r"}; // array
			int newLength = commandLine.length + 1;
			String[] commandlineWithPwd = new String[newLength];
			System.arraycopy(commandLine, 0, commandlineWithPwd, 0, commandLine.length);
			commandlineWithPwd[newLength - 1] = "-p" + pwd;
			processBuilder.command(commandlineWithPwd);
		}

		try {
			Process process = processBuilder.start();
			int ret = process.waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * eXtract files with full paths
	 * 
	 * @param source
	 * @param dest
	 * @param pwd
	 */
	public static void unZip(String source, String dest, String pwd) {
//		String unzipSource = "C:\\Works\\INVTRATest\\Archive\\sevenZip_2.zip";
//		String unzipDest = "C:\\Works\\INVTRATest\\Archive\\Test\\";
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		String multiThread = "-mmt" + availableProcessors;
		ProcessBuilder processBuilder = new ProcessBuilder();

		// String volumeLimit = "-v1g";
		String tempDir = "-wc:\\temp";
		String sevenZipCommand = "C:\\Program Files\\7-Zip\\7z.exe";

		String[] commandLine = { sevenZipCommand, "e", source, "-o" + dest };
		String[] commandLine_Opt = { sevenZipCommand, "e", source, "-o" + dest, multiThread, tempDir, "-p" + pwd };

		//processBuilder.command(unzipCommandLine);
		if (pwd.equals(""))
			processBuilder.command(commandLine);
		else {
			int newLength = commandLine.length + 1;
			String[] commandlineWithPwd = new String[newLength];
			System.arraycopy(commandLine, 0, commandlineWithPwd, 0, commandLine.length);
			commandlineWithPwd[newLength - 1] = "-p" + pwd;
			processBuilder.command(commandlineWithPwd);
		}

		try {
			Process process = processBuilder.start();
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
