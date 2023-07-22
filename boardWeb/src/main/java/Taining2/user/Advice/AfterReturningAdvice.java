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
			if(dto.getRole().equals("�Ϲ�")) {
				System.out.println("�Ϲ��ηα���");
			}
		}
		
		System.out.println("����ó�� "+method + "���� "+returnObj.toString());
	}
}
