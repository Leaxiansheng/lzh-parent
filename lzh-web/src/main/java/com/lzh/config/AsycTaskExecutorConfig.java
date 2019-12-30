package com.lzh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 线程池配置、启用异步
 *
 */
//开启异步
@EnableAsync(proxyTargetClass = true)
@Configuration
public class AsycTaskExecutorConfig {

}
