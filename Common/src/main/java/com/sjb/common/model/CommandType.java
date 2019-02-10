package com.sjb.common.model;

public enum CommandType {
    REALTIME_DATA_STORE("realtime data store", "실시간 데이터 저장"),
    ANALYSIS_DATA_STORE("analysis data store", "통계성 데이터 저장"),
    REALTIME_DATA_SEARCH("realtime data search", "실시간 데이터 조회"),
    ANALYSIS_DATA_SEARCH("analysis data search", "통계성 데이터 조회"),
    PROCESSING_DATA_STORE("processing data store", "데이터 가공 저장"),
    PROCESSING_DATA_SERACH("processing data search", "데이터 가공 조회");

    private String name;
    private String desc;

    CommandType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }
}
