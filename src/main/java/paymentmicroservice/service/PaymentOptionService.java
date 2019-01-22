package paymentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentmicroservice.controller.CustomException;
import paymentmicroservice.entity.Summary;
import paymentmicroservice.repository.PaymentOptionRepo;

import java.util.*;

@Service
public class  PaymentOptionService {
    @Autowired
    PaymentOptionRepo paymentOptionRepo;

    @Autowired
    SummaryService summaryService;
    List<String> paymentOptionAvailable;

    List<String> itemsCategory ;
    public  List<String> getPaymentOption(Summary paymentInfo) throws CustomException
    {
        try {
            paymentOptionAvailable = paymentOptionRepo.getOptions();
        }
        catch (Exception e)
        {
            throw new CustomException("Something Went Wrong");
        }
        if(paymentInfo.getAmount()<3000 && paymentOptionAvailable.contains("EMI"))
        {
            paymentOptionAvailable.remove("EMI");
        }
        if((paymentInfo.getAmount()>80000||itemsCategory.contains("Kitchen"))&&paymentOptionAvailable.contains("COD"))
        {
            paymentOptionAvailable.remove("COD");
        }
        return paymentOptionAvailable;
    }

    public String getOption(Summary paymentInfo, Map<String,String> mp) throws CustomException
    {
        String paymentOptionOpt;
        try
        {
            paymentOptionOpt = mp.get("paymentOptionOpt");
           if(!paymentOptionAvailable.contains(paymentOptionOpt))
                throw new CustomException("Please select option from the given options");
            paymentInfo.setModOfPayment(paymentOptionOpt);
        }
        catch (Exception e)
        {
           throw  new CustomException(""+e);
        }
        return  paymentOptionOpt;
    }

    public void getCartInfo(Summary paymentInfo,Map<String,Object>mp) throws CustomException
    {
        try {
             if(summaryService.IsOrderPresent((String)mp.get("orderId")))
                 throw  new CustomException("Payment has already Initiated for this OrderId");
             paymentInfo.setorderId((String)mp.get("orderId"));
             float amount = Float.parseFloat((String)  mp.get("amount"));
             if(amount<0)
                 throw new CustomException("Amount Can't be less than Zero");
             paymentInfo.setAmount(amount);
             itemsCategory=(List<String>) mp.get("items");
        }
        catch (Exception e)
        {
            throw new CustomException(""+e);

        }
    }
}
