package challenge.aspectj.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* Calculator.*(..))")
    private void selectAllMethods() {}

    @Before("selectAllMethods()")
    public void beforeAdvice(JoinPoint jp) {
        System.out.println("Método chamado: " + jp.getSignature().getName() + " com argumentos: " + java.util.Arrays.toString(jp.getArgs()));
    }

    @After("selectAllMethods()")
    public void afterAdvice(JoinPoint jp) {
        System.out.println("Método executado: " + jp.getSignature().getName());
    }

    @AfterReturning(pointcut = "selectAllMethods()", returning = "resultado")
    public void afterReturningAdvice(JoinPoint jp, Object result) {
        System.out.println("Método retornado: " + result);
    }

    @AfterThrowing(pointcut = "selectAllMethods()", throwing = "error")
    public void afterThrowingAdvice(JoinPoint jp, Throwable error) {
        System.out.println("O método gerou uma exceção: " + error);
    }
}

