package com.boot.quartz.multiplejobs.job;

import com.boot.quartz.multiplejobs.importorder.service.ImportOrderService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
@Service
public class ImportOrderJob extends QuartzJobBean {

    //@Autowired
    //private IImportOrderService importOrderService;

    @Autowired
    private ImportOrderService importOrderService;

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
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

        importOrderService.startImportCargoList("cargo");
        importOrderService.startImportCargoList("delivery");
    }
}
