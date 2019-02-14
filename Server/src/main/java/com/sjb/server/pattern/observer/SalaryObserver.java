package com.sjb.server.pattern.observer;

import com.sjb.server.model.UserInfo;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;

import java.util.List;

/**
 * ConcreateObserver(구체적인 관리자)의 역할
 */
public class SalaryObserver implements Observer {
    @Override
    public void update(Subject subejct) {
        List<UserInfo> userInfos = subejct.getUserInfos();
        userInfos.forEach(user -> {
            Print print = PrintLog.newInstance(user.getName() + "님, 월급이 지급되었습니다.");
            print.printWithSout();
        });
    }
}
