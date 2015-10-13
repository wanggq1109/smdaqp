package com.powerlong.service;


import com.powerlong.model.PosMonitorLogs;

/**
 * Created by wgq on 2015/05/12.
 */
public interface PosMonitorLogsServiceI {

    public PosMonitorLogs getPosMonitorLogsById(Long id);

    public PosMonitorLogs getPosMonitorLogsById(String cptId);

    public void  savePosMonitorLogs(PosMonitorLogs posmonitorLogs);

    public void updatePosMonitorLogs(PosMonitorLogs posmonitorLogs);



}
