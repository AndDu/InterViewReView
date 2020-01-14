package org.videolan.aop;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import androidx.fragment.app.Fragment;

@Aspect
public class LoginAspect {

    public static final String TAG = "LoginAspect";

    @Pointcut("execution(@org.videolan.aop.LoginState * *(..))")
    public void requestLoginState() {
    }


    @Around("requestLoginState()")
    public void aroundJointPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        Context context = null;

        final Object object = joinPoint.getThis();//得到添加注解的那个类对象
        if (joinPoint.getThis() instanceof Context) {
            context = (Context) object;
        } else if (joinPoint.getThis() instanceof Fragment) {
            context = ((Fragment) object).getActivity();
        } else if (joinPoint.getThis() instanceof android.app.Fragment) {
            context = ((android.app.Fragment) object).getActivity();
        } else {
            //如果在其他跟
        }

        if (context == null) {
            Log.e(TAG, "------------- error -----------------");
            return;
        }

        if (LoginManager.isLogin) {
            joinPoint.proceed();
        } else {
            Log.e(TAG, "------------- please login --------------");
        }

    }

}
