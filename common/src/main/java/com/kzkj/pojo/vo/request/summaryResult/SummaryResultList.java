package com.kzkj.pojo.vo.request.summaryResult;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识  
@XmlRootElement(name="SummaryResultList")
//控制JAXB 绑定类中属性和字段的排序  
@XmlType(propOrder = {   
		  "invtNo",
		 "logisticsNo",
		 "gnum",
		 "gcode",
})
@Data
public class SummaryResultList
{
	private String invtNo;
	private String logisticsNo;
	private String gnum;
	private String gcode;
}
