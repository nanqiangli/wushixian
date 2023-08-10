package com.feizuo.wushixian.alarm;

import com.feizuo.wushixian.alarm.auxiliary.entity.AlarmConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author lixiyuan
 */
@Component
public class HumidityHandler extends AbstractHandler {

    @Override
    public boolean check(AlarmConfig config, Object data) {
        // 通过反射获取实时数据
        String humidity = getValueByField(data, "humidity");
        // 拿到配置中的阈值,然后比较, 略
        return false;
    }
}
