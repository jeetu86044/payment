package paymentmicroservice.service;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.hibernate.cfg.FkSecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentmicroservice.entity.PaymentOption;
import paymentmicroservice.entity.Summary;
import paymentmicroservice.repository.PaymentOptionRepo;

import java.util.*;

@Service
public class PaymentOptionService {
    @Autowired
    PaymentOptionRepo paymentOptionRepo;

    public List<String> getPaymentOption()
    {
        return paymentOptionRepo.getOptions();
    }

    public String getOption(Summary paymentInfo, Map<String,String> mp)
    {
        String paymentOptionOpt="Something Wrong";

        try{
            paymentOptionOpt = mp.get("paymentOptionOpt");
            paymentInfo.setModOfPayment(paymentOptionOpt);


        }
        catch (Exception e)
        {
           return paymentOptionOpt;
        }

        return  paymentOptionOpt;
    }

    public Object getCartInfo(Summary paymentInfo,Map<String,Object>mp)
    {
        String url;

        try {
             paymentInfo.setorderId((String)mp.get("orderId"));
             paymentInfo.setAmount(Float.parseFloat((String)  mp.get("amount")));
             List<String> list=(List<String>) mp.get("items");
             return list.get(1);
        }
        catch (Exception e)
        {
           return e;
        }
      // return "fghj";
    }
}
