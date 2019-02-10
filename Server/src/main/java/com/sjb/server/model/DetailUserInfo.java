package com.sjb.server.model;

import java.time.LocalDateTime;

/**
 * 빌더 패턴 (GOF 기준이 아닌 Effective Java 기준)
 * UserInfo를 근간으로 좀더 구체적인 유저 정보를 생성한다.
 */
public class DetailUserInfo {
    private String name;
    private int age;
    private LocalDateTime createDt;
    private Gender gender;

    public DetailUserInfo(UserInfoBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.createDt = builder.createDt;
        this.gender = builder.gender;
    }

    public static class UserInfoBuilder {
        private String name;
        private int age;
        private LocalDateTime createDt;
        private Gender gender;

        public UserInfoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserInfoBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserInfoBuilder setCreateDt(LocalDateTime createDt) {
            this.createDt = createDt;
            return this;
        }

        public UserInfoBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public DetailUserInfo build() {
            return new DetailUserInfo(this);
        }
    }
}
