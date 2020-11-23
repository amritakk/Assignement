package com.nobroker.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScreenShotCapture {

	public static String takeScreenshotPass(WebDriver driver, String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String base64 = encodeFileToBase64Binary(src);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String path = "./ScreenShotPass/" + screenshotname + "_" + timeStamp + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			e.getMessage();
		}
		return base64;
	}

	public static String takeScreenshotFail(WebDriver driver, String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String base64 = encodeFileToBase64Binary(src);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String path = "./ScreenShotFail/" + screenshotname + "_" + timeStamp + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			e.getMessage();
		}
		return base64;
	}

	public static String takeScreenshot(AndroidDriver<AndroidElement> driver, String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String base64 = encodeFileToBase64Binary(src);
		System.out.println(base64);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String path = "./ScreenShot/" + screenshotname + "_" + timeStamp + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			e.getMessage();
		}
		return base64;
	}

	private static String encodeFileToBase64Binary(File file) {
		String encodedfile = null;
		try {
			@SuppressWarnings("resource")
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = Base64.getEncoder().encodeToString(bytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encodedfile;
	}

}
