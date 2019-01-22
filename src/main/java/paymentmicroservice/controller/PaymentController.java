package paymentmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import paymentmicroservice.entity.Summary;
import paymentmicroservice.service.DebitCardService;
import paymentmicroservice.service.NetbankingService;
import paymentmicroservice.service.PaymentOptionService;
import paymentmicroservice.service.SummaryService;

import java.util.List;
import java.util.Map;

@RestController
public class PaymentController  {
     Summary paymentInfo;

    @Autowired
    PaymentOptionService paymentOptionService;
    @Autowired
    DebitCardService debitCardService;
    @Autowired
    NetbankingService netbankingService;
    @Autowired
    SummaryService summaryService;

    @RequestMapping(method = RequestMethod.POST,value = "/checkout")
    public void checkOutPost(@RequestBody Map<String,Object>mp) throws CustomException
    {
       paymentInfo = new Summary();
       paymentOptionService.getCartInfo(paymentInfo,mp);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/payment/init")
    public List<String> paymentInit() throws CustomException
    {
        return paymentOptionService.getPaymentOption(paymentInfo);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/payment/init")
    public String paymentInitPost(@RequestBody Map<String,String>mp)throws CustomException{
        return paymentOptionService.getOption(paymentInfo,mp);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/payment/debitcard")
    public  List<String> debitCardList() { return debitCardService.cardList(); }

   @RequestMapping(method = RequestMethod.POST,value = "/payment/debitcard")
    public  String getCardDetails(@RequestBody Map<String,String> mp ) {
        return  debitCardService.isDebitCardValid(mp);
    }



    @RequestMapping(method = RequestMethod.GET,value = "/payment/netbanking")
    public List<String> netbankingListGet()
    {
        return netbankingService.getBanks();
    }


    @RequestMapping(method = RequestMethod.POST,value = "/payment/pay")
    public Summary finalPayPost(@RequestBody Map<String,String>mp) throws CustomException
    {
        summaryService.getInfo(paymentInfo,mp);
        return paymentInfo;
    }





}
