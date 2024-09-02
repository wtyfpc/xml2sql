package com.acx.xmltosql.model;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "tempalte")
public class XmlTemplate {
    private String name;
    private byte visiable;
    private String description;
    private String introduce;
    private String lastModify;
    private String creator;
    private Metrics metrics;

    private Long hashcode;


    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // TODO: 2024/8/19  是否要加入visiable字段
    @XmlElement(name = "visiable")
    public byte getVisiable(){return visiable;}
    public void setVisiable(byte visiable) {
        this.visiable = visiable;
    }



    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "introduce")
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @XmlElement(name = "last_modify")
    public String getLastModify() {
        return lastModify;
    }

    public void setLastModify(String lastModify) {
        this.lastModify = lastModify;
    }

    @XmlElement(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @XmlElement(name = "metrics")
    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    public Long getHashcode(){
        return hashcode;
    }

    public void setHashcode(Long hashcode){
        this.hashcode = hashcode;
    }

}
