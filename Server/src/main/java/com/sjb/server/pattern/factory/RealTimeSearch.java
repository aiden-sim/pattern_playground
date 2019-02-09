package com.sjb.server.pattern.factory;

import com.sjb.server.model.UserInfo;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * ConcreteProduct(구체적인 제품)
 */
public class RealTimeSearch extends Product {
    // 다형성 사용
    @Override
    protected void run(String name) {
        String nowDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        List<UserInfo> userInfoList = realtimeDatabase.get(nowDt);
        if (CollectionUtils.isNotEmpty(userInfoList)) {
            userInfoList.forEach(userInfo -> {
                Print print = PrintLog.newInstance(userInfo.toString());
                print.printWithSout();
            });
        }
    }
}
