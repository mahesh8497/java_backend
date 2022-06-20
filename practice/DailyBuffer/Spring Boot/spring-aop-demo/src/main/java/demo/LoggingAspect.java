package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

   @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforelogger(JoinPoint jp) {
       //  System.out.println(jp.getSignature());
       String arg = jp.getArgs()[0].toString();
        System.out.println("Before Logger with Argument: "+arg);
    }
    @After("execution(* *.*.checkout(..))")
    public void afterLogger(){
        System.out.println("After Logger");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity())")
    public void afterReturningPointCut(){

    }
    @AfterReturning(pointcut = "afterReturningPointCut()",returning ="retValue" )
    public void afterReturning(String retValue){
        System.out.println("After Returning:"+ retValue);

    }
}
