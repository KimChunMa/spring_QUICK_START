package Taining2.user.Advice;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCommon {
	@Pointcut("execution(* Taining2.user..*Impl.*(..))")
	public void allPointcut() {}
	@Pointcut("execution(* Taining2.user..*Impl.get*(..))")
	public void getPointcut() {}
	
}
