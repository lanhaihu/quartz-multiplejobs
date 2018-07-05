package com.boot.quartz.multiplejobs.job;

import java.util.List;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import com.boot.quartz.multiplejobs.importorder.service.IImportOrderService;
import com.boot.quartz.multiplejobs.bean.dr_estimate_costs;
@Service
public class ExampleJob1 extends QuartzJobBean {

    @Autowired
    private IImportOrderService importOrderService;

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("EXECUTE JOB 1");
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
        importOrderService.updateByIds(8,2);
    }
}
