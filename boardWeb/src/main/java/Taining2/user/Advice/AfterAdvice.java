package Taining2.user.Advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	@Pointcut("execution(* Taining2.user..*Impl.*(..))")
	public void allPointcut() {}
	
	//@After("allPointcut()")
	public void finallyLog() {
		System.out.println("after 어드바이스 ==finally");
	}
}
