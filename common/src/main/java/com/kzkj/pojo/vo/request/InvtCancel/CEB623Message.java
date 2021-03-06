package com.kzkj.pojo.vo.request.InvtCancel;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * 发送总署撤销申请单请求对象
 * <br>（功能详细描述）
 */

@XmlAccessorType(XmlAccessType.FIELD)  
//XML文件中的根标识  
@XmlRootElement(name="CEB623Message")  
//控制JAXB 绑定类中属性和字段的排序  
@XmlType(propOrder = {   
   "InvtCancel",   
   "BaseTransfer",   
}) 
@Data
public class CEB623Message implements Serializable{

	private static final long serialVersionUID = 7469941165737634894L;

	@XmlAttribute
    private String guid;
	
	@XmlAttribute
    private String version = "1.0";
	
	private List<ImportInvtCancel> InvtCancel;
	
	private com.kzkj.pojo.vo.request.base.BaseTransfer BaseTransfer;

}
