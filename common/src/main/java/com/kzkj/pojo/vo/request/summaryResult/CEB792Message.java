package com.kzkj.pojo.vo.request.summaryResult;

import com.kzkj.pojo.vo.request.base.BaseTransfer;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)  
//XML文件中的根标识  
@XmlRootElement(name="CEB792Message",namespace="http://www.chinaport.gov.cn/ceb")
//控制JAXB 绑定类中属性和字段的排序  
@XmlType(propOrder = {   
     "SummaryResult",
		"BaseTransfer",
})
@Data
public class CEB792Message implements Serializable{

	private static final long serialVersionUID = 2549245859588443092L;


	@XmlAttribute
    private String guid;
	
	@XmlAttribute
    private String version;
	
	@XmlElement
	private List<com.kzkj.pojo.vo.request.summaryResult.SummaryResult> SummaryResult;

	private com.kzkj.pojo.vo.request.base.BaseTransfer BaseTransfer;

}
