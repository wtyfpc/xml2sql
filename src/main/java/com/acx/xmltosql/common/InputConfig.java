package com.acx.xmltosql.common;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import com.beust.jcommander.JCommander;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import ch.qos.logback.core.util.StatusPrinter;


@Configuration
public class InputConfig {
    @Bean
    public InputArgs parseCommandLineArgs(ApplicationArguments applicationArguments) {
        String[] args = applicationArguments.getSourceArgs();
        InputArgs cmdArgs = new InputArgs();
        JCommander.newBuilder()
                .addObject(cmdArgs)
                .build()
                .parse(args);
        return cmdArgs;
    }



}
