package com.feizuo.wushixian.alarm;

import com.feizuo.wushixian.alarm.auxiliary.entity.AlarmConfig;
import com.feizuo.wushixian.alarm.auxiliary.entity.CurrentAlarm;
import com.feizuo.wushixian.alarm.auxiliary.service.CurrentAlarmService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * 抽象类, 抽取通用字段/方法, 实现模板方法
 * @author lixiyuan
 */
public class AbstractHandler implements Handler {

    @Autowired
    private CurrentAlarmService currentAlarmService;

    @Override
    public boolean check(AlarmConfig config, Object data) {
        return false;
    }

    @Override
    public void handle(AlarmConfig config, Integer id, Object data) {
        // 获取当前存在的告警
        CurrentAlarm current = currentAlarmService.getCurrentAlarmById();
        // 比较阈值
        boolean check = check(config, data);

        // 为true发生告警
        if (check) {
            if (current == null) {
                // 创建告警
                currentAlarmService.save();
            } else {
                // 更新告警
                currentAlarmService.update();
            }
        } else {
            if (current != null) {
                // 结束告警
                currentAlarmService.finish();
            }
        }
    }

    /**
     * 反射获取属性值
     */
    protected String getValueByField(Object obj, String fieldName) {
        if (obj == null) {
            return "";
        }
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(obj);
            return value == null ? "" : value.toString();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println();
            throw new RuntimeException(e);
        }
    }

    /**
     * 如果判定方法比较通用, 也可以在这里定义好, 各个子类调用一下就行
     */
    protected boolean commonCompare() {
        return false;
    }
}
