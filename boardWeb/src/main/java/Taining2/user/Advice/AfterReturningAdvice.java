package Taining2.user.Advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import Taining2.user.UserDTO;

@Service
@Aspect
public class AfterReturningAdvice {
	@AfterReturning(pointcut="PointcutCommon.allPointcut()",returning ="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserDTO) {
			UserDTO dto = (UserDTO) returnObj;
			if(dto.getRole().equals("일반")) {
				System.out.println("일반인로그인");
			}
		}
		
		System.out.println("사전처리 "+method + "정보 "+returnObj.toString());
	}
}
