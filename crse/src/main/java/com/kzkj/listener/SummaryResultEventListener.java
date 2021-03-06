package com.kzkj.listener;

import com.google.common.eventbus.Subscribe;
import com.kzkj.pojo.vo.request.base.BaseTransfer;
import com.kzkj.pojo.vo.request.summaryResult.CEB792Message;
import com.kzkj.pojo.vo.request.summaryResult.SummaryResult;
import com.kzkj.pojo.vo.response.summaryResult.CEB702Message;
import com.kzkj.pojo.vo.response.summaryResult.SummaryReturn;
import com.kzkj.utils.XMLUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SummaryResultEventListener extends BaseListener{
    @Subscribe
    public void listener(CEB792Message event){
        CEB702Message ceb702Message=new CEB702Message();
        List<SummaryReturn> summaryReturnsList =new ArrayList<>();
        BaseTransfer baseTransfer=event.getBaseTransfer();

        for(SummaryResult summaryResult:event.getSummaryResult())
        {
            SummaryReturn summaryReturn =new SummaryReturn();
            summaryReturn.setGuid(summaryResult.getSummaryResultHead().getGuid());
            summaryReturn.setEbcCode(summaryResult.getSummaryResultHead().getEbcCode());
            summaryReturn.setAgentCode(summaryResult.getSummaryResultHead().getAgentCode());
            summaryReturn.setCopNo("");
            summaryReturn.setPreNo("");
            summaryReturn.setSumNo(summaryResult.getSummaryResultHead().getSumNo());


            String now = sdf.format(new Date());
            summaryReturn.setReturnTime(now);

            //数据查重
            boolean flag=true;
            if(flag)
            {
                summaryReturn.setReturnInfo("新增申报成功["+summaryResult.getSummaryResultHead().getGuid()+"]");
                summaryReturn.setReturnStatus("2");
            }else {
                summaryReturn.setReturnInfo("处理失败，业务主键重复入库失败，报文业务主键["
                        + summaryResult.getSummaryResultHead().getEbcCode()
                        + "]，原汇总结果单报送时间对应状态为["
                        + now + " : 2-申报;]");
                summaryReturn.setReturnStatus("-304001");
            }

            summaryReturnsList.add(summaryReturn);
        }

        ceb702Message.setSummaryReturn(summaryReturnsList);
        ceb702Message.setGuid(summaryReturnsList.get(0).getGuid());
        String xml= XMLUtil.convertToXml(ceb702Message);
        String resultXml=customData(xml, baseTransfer.getDxpId(), "CEB702Message");
        String queue=baseTransfer.getDxpId()+"_HZ";
        mqSender.sendMsg(queue, resultXml,"CEB702Message");
    }
}
