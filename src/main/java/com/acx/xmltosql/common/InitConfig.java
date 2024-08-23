package com.acx.xmltosql.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Configuration
public class InitConfig {

    @Value("${sql.gv_collection_metric_templ.file.path}")
    private Path outputPath;

    @PostConstruct
    public void createPathIfNotExists() throws IOException {
        // 检查并创建父目录
        Path parentDirectory = outputPath.getParent();
        if (parentDirectory != null && Files.notExists(parentDirectory)) {
            Files.createDirectories(parentDirectory);  // 创建父目录
        }


        // 复制 resource 下的 gv_collect_template_metric_relation.sql 文件到 parentDirectory
        try (InputStream resourceStream = getClass().getClassLoader()
                .getResourceAsStream("sql/gv_collect_new.sql")) {

            if (resourceStream == null) {
                throw new IOException("Resource gv_collect_new.sql not found");
            }

            // 设置目标路径为父目录下的目标文件
            Path targetPath = parentDirectory.resolve("gv_collect_new.sql");

            // 复制文件到目标路径
            Files.copy(resourceStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
