package com.happyhouse.backend.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	// @Before: join point - 언제 aop를 동작시킬 것인가?
	// join point annotation의 value 속성: pointcut - aop를 적용할 것인지 판단하는 필터
	@Before("execution(  * com.ssafy.hw.model..*.*(..))")
	// 횡단관심코드 - 하고 싶은 일
	public void logging(JoinPoint jp) {
		logger.debug("메서드 호출됨: 메서드 선언부: {}, 전달된 파라미터: {}", jp.getSignature(), Arrays.toString(jp.getArgs()));
	}
}
