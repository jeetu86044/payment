package paymentmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import paymentmicroservice.entity.DebitCard;
import paymentmicroservice.entity.Netbanking;
import paymentmicroservice.entity.PaymentOption;
import paymentmicroservice.entity.Summary;
import paymentmicroservice.service.DebitCardService;
import paymentmicroservice.service.NetbankingService;
import paymentmicroservice.service.PaymentOptionService;
import paymentmicroservice.service.SummaryService;

import java.util.List;
import java.util.Map;

@RestController
public class PaymentController {
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
    public Object checkOutPost(@RequestBody Map<String,Object>mp)
    {
       paymentInfo = new Summary();
      return paymentOptionService.getCartInfo(paymentInfo,mp);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/payment/init")
    public List<String> paymentInit(){
        return paymentOptionService.getPaymentOption();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/payment/init")
    public String paymentInitPost(@RequestParam Map<String,String>mp){
        return paymentOptionService.getOption(paymentInfo,mp);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/payment/debitcard")
    public  List<String> debitCardList() { return debitCardService.cardList(); }




    @RequestMapping(method = RequestMethod.GET,value = "/payment/netbanking")
    public List<String> netbankingListGet()
    {
        return netbankingService.getBanks();
    }


    @RequestMapping(method = RequestMethod.POST,value = "/payment/pay")
    public Summary finalPayPost(@RequestParam Map<String,String>mp)
    {
        summaryService.getInfo(paymentInfo,mp);
        return paymentInfo;
    }

    @RequestMapping("/errors")
    public String errors()
    {
        return "Something went wrong";
    }




}
