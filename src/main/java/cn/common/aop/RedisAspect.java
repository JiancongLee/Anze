//package cn.common.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Redis 切面处理类
// *
// * @author jianconglee
// */
//@Aspect
//@Configuration
//public class RedisAspect {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    //是否开启redis缓存  true开启   false关闭
//    @Value("${spring.redis.open: false}")
//    private boolean open;
//
//    // todo 这里需要改改
////    @Around("execution(* com.bingo.common.utils.RedisUtils.*(..))")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        Object result = null;
//        if(open){
//            try{
//                result = point.proceed();
//            }catch (Exception e){
//                logger.error("redis error", e);
////                throw new DefaultException("Redis服务异常");
//            }
//        }
//        return result;
//    }
//}
