package com.feizuo.wushixian.alarm.auxiliary.service.impl;

import com.feizuo.wushixian.alarm.auxiliary.entity.CurrentAlarm;
import com.feizuo.wushixian.alarm.auxiliary.service.CurrentAlarmService;
import org.springframework.stereotype.Service;

/**
 *
 * @author lixiyuan
 */
@Service
public class CurrentAlarmServiceImpl implements CurrentAlarmService {
    @Override
    public CurrentAlarm getCurrentAlarmById() {
        // 获取当前正在的告警
        return null;
    }

    @Override
    public void save() {
        // 保存新告警
    }

    @Override
    public void update() {
        // 更新告警
    }

    @Override
    public void finish() {
        // 结束告警
    }
}
