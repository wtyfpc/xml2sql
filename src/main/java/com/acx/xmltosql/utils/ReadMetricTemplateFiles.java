package com.acx.xmltosql.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author qinfei
 * @class ReadMetricTemplateFiles
 * @date 2024-11-29 18:53
 **/
public class ReadMetricTemplateFiles {
    // 默认的目标文件夹路径，可以修改
    private static final String DESTINATION_FOLDER = "D:/metric_template";

    public static void main(String[] args) {
        // 指定要搜索的起始路径
        String sourcePath = "D:\\Document\\collector\\acx-collector\\acx-collector-app\\src\\main\\resources\\metrics"; // 替换为实际的起始路径

        // 创建目标文件夹（如果不存在）
        File destinationDir = new File(DESTINATION_FOLDER);
        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        // 调用递归方法
        searchAndCopyFiles(new File(sourcePath));
    }

    // 递归搜索和复制文件的方法
    private static void searchAndCopyFiles(File dir) {
        // 获取当前目录下的所有文件和文件夹
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 如果是文件夹，递归调用
                    searchAndCopyFiles(file);
                } else if (file.isFile() && file.getName().matches(".*metric_template\\.xml")) {
                    // 如果是文件且匹配模式，则复制文件
                    copyFile(file, DESTINATION_FOLDER);
                }
            }
        }
    }

    // 复制文件的方法
    private static void copyFile(File sourceFile, String destinationFolder) {
        File destinationFile = new File(destinationFolder, sourceFile.getName());

        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("Copied: " + sourceFile.getAbsolutePath() + " to " + destinationFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
