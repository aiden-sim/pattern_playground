package com.sjb.server.pattern.factory.creator;

import com.sjb.common.model.CommandType;
import com.sjb.server.pattern.factory.product.Product;

/**
 * Factory Method 패턴
 * Creator(작성자)
 * Creator 역할이 가지고 있는 정보는 Product 역할과 인스턴스 생성의 메소드를 호출하면 Product가 생성된다는 것이다.
 *
 * Proxy 패턴 (Subjecet)
 */
public abstract class Factory {
	public abstract Product create(CommandType commandType);
}
