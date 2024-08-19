package com.acx.xmltosql.model;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class Metrics {
    private List<ResMetric> resmetrics;

    @XmlElement(name = "resmetric")
    public List<ResMetric> getResmetrics() {
        return resmetrics;
    }

    public void setResmetrics(List<ResMetric> resmetrics) {
        this.resmetrics = resmetrics;
    }
}
