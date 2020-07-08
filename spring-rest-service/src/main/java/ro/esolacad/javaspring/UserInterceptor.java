package ro.esolacad.javaspring;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor extends HandlerInterceptorAdapter {

    private final static ThreadLocal<String> userContext = new ThreadLocal<>();

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response, final Object handler) throws Exception {
        System.out.println("PREHANDLE!");

        userContext.set(request.getHeader("username"));
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
                                final Object handler, final Exception ex) throws Exception {
        System.out.println("AFterCOMPLETION");
        userContext.remove();
    }

    public static String getUsername() {
        return userContext.get();
    }
}
