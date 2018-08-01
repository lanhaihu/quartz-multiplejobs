package com.boot.quartz.multiplejobs.job;

import com.boot.quartz.multiplejobs.importorder.service.ImportOrderService;
import com.boot.util.ConstantInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImportOrderJob extends QuartzJobBean {

    //@Autowired
    //private IImportOrderService importOrderService;

    @Autowired
    private ImportOrderService importOrderService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException  {
        /*System.out.println("EXECUTE JOB 1");
        String url = ConstantInfoUtil.getPassWord();
        System.out.println(url);
        List<dr_estimate_costs> empList=importOrderService.queryEmpAll();
        for(dr_estimate_costs emp : empList) {
            System.out.println(emp.getCosts_estimate_id());
            System.out.println(emp.getReckon_unit_id());
        }

        List<dr_estimate_costs> empList2=importOrderService.queryEmpById(5);
        for(dr_estimate_costs emp : empList2) {
            System.out.println(emp.getCosts_estimate_id());
            System.out.println(emp.getReckon_unit_id());
        }
        importOrderService.updateByIds(8,2);*/
        if(ConstantInfoUtil.importOrderRunningFlg.get()){
            log.info("订单导入定时任务正在执行，本次跳过");
            return ;
        }
        ConstantInfoUtil.importOrderRunningFlg.weakCompareAndSet(false,true);
        try{
            importOrderService.startImportCargoList("cargo");
            importOrderService.startImportCargoList("delivery");
            //当任务执行完后，将执行状态从true，改为false
            ConstantInfoUtil.importOrderRunningFlg.weakCompareAndSet(true,false);
        }catch (Throwable e){
            log.error("导入接口定时器执行异常",e);
            //任务执行异常时，修正执行状态,importOrderRunningFlg设置的主要目的为了防止其他定时任务依赖于
            //此任务执行结束后，方可执行
            ConstantInfoUtil.importOrderRunningFlg.weakCompareAndSet(true,false);
        }finally {

        }
    }
}
