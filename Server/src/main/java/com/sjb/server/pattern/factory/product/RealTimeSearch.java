package com.sjb.server.pattern.factory.product;

import com.sjb.server.model.UserInfo;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.decorator.RealUserName;
import com.sjb.server.pattern.decorator.RespectUserName;
import com.sjb.server.pattern.decorator.UserName;
import com.sjb.server.pattern.mediator.ChatMediator;
import com.sjb.server.pattern.mediator.User;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * Factory Method 패턴
 * ConcreteProduct(구체적인 제품)
 */
public class RealTimeSearch extends Product {
    // 다형성 사용
    @Override
    protected void run(String name, String nowDt) {
        ChatMediator chatMediator = new ChatMediator();
        List<UserInfo> userInfoList = realtimeDatabase.get(nowDt);
        if (CollectionUtils.isNotEmpty(userInfoList)) {
            userInfoList.forEach(userInfo -> {
                /**
                 * Decorator 패턴
                 */
                UserName user = new RespectUserName(new RealUserName(userInfo.getName()));

                /**
                 * Prototype 패턴 (ConcretePrototpye, Cliente 는 생략 했다.)
                 */
                // 저장 된 데이터를 2차 가공, 원본 데이터를 훼손 하지 않고 이름 뒤에 ~씨를 붙이려고 한다.
                try {
                    UserInfo cloneUserInfo = (UserInfo) userInfo.clone();
                    cloneUserInfo.setName(user.getUserName());
                    Print print = PrintLog.newInstance(cloneUserInfo.toString());
                    print.printWithSout();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

                /**
                 * Mediator 패턴 (전체 공지)
                 */
                chatMediator.appendUser(new User(chatMediator, userInfo.getName()));
                chatMediator.notice("안뇽하세요");
            });
        }
    }
}
