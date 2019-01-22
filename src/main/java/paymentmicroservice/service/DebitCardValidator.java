package paymentmicroservice.service;

import org.springframework.stereotype.Service;

@Service
public class DebitCardValidator {

    public boolean isValid(String cardNo,String date,String cvv)
    {
       if(isCardNoVld(cardNo)&&isDateVld(date)&&isCvvVld(cvv))
           return true;
       else
           return false;
    }
    public boolean isCardNoVld(String cardNo)
    {
        int oddSum=0;
        int even = 0;
        if(cardNo.length()!=16)
            return false;
        for(int i=15;i>=0;i--)
        {
            if(i%2==1)
                oddSum+=cardNo.charAt(i)-'0';
            else
            {
                int temp = (cardNo.charAt(i)-'0')*2;
                even += temp/10+temp%10;
            }
        }
        if((even+oddSum)%10==0)
            return true;
        else
            return false;
    }
    public boolean isDateVld(String date)
    {

        return true;
    }
    public  boolean isCvvVld(String  cvv)
    {
        if(cvv.length()!=3&&cvv.length()!=4)
            return false;
        for(int i=0;i<3;i++)
        {
            if(!(cvv.charAt(i)>='0'&&cvv.charAt(i)<='9'))
                return false;
        }
        return  true;
    }

}
