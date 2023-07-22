package Taining2.user.Advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* Taining2.user..*Impl.*(..))")
	public void allPointcut() {}
	
	@AfterThrowing(pointcut = "allPointcut()", throwing = "exceptobj")
	public void excptionLog(JoinPoint jp, Exception exceptobj) {
		String method= jp.getSignature().getName();
		System.out.println(method+" () 메소드 예외 발생");
		
		if(exceptobj instanceof IllegalArgumentException) {
			System.out.println("부적절한 값");
		}else if(exceptobj instanceof NumberFormatException) {
			System.out.println("숫자가아님");
		}else if(exceptobj instanceof Exception) {
			System.out.println("문제");
		}
	}
	
}
