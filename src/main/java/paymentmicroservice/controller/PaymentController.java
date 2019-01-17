package paymentmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
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

    @RequestMapping(method = RequestMethod.GET,value = "/checkout")
    public ModelAndView checkOutGet()
    {
        ModelAndView modelview = new ModelAndView("checkout.html");
        return  modelview;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/checkout")
    public RedirectView checkOutPost(@RequestParam Map<String,String>mp)
    {
       paymentInfo = new Summary();
       return new RedirectView(paymentOptionService.getCartInfo(paymentInfo,mp));
    }


    @RequestMapping(method = RequestMethod.GET,value = "/payment/init")
    public ModelAndView paymentInit(){
        ModelAndView modelAndView = new ModelAndView("paymentOptions.html");
        modelAndView.addObject("options", paymentOptionService.paymentInit());
        return  modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/payment/init")
    public RedirectView paymentInitPost(@RequestParam Map<String,String>mp){
        return new RedirectView(paymentOptionService.getOption(paymentInfo,mp));
    }

    @RequestMapping(method = RequestMethod.GET,value = "/payment/debitcard")
    public  ModelAndView debitCardList()
    {
        ModelAndView modelAndView =new ModelAndView("cardTypes.html");
        modelAndView.addObject("cardTypes",debitCardService.cardList());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/payment/debitcard")
    public RedirectView debitCardListPost()
    {
        return new RedirectView("/payment/pay");
    }



    @RequestMapping(method = RequestMethod.GET,value = "/payment/netbanking")
    public ModelAndView netbankingListGet()
    {
        ModelAndView modelAndView =new ModelAndView("bankAvailable.html");
        modelAndView.addObject("options",netbankingService.getBanks());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/payment/netbanking")
    public RedirectView netbankingListPost()
    {
        return new RedirectView("/payment/pay");
    }


    @RequestMapping(method = RequestMethod.GET,value = "/payment/pay")
    public ModelAndView finalPayGet() { return new ModelAndView("finalPay"); }


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
