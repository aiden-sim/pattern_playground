package com.sjb.common.pattern.iterator;

/**
 * Iterator 패턴
 * Aggregate(집합체)
 * Iterator 역할을 만들어내는 인터페이스를 결정
 */
public interface Aggregate {
    Iterator iterator();
}
