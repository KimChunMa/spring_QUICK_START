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
		System.out.println(method+" () �޼ҵ� ���� �߻�");
		
		if(exceptobj instanceof IllegalArgumentException) {
			System.out.println("�������� ��");
		}else if(exceptobj instanceof NumberFormatException) {
			System.out.println("���ڰ��ƴ�");
		}else if(exceptobj instanceof Exception) {
			System.out.println("����");
		}
	}
	
}
