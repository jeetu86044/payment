package paymentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentmicroservice.entity.Netbanking;
import paymentmicroservice.repository.NetbankingRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class NetbankingService {

    @Autowired
    NetbankingRepo netbankingRepo;
    public List<String> getBanks()
    {
        return netbankingRepo.getAllBankS();
    }
}
