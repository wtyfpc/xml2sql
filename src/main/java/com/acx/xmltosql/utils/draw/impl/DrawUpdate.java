package com.acx.xmltosql.utils.draw.impl;

import com.acx.xmltosql.model.XmlTemplate;
import com.acx.xmltosql.utils.draw.IDrawMethod;

import com.acx.xmltosql.utils.method.update.impi.MetricGenerator;
import com.acx.xmltosql.utils.method.update.impi.MetricRelationGenerator;
import com.acx.xmltosql.utils.method.update.impi.MetricTemplGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@ComponentScan(basePackages = "com.acx.xmltosql.utils.method.update.impl")
public class DrawUpdate implements IDrawMethod {


    @Autowired
    MetricTemplGenerator metricTemplGenerator;
    @Autowired
    MetricRelationGenerator metricRelationGenerator;
    @Autowired
    MetricGenerator metricGenerator;

    @Override
    public void draw(List<XmlTemplate> xmlObject) {
        // Create a ThreadPoolExecutor with core pool size 3, maximum pool size 5, and a LinkedBlockingQueue with capacity 100
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,  // core pool size
                5,  // maximum pool size
                60, // idle time before terminating idle threads
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100) // queue with capacity of 100
        );

        try {
            // Submit tasks to the thread pool
            threadPoolExecutor.submit(() -> metricTemplGenerator.exec(xmlObject));
            threadPoolExecutor.submit(() -> metricGenerator.exec(xmlObject));
            threadPoolExecutor.submit(() -> metricRelationGenerator.exec(xmlObject));

            // Optionally, wait for all tasks to finish (this is blocking)
            threadPoolExecutor.shutdown();  // Prevents new tasks from being submitted
            threadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);  // Wait for the termination of all tasks
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interrupt status
            e.printStackTrace();
        }
    }

}
