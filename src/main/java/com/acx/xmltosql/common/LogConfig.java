package com.acx.xmltosql.common;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {

    @Autowired
    private final InputArgs inputArgs;

    private final String logPath;

    LogConfig(InputArgs inputArgs){
        this.inputArgs = inputArgs;
        this.logPath = inputArgs.getLogPath();
    }
    @Bean
    public void configureLogback() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        // Console Appender
        ConsoleAppender<ILoggingEvent> consoleAppender = new ConsoleAppender<>();
        consoleAppender.setContext(context);
        PatternLayoutEncoder consoleEncoder = new PatternLayoutEncoder();
        consoleEncoder.setContext(context);
        consoleEncoder.setPattern("%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n");
        consoleEncoder.start();
        consoleAppender.setEncoder(consoleEncoder);
        consoleAppender.start();

        // Rolling File Appender
        RollingFileAppender<ILoggingEvent> fileAppender = new RollingFileAppender<>();
        fileAppender.setContext(context);
        fileAppender.setFile(logPath + "/application.log");

        // Rolling policy
        TimeBasedRollingPolicy<ILoggingEvent> rollingPolicy = new TimeBasedRollingPolicy<>();
        rollingPolicy.setContext(context);
        rollingPolicy.setFileNamePattern(logPath + "/application.%d{yyyy-MM-dd}.log");
        rollingPolicy.setMaxHistory(30);  // Keep 30 days of logs
        rollingPolicy.setParent(fileAppender);
        rollingPolicy.start();

        // File encoder
        PatternLayoutEncoder fileEncoder = new PatternLayoutEncoder();
        fileEncoder.setContext(context);
        fileEncoder.setPattern("%d{yyyy-MM-dd HH:mm:ss} %-5level %logger{36} - %msg%n");
        fileEncoder.start();

        fileAppender.setEncoder(fileEncoder);
        fileAppender.setRollingPolicy(rollingPolicy);
        fileAppender.start();

        // Attach only file appender to root logger
        ch.qos.logback.classic.Logger rootLogger = context.getLogger("ROOT");
        rootLogger.addAppender(fileAppender);  // 仅添加文件输出
        rootLogger.setLevel(ch.qos.logback.classic.Level.INFO);

        // Print the internal state of the logger context
        StatusPrinter.print(context);
    }
}
