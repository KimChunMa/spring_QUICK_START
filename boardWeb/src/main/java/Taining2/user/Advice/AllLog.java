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
		System.out.println(method + " �޼ҵ� �ɸ� �ð� : " + watch.getTotalTimeMillis()+ " (ms) ��");
		
		return obj;
	}
}
