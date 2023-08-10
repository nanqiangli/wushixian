package com.feizuo.wushixian.alarm;

import com.feizuo.wushixian.alarm.auxiliary.entity.AlarmConfig;

/**
 * 顶级接口
 * @author lixiyuan
 */
public interface Handler {

    boolean check(AlarmConfig config, Object data);

    void handle(AlarmConfig config, Integer id, Object data);
}
