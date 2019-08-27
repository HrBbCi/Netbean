package com.bigcay.ac.schedule;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigcay.ac.config.BaiduAdClickConfig;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaiduAdClickJob implements Job {
	private static final Logger logger = LoggerFactory.getLogger(BaiduAdClickJob.class);

	private static int MAX_THREADS_NUM = 2;
	private static int CURRENT_THREAD_NUM = 0;

	private static int PROXY_EXTRACT_NUM = 10;
	private static final int WEBDRIVER_PAGE_TIMEOUT = 10;
	public static final long SLEEP_TIME = 2000l;

	private static final String SHOW_IP_INFO_URL = "http://1212.ip138.com/ic.asp";
	private static String PROXY_EXTRACT_URL = "http://xvre.daili666api.com/ip/?tid=557510611046590&num={PROXYNUM}&operator=1,2,3&delay=1&category=2&foreign=none&filter=on";
	private static final String BAIDU_SEARCH_URL = "https://www.baidu.com/s?wd={KEYWORD}&rsv_iqid-{RANDOM}";

	private static String searchKeyword = "包子加盟";
	private static String[] targetLinkPartialTexts = { "天津吕记大帅包", "诚招包子加盟中草药配方", "全国包子加盟店店，吕记包子", "吕记包子包子加盟店", "包子加盟店认准吕记包子" };
	
	static {
		ObjectMapper mapper = new ObjectMapper();
		BaiduAdClickConfig config = null; 
		
		try {
			config = mapper.readValue(new File("BaiduAdClickConfig.json"), BaiduAdClickConfig.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// override configurations
		if (config.getMaxThreadNumber() > 0) {
			logger.info("Setting MAX_THREADS_NUM to " + config.getMaxThreadNumber());
			MAX_THREADS_NUM = config.getMaxThreadNumber();
		}
		
		if (config.getProxyExtractUrl() != null && config.getProxyExtractUrl().length() > 0) {
			logger.info("Setting PROXY_EXTRACT_URL to " + config.getProxyExtractUrl());
			PROXY_EXTRACT_URL = config.getProxyExtractUrl();
		}
		
		if (config.getProxyExtractNumber() > 0) {
			logger.info("Setting PROXY_EXTRACT_NUM to " + config.getProxyExtractNumber());
			PROXY_EXTRACT_NUM = config.getProxyExtractNumber();
		}
		
		if (config.getSearchKeyword() != null && config.getSearchKeyword().length() > 0) {
			logger.info("Setting searchKeyword to " + config.getSearchKeyword());
			searchKeyword = config.getSearchKeyword();
		}
		
		if (config.getTargetLinkPartialTexts() != null && config.getTargetLinkPartialTexts().length > 0) {
			logger.info("Setting targetLinkPartialTexts to " + config.getTargetLinkPartialTexts());
			targetLinkPartialTexts = config.getTargetLinkPartialTexts();
		}
		
	}
	
	public static synchronized boolean beginJob() {
		
		if (CURRENT_THREAD_NUM + 1 > MAX_THREADS_NUM) {
			return false;
		} else {
			CURRENT_THREAD_NUM++;
			return true;
		}
	}

	public static synchronized void endJob() {
		CURRENT_THREAD_NUM--;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		if (BaiduAdClickJob.beginJob()) {
			logger.warn("BaiduAdClickJob begins.");
			
			DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
			capabilities.setJavascriptEnabled(true);
			
			String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE" };
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
			
			WebDriver webDriver0 = new PhantomJSDriver(capabilities);
			
			String proxyResult = null;
			try {
				webDriver0.get(PROXY_EXTRACT_URL.replaceFirst("\\{PROXYNUM\\}", String.valueOf(PROXY_EXTRACT_NUM)));
				proxyResult = webDriver0.findElement(By.xpath("//body/pre")).getText().trim();
				
				logger.warn("proxyResult: " + "\n" + proxyResult);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				webDriver0.quit();
				webDriver0 = null;
			}

			if (proxyResult.indexOf("ERROR") >= 0) {
				// failed to extract the proxy addresses
				
				logger.warn("Failed to extract the proxy addresses, try again later. ");
				return; 
			}
			
			String[] proxyArray = proxyResult.split("\n");

			for (int proxyIndex = 0; proxyIndex < proxyArray.length; proxyIndex++) {

				WebDriver webDriver = null;
				String proxyRow = null;

				try {
					proxyRow = proxyArray[proxyIndex];
					logger.warn("proxyRow:" + proxyRow);

					Proxy proxy = new Proxy();
					proxy.setProxyType(ProxyType.MANUAL);
					//proxy.setHttpProxy(proxyRow);
					proxy.setSslProxy(proxyRow);

					DesiredCapabilities capabilities2 = DesiredCapabilities.phantomjs();
					capabilities2.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);

					webDriver = new PhantomJSDriver(capabilities2);
					
					//webDriver.manage().timeouts().pageLoadTimeout(WEBDRIVER_PAGE_TIMEOUT, TimeUnit.SECONDS);

					/*
					
					// get ip information
					webDriver.get(SHOW_IP_INFO_URL);
					
					String ipInfo = webDriver.findElement(By.xpath("//body/center")).getText().trim();
					logger.info("Proxy Info: " + ipInfo);
					*/

					int maxRetryCount = 2;

					for (int retryIndex = 1; retryIndex < maxRetryCount; retryIndex++) {

						String random1 = String.valueOf(Math.random());
						String url = BAIDU_SEARCH_URL.replaceFirst("\\{KEYWORD\\}", URLEncoder.encode(searchKeyword, "utf-8")).replaceFirst(
								"\\{RANDOM\\}", random1);

						webDriver.get(url);
						
						logger.warn("title: " + webDriver.getTitle());
						
						//logger.info("page source: \n" + webDriver.getPageSource());
						
						//File screenShotFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);  
				        //FileUtils.copyFile(screenShotFile, new File("/Users/apple/leo/" + random1 + ".jpg"));

						try {
							if (webDriver.findElement(By.xpath("//*[contains(text(), 'ERR_PROXY_CONNECTION_FAILED')]"))
									.getText().length() > 0) {
								logger.info("contains 'ERR_PROXY_CONNECTION_FAILED', break!");
								break;
							}

							if (webDriver.findElement(By.xpath("//*[contains(text(), 'ERR_CONNECTION_RESET')]"))
									.getText().length() > 0) {
								logger.info("contains 'ERR_CONNECTION_RESET', break!");
								break;
							}

							if (webDriver.findElement(By.xpath("//*[contains(text(), 'Could not connect')]")).getText()
									.length() > 0) {
								logger.info("contains 'Could not connect', break!");
								break;
							}

							if (webDriver.findElement(By.xpath("//*[contains(text(), '很抱歉，您要访问的页面不存在')]")).getText()
									.length() > 0) {
								logger.info("contains '很抱歉，您要访问的页面不存在', break!");
								break;
							}

						} catch (NoSuchElementException ex) {
							// do nothing
						}

						try {
							Thread.sleep(SLEEP_TIME);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						boolean successFlag = false;

						for (int targetTextIndex = 0; targetTextIndex < targetLinkPartialTexts.length; targetTextIndex++) {
							try {
								logger.warn("search for target text: " + targetLinkPartialTexts[targetTextIndex]);
								
								WebElement targetLinkElement = webDriver.findElement(By
										.partialLinkText(targetLinkPartialTexts[targetTextIndex]));
								targetLinkElement.click();

								successFlag = true;
								logger.warn("[成功] - 恭喜您成功通过代理(" + proxyRow + ")进行点击！");

								// get page title
								String pageTitle = webDriver.getTitle();
								logger.info("Page Title: " + pageTitle);

								try {
									Thread.sleep(5000l);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								break;

							} catch (NoSuchElementException nsex) {
							} catch (Exception e) {
							}
						}

						if (successFlag) {
							logger.info("Break as it was already clicked successfully! ");
							break;
						}
					}

				} catch (Exception ex) {
					logger.warn("Error when using proxy: " + proxyRow);
				} finally {
					webDriver.quit();
					webDriver = null;
				}
			}

			BaiduAdClickJob.endJob();
			logger.warn("BaiduAdClickJob ends.");
			
		} else {
			logger.info("BaiduAdClickJob meets the max thread number, so exits. ");
		}
	}

}
