package com.sjb.server.pattern.factory;

import com.sjb.server.model.DetailUserInfo;
import com.sjb.server.model.Gender;
import com.sjb.server.model.UserInfo;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * Factory Method 패턴
 * ConcreteProduct(구체적인 제품)
 */
public class ProcessingData extends Product {
    // 다형성 사용
    @Override
    protected void run(String name) {
        String nowDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        List<UserInfo> userInfoList = realtimeDatabase.get(nowDt);
        if (CollectionUtils.isNotEmpty(userInfoList)) {
            userInfoList.forEach(userInfo -> {
                /**
                 * Builder 패턴
                 */
                DetailUserInfo result = new DetailUserInfo.UserInfoBuilder()
                        .setName(userInfo.getName())
                        .setCreateDt(userInfo.getCreateDt())
                        .setAge((int) (Math.random() * 150))
                        .setGender(((int) (Math.random() * 2)) == 0 ? Gender.FEMALE : Gender.MALE)
                        .build();


            });
        }
    }
}
