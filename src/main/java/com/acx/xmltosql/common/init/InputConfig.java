package com.acx.xmltosql.common.init;

import com.beust.jcommander.JCommander;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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
