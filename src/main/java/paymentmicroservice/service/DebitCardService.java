package paymentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentmicroservice.entity.DebitCard;
import paymentmicroservice.repository.DebitCardRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class DebitCardService {

    @Autowired
    DebitCardRepo debitCardRepo;
    @Autowired
    DebitCardValidator debitCardValidator;
    public List<String> cardList()
    {
       return debitCardRepo.getCardTypes();
    }

    public  String isDebitCardValid(Map<String,String> mp )
    {
        String cardNo = mp.get("cardNo");
        String date = mp.get("date");
        String cvv = mp.get("cvv");
        if(debitCardValidator.isValid(cardNo,date,cvv))
            return "Details are Correct";
        else
            return "Please enter Valid Details";
    }
}
