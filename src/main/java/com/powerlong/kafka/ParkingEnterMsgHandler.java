package com.powerlong.kafka;

import com.plocc.kafka.consumer.MsgHandler;
import com.plocc.kafka.model.ParkingEnterMsg;
import com.plocc.kafka.support.Topic;
import com.plocc.kafka.support.TopicHelper;
import com.powerlong.model.ParkingDetail;
import com.powerlong.service.SplusCrmService;
import com.powerlong.service.impl.SplusCrmServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Created by wgq on 2015/09/29.
 */
public class ParkingEnterMsgHandler implements MsgHandler<ParkingEnterMsg> {

    private static final Logger logger = Logger.getLogger(ParkingEnterMsgHandler.class);



    @Resource
    private SplusCrmService splusCrmService;

    @Override
    public Topic getTopic() {
        return TopicHelper.PARKING_ENTER;
    }

    @Override
    public void execute(ParkingEnterMsg parkingEnterMsg) {

        logger.info("收到的消息是：" + parkingEnterMsg.getMallName() + "车牌号：" + parkingEnterMsg.getPlateNo() + "进场时间 " + parkingEnterMsg.getEntryTime());

        ParkingDetail parkingDetail = new ParkingDetail();
        parkingDetail.setPlateNo(parkingEnterMsg.getPlateNo());
        parkingDetail.setEntryTime(parkingEnterMsg.getEntryTime());

        try {
            splusCrmService.setWebServiceParking(parkingDetail);

        } catch (Exception e) {

            logger.error(e.getMessage());
        }

    }
}
