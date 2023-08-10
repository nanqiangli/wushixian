package com.feizuo.wushixian.alarm.auxiliary.service;

import com.feizuo.wushixian.alarm.auxiliary.entity.CurrentAlarm;

/**
 * 告警service接口
 * @author lixiyuan
 */
public interface CurrentAlarmService {
    CurrentAlarm getCurrentAlarmById();

    void save();

    void update();

    void finish();
}
