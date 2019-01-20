package paymentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentmicroservice.entity.DebitCard;
import paymentmicroservice.repository.DebitCardRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DebitCardService {

    @Autowired
    DebitCardRepo debitCardRepo;
    public List<String> cardList()
    {
       return debitCardRepo.getCardTypes();
    }
}
