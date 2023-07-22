package Taining2.user.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;


public class AllLog {
	public Object allLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch watch = new StopWatch();
		watch.start();
		
		Object obj = pjp.proceed();
		watch.stop();
		System.out.println(method + " 메소드 걸린 시간 : " + watch.getTotalTimeMillis()+ " (ms) 초");
		
		return obj;
	}
}
