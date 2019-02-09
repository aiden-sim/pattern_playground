package com.sjb.server.pattern.factory;

import com.sjb.server.model.UserInfo;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Factory Method 패턴
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
                /**
                 * Prototype 패턴 (ConcretePrototpye, Cliente 는 생략 했다.)
                 */
                // 저장 된 데이터를 2차 가공, 이름 뒤에 ~씨를 붙이려고 한다.
                try {
                    UserInfo cloneUserInfo = (UserInfo) userInfo.clone();
                    cloneUserInfo.setName(userInfo.getName() + "씨");
                    Print print = PrintLog.newInstance(cloneUserInfo.toString());
                    print.printWithSout();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
