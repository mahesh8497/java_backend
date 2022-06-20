package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {
    @Pointcut("within(demo..*)")
    public void AuthenticationPointcut() {

    }

    @Pointcut("within(demo.ShoppingCart.*)")
    public void AuthorizationPointcuts() {
    }
    @Before("AuthenticationPointcut() && AuthorizationPointcuts()")
    public void authenticate() {
        System.out.println("authenticate the request");
    }

}
