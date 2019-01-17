package paymentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentmicroservice.entity.DebitCard;
import paymentmicroservice.entity.PaymentOption;
import paymentmicroservice.repository.DebitCardRepo;

import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DebitCardService {

    @Autowired
    DebitCardRepo debitCardRepo;
    public List<DebitCard> cardList()
    {
        Iterator iterator = debitCardRepo.findAll().iterator();
        List<DebitCard>  debitCardList= new ArrayList<>();
        while(iterator.hasNext())
        {
            debitCardList.add((DebitCard) iterator.next());
        }
        return  debitCardList;
    }
}
