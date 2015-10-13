package com.powerlong.task;


import com.plocc.scheduler.exception.FatalException;
import com.plocc.scheduler.exception.WarnningException;
import com.plocc.scheduler.task.RunInOneNodeTask;
import com.plocc.scheduler.task.TaskExecuteRequest;
import com.powerlong.service.SplusCrmService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import static com.powerlong.servlet.WebInitServlet.servletContext;


public class ParkingTask extends RunInOneNodeTask {

	private SplusCrmService splusCrmService;

	private Logger logger = Logger.getLogger(ParkingTask.class);

	
	@Override
	public void execute(TaskExecuteRequest context) throws WarnningException,
			FatalException {
		ApplicationContext applicationContext=WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		splusCrmService = (SplusCrmService) applicationContext.getBean("splusCrmServiceImpl");
		
		logger.info("收到任务:"+context);
		
		// 中断检查
		if(checkInterrupt()){
			throw new FatalException("被中断，未执行");
		}
		
		try{
			logger.info("任务："+context.getAppExecNo()+"执行主要逻辑");
			Thread.sleep(1*1000);
			logger.info("定时器任务开始(从科托获取停车场车辆进出记录)");
			//splusCrmService.getWebServiceParking();
			logger.info("定时器任务成功结束(从科托获取停车场车辆进出记录)");
			//在执行主要逻辑中安插中断检查
			if(checkInterrupt()){
				throw new FatalException("被中断，主要逻辑未执行完成");
			}
			
			Thread.sleep(5*1000);
			
		}catch(FatalException e){
			logger.info("异常1-->"+e.getMessage());
			throw e;
		}catch(Exception e){
			logger.info("异常2-->"+e.getMessage());
			throw new FatalException("逻辑执行错误");
		}
		
		//中断检查
		if(checkInterrupt()){
			throw new FatalException("被中断，但主逻辑已经执行完成");
		}
	}
	
	private boolean checkInterrupt(){
		return Thread.currentThread().isInterrupted();
	}	
}
