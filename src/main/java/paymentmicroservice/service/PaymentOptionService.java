package paymentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
import paymentmicroservice.controller.PaymentController;
import paymentmicroservice.entity.PaymentOption;
import paymentmicroservice.entity.Summary;
import paymentmicroservice.repository.PaymentOptionRepo;

import java.util.*;

@Service
public class PaymentOptionService {
    @Autowired
    PaymentOptionRepo paymentOptionRepo;

    public List<PaymentOption> paymentInit()
    {
        Iterator iterator = paymentOptionRepo.findAll().iterator();
        List<PaymentOption> paymentOptionList = new ArrayList<>();
        while(iterator.hasNext())
        {
            paymentOptionList.add((PaymentOption) iterator.next());
        }
        return  paymentOptionList;
    }

    public String getOption(Summary paymentInfo, Map<String,String> mp)
    {
        String url ;
        String paymentOptionOpt;
        try{
            paymentOptionOpt = mp.get("paymentOptionOpt");
            paymentInfo.setModOfPayment(paymentOptionOpt);
            if(paymentOptionOpt.equalsIgnoreCase("NetBanking"))
                url ="/payment/netbanking";
            else if(paymentOptionOpt.equalsIgnoreCase("Debit Card"))
                url = "/payment/debitcard";
            else
                url  = "/payment/pay";
        }
        catch (Exception e)
        {
            url = "/errors";
        }

        return  url;
    }

    public String getCartInfo(Summary paymentInfo,Map<String,String>mp)
    {
        String url;
        try {
             paymentInfo.setCartId(Integer.parseInt(mp.get("cartid")));
             paymentInfo.setAmount(Float.parseFloat(mp.get("amount")));
            url="/payment/init";
        }
        catch (Exception e)
        {
            url="/errors";
        }
        return url;
    }
}
