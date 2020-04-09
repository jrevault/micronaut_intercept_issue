package fr.quidquid.micronaut.intercept_issue;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.Date;

@Singleton
public class Interceptor implements MethodInterceptor<Object, Object> {

    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

    @Inject
    public Interceptor(ApplicationContext context) {
        this.context = context;
    }

    private ApplicationContext context;

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> method_context) {

        logger.warn("I'm interceptor at " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.sss").format(new Date()));

        return method_context.proceed();
    }


}
