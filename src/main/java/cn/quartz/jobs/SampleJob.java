package cn.quartz.jobs;

import cn.hutool.core.date.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 示例带参定时任务
 * @author jianconglee
 */
public class SampleJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

//        log.info(String.format("欢迎使用XBoot前后端分离开发平台!作者:Exrick 时间:"+ DateUtil.now()));
    }
}
