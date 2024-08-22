package com.acx.xmltosql.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Configuration
public class InitConfig {

    @Value("${sql.gv_collection_metric_templ.file.path}")
    private  Path outputPath;

    @PostConstruct
    public void createPathIfNotExists() throws IOException {
        // 检查并创建父目录
        Path parentDirectory = outputPath.getParent();
        if (parentDirectory != null && Files.notExists(parentDirectory)) {
            Files.createDirectories(parentDirectory);  // 创建父目录
        }

    }

}
