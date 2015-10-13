package com.powerlong.service.impl;

import com.powerlong.mapper.PosMonitorLogsMapper;
import com.powerlong.model.PosMonitorLogs;
import com.powerlong.service.PosMonitorLogsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wgq on 2015/05/12.
 */
@Service("posmonitorService")
public class PosMonitorLogsServiceImpl implements PosMonitorLogsServiceI {
    @Resource
    private PosMonitorLogsMapper posMonitorLogsMapper;


    public PosMonitorLogsMapper getPosMonitorLogsMapper() {
        return posMonitorLogsMapper;
    }


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private void setPosMonitorLogsMapper(PosMonitorLogsMapper posMonitorLogsMapper) {
        this.posMonitorLogsMapper = posMonitorLogsMapper;
    }

    @Override
    public PosMonitorLogs getPosMonitorLogsById(Long id) {
        return posMonitorLogsMapper.selectByPrimaryKey(id);
    }

    @Override
    public PosMonitorLogs getPosMonitorLogsById(String cptId) {

        return posMonitorLogsMapper.selectByCptId(cptId);
    }

    @Override
    public void savePosMonitorLogs(PosMonitorLogs posmonitorLogs) {

        posMonitorLogsMapper.insertSelective(posmonitorLogs);

    }

    @Override
    public void updatePosMonitorLogs(PosMonitorLogs posmonitorLogs) {

        posMonitorLogsMapper.updateByPrimaryKeySelective(posmonitorLogs);

    }
}
