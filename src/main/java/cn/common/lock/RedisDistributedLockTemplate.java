//package cn.common.lock;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.JedisPool;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author sunyujia@aliyun.com https://github.com/yujiasun/Distributed-Kit
// * @date 2016/2/26
// */
//@Component
//public class RedisDistributedLockTemplate implements DistributedLockTemplate {
//
//    protected Logger logger = LoggerFactory.getLogger(getClass());
//    @Autowired
//    private JedisPool jedisPool;
//
//    @Override
//    public Object execute(String lockId, Integer timeout, Callback callback) {
//
//        RedisReentrantLock distributedReentrantLock = null;
//        boolean getLock=false;
//        try {
//            distributedReentrantLock = new RedisReentrantLock(jedisPool,lockId);
//            if(distributedReentrantLock.tryLock(new Long(timeout), TimeUnit.MILLISECONDS)){
//                getLock=true;
//                return callback.onGetLock();
//            }else{
//                return callback.onTimeout();
//            }
//        }catch(InterruptedException ex){
//            logger.error(ex.getMessage(), ex);
//            Thread.currentThread().interrupt();
//        }catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }finally {
//            if(getLock) {
//                distributedReentrantLock.unlock();
//            }
//        }
//        return null;
//    }
//}
