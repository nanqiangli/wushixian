package com.feizuo.wushixian.alarm;

import com.feizuo.wushixian.alarm.auxiliary.entity.AlarmConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 为了更好的保护告警模块的完整性, 建议加一下代理屏蔽内部逻辑,
 * 其他模块仅需要引用
 * @author lixiyuan
 */
@Component
public class AlarmMgr {

    // spring对策略模式的支持
    @Autowired
    private Map<String, Handler> handlerMap;

    public void checkAlarm(AlarmConfig config, Integer id, Object data) {
        Handler handler = handlerMap.get(config.getAlarmCode());
        if (handler == null) {
            System.out.println();
            return;
        }
        handler.handle(config, id, data);
    }
}
