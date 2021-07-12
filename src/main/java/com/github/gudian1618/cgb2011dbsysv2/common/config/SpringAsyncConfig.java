package com.github.gudian1618.cgb2011dbsysv2.common.config;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/7/5 3:03 下午
 */

@Slf4j
@Configuration
@ConfigurationProperties("spring.async.task")
@Setter
public class SpringAsyncConfig implements AsyncConfigurer {

    private int corePoolSize = 5;
    private int maxPoolSize = 100;
    private int keepAliveSeconds = 60;
    private int queueCapacity = 128;
    private String threadNamePrefix = "task==>";

    @Override
    public Executor getAsyncExecutor() {
        System.out.println("corePoolSize = " + corePoolSize);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        // 自定义拒绝处理策略
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                log.error("队列已满并且已无线程可用");
            }
        });
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
                log.error("任务执行时出现了{}", throwable.getMessage());
            }
        };
    }
}
