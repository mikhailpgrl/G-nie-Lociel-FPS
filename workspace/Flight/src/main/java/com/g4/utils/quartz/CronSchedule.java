package com.g4.utils.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;

public class CronSchedule {

	public CronSchedule() throws Exception{
		
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		JobDetail jd = new JobDetail("Job1","groupe1",CronJob.class);
		CronTrigger ct = new CronTrigger("cronTrigger","groupe2","0 0 * * * ?");
		sched.scheduleJob(jd, ct);
		sched.start();
		
	}
	
}
