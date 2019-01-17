package paymentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentmicroservice.controller.PaymentController;
import paymentmicroservice.entity.Summary;
import paymentmicroservice.repository.SummaryRepo;

import java.util.Map;

@Service
public class SummaryService {

    @Autowired
    SummaryRepo summaryRepo;
    public boolean save(Summary summary)
    {
        try {
            summaryRepo.save(summary);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public String getInfo(Summary paymentInfo, Map<String,String>mp)
    {
        String url;
        try {
            paymentInfo.setSuccess(mp.get("paymentStatus").equalsIgnoreCase("Success"));
            summaryRepo.save(paymentInfo);
            return url="/home";
        }
        catch (Exception e)
        {
            return url = "/errors";
        }
    }
}
