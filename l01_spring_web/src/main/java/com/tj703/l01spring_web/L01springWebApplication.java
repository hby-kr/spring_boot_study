package com.tj703.l01spring_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 어노테이션은 Spring container에서 관리하는 객체를 명시하는 것
// 스프링의 컴포턴트 스캐너가 있어서, 최초 생성된 패키지 하위에 @Component 또는 그 햐위 @어노테이션이 있으면
// 객체를 만들어서 스프링 컨테이너에서 관리. 관리받는 객체를 bean이라 부름.

// @SpringBootApplication은 스프링 부트 애플리케이션의 진입점을 정의
@SpringBootApplication  // = 메인 어플리케이션 객체라는 것.
public class L01springWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(L01springWebApplication.class, args);
	}

}
