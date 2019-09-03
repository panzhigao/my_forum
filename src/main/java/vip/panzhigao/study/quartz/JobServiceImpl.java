package vip.panzhigao.study.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import vip.panzhigao.study.exception.BusinessException;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
/**
 * @author panzhigao
 */
@Slf4j
@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public void addCronJob(String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail != null) {
                log.warn("job:" + jobName + " 已存在");
            } else {
                //构建job信息
                jobDetail = JobBuilder.newJob(CronJob.class).withIdentity(jobName, jobGroup).build();
                //用JopDataMap来传递数据
                jobDetail.getJobDataMap().put("taskData", "hzb-cron-001");

                CronScheduleBuilder scheduleBuilder;
                //表达式调度构建器(即任务执行的时间,每5秒执行一次)
                String cronExpression="aaa";
                try {
                    scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
                }catch (RuntimeException e){
                    log.error("无效的cron表达式,{}",cronExpression,e);
                    throw new BusinessException("无效的cron表达式,"+cronExpression);
                }
                //按新的cronExpression表达式构建一个新的trigger
                CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName + "_trigger", jobGroup + "_trigger")
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            }
        }catch (BusinessException e){
            throw e;
        }catch (Exception e) {
            log.error("addCronJob error",e);
            throw new BusinessException("创建定时任务失败");
        }
    }

    @Override
    public void addAsyncJob(String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();

            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail != null) {
                System.out.println("job:" + jobName + " 已存在");
            }
            else {
                //构建job信息,在用JobBuilder创建JobDetail的时候，有一个storeDurably()方法，可以在没有触发器指向任务的时候，将任务保存在队列中了。然后就能手动触发了
                jobDetail = JobBuilder.newJob(CronJob.class).withIdentity(jobName, jobGroup).storeDurably().build();
                jobDetail.getJobDataMap().put("asyncData","this is a async task");
                //定义name/group
                Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName + "_trigger", jobGroup + "_trigger")
                        //一旦加入scheduler，立即生效
                        .startNow()
                        //使用SimpleTrigger
                        .withSchedule(simpleSchedule())
                        .build();
                scheduler.scheduleJob(jobDetail, trigger);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pauseJob(String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName + "_trigger", jobGroup + "_trigger");
            scheduler.pauseTrigger(triggerKey);
            log.info("=========================pause job:" + jobName + " success========================");
        } catch (SchedulerException e) {
            log.error("pauseJob error",e);
        }
    }

    @Override
    public void resumeJob(String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName + "_trigger", jobGroup + "_trigger");
            scheduler.resumeTrigger(triggerKey);
            log.info("=========================resume job:" + jobName + " success========================");
        } catch (SchedulerException e) {
            log.error("resumeJob error",e);
        }
    }

    @Override
    public void deleteJob(String jobName, String jobGroup) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            JobKey jobKey = JobKey.jobKey(jobName,jobGroup);
            scheduler.deleteJob(jobKey);
            log.info("=========================delete job:" + jobName + " success========================");
        } catch (SchedulerException e) {
            log.error("deleteJob error",e);
        }
    }
}
