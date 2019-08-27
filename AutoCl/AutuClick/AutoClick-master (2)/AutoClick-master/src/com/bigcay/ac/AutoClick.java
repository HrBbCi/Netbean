package com.bigcay.ac;

import java.io.File;

import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bigcay.ac.schedule.BaiduAdClickJob;

public class AutoClick {

	private static final Logger logger = LoggerFactory.getLogger(AutoClick.class);
	
	public static void main(String[] args) {
		
		String dir = System.getProperty("user.dir");
		String osName = System.getProperty("os.name");
		
		// load the appropriate chrome drivers according to the OS type
		if (osName.toLowerCase().indexOf("windows") > -1) {
			// use chrome driver
//			System.setProperty("webdriver.chrome.driver", dir + File.separator + "drivers" + File.separator + "win"
//					+ File.separator + "chromedriver.exe");
			// use phantomjs driver
			System.setProperty("phantomjs.binary.path", dir + File.separator + "drivers" + File.separator + "win"
					+ File.separator + "phantomjs.exe");
		} else if (osName.toLowerCase().indexOf("mac") > -1) {
			// use chrome driver
//			System.setProperty("webdriver.chrome.driver", dir + File.separator + "drivers" + File.separator + "mac"
//					+ File.separator + "chromedriver");
			// use phantomjs driver 1.9.7
			System.setProperty("phantomjs.binary.path", dir + File.separator + "drivers" + File.separator + "mac"
					+ File.separator + "phantomjs");
		}
		
		String userAgent = "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1";
		System.setProperty("phantomjs.page.settings.userAgent", userAgent);
		
		JobDetail job1 = JobBuilder.newJob(BaiduAdClickJob.class).withIdentity("BaiduAdClickJob1", null).build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("defaultTrigger", null)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(30).repeatForever())
				.build();
		
		try {
			
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			
			scheduler.start();

			scheduler.scheduleJob(job1, trigger);
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
