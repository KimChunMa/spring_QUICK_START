package Taining2.user.Advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	//@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		System.out.println("---------beforeLog----------");
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("메소드: " + method +"\n 매개변수 : " +args[0].toString());
	}
}
