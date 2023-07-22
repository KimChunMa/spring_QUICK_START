package Taining2.user.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* Taining2.user..*Impl.*(..))")
	public void allPointcut() {}
	
	//@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch watch = new StopWatch();
		watch.start();
		
		Object obj = pjp.proceed();
		watch.stop();
		System.out.println(method + " �޼ҵ� �ɸ� �ð� : " + watch.getTotalTimeMillis()+ " (ms) ��");
		
		return obj;
	}
}
