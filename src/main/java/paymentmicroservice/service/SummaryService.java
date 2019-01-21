package paymentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentmicroservice.controller.CustomException;
import paymentmicroservice.entity.Summary;
import paymentmicroservice.repository.SummaryRepo;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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
    public void getInfo(Summary paymentInfo, Map<String,String>mp) throws CustomException
    {
        try {
            Random random = new Random();
            String str = String.valueOf(random.nextInt());
            paymentInfo.setTransactionId(String.valueOf(random.nextInt((100000000 - 10000000) + 1) + 100000));
            paymentInfo.setSuccess(mp.get("paymentStatus").equalsIgnoreCase("Success"));
            paymentInfo.setDate(new Date());
            Optional op;
            op=summaryRepo.findById(paymentInfo.getorderId());
            if(op.isPresent())
            {
                throw new CustomException("Invalid Order details");
            }
            summaryRepo.save(paymentInfo);

        }
        catch (Exception e)
        {
            throw new CustomException("Something Went Wrong");
        }
    }
}
