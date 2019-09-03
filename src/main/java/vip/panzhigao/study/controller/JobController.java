package vip.panzhigao.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.panzhigao.study.quartz.JobService;
import vip.panzhigao.study.vo.Response;

/**
 * @author panzhigao
 */
@RestController
@RequestMapping("/quartztest")
public class JobController {


    @Autowired
    private JobService jobService;


    /**
     * 创建cron任务
     * @param jobName
     * @param jobGroup
     * @return
     */
    @RequestMapping(value = "/cron",method = RequestMethod.POST)
    public Response startCronJob(@RequestParam("jobName") String jobName, @RequestParam("jobGroup") String jobGroup){
        jobService.addCronJob(jobName,jobGroup);
        return Response.success("创建定时任务成功");
    }

}
