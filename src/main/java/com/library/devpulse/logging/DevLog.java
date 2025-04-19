package com.library.devpulse.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevLog {
    private  final Logger logger;
    private final String tag;

    private DevLog(Class<?> clazz, String tag) {
        this.tag = tag;
        this.logger = LoggerFactory.getLogger(clazz);
    }

    //태크와 클래스를 지정하여 DevLog 객체 생성
    public static DevLog tag(Class<?> clazz, String tag) {
        return new DevLog(clazz, tag);
    }

    //info 로그 출력
    public void info(String message, Object... args) {
        logger.info("[{}] " + message, tag, args);
    }

    //debug 로그 출력
    public void debug(String message, Object... args) {
        logger.debug("[{}] " + message, tag, args);
    }

    //warn 로그 출력
    public void warn(String message, Object... args) {
        logger.warn("[{}] " + message, tag, args);
    }

    //error 로그 출력
    public void error(String message, Object... args) {
        logger.error("[{}] " + message, tag, args);
    }

    //trace 로그 출력
    public void trace(String message, Object... args) {
        logger.trace("[{}] " + message, tag, args);
    }


}
