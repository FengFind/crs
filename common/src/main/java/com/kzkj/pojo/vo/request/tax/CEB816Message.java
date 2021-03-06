package com.kzkj.pojo.vo.request.tax;

import com.kzkj.pojo.vo.request.base.BaseTransfer;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * 发送总署入库明细申请对象
 * <br>（功能详细描述）
 */

@XmlAccessorType(XmlAccessType.FIELD)  
//XML文件中的根标识  
@XmlRootElement(name="CEB816Message")  
//控制JAXB 绑定类中属性和字段的排序  
@XmlType(propOrder = {   
   "Tax",   
   "BaseTransfer",   
}) 
@Data
public class CEB816Message implements Serializable {

	private static final long serialVersionUID = -603833056546962633L;

	@XmlAttribute
    private String guid;
	
	@XmlAttribute
    private String version = "1.0";
	
	private List<com.kzkj.pojo.vo.request.tax.Tax> Tax;
	
	private BaseTransfer BaseTransfer;
}
