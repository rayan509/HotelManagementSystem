
public class Payment {
   String NameOfCadholder,CreditCardNo,ExpiryMonth,CCV,ExpiryYear;
    public Payment(){}
    public Payment(String NameOfCadholder, String CreditCardNo, String ExpiryMonth,String ExpiryYear, String CCV) {
        this.NameOfCadholder = NameOfCadholder;
        this.CreditCardNo = CreditCardNo;
        this.ExpiryMonth = ExpiryMonth;
        this.CCV = CCV;
    }

    public String getNameOfCadholder() {
        return NameOfCadholder;
    }

    public void setNameOfCadholder(String NameOfCadholder) {
        this.NameOfCadholder = NameOfCadholder;
    }

    public String getCreditCardNo() {
        return CreditCardNo;
    }

    public void setCreditCardNo(String CreditCardNo) {
        this.CreditCardNo = CreditCardNo;
    }

    public String getExpiryMonth() {
        return ExpiryMonth;
    }

    public void setExpiryMonth(String ExpiryDate) {
        this.ExpiryMonth = ExpiryMonth;
    }

    public String getExpiryYear() {
        return ExpiryYear;
    }

    public void setExpiryYear(String ExpiryYear) {
        this.ExpiryYear = ExpiryYear;
    }
    
    public String getCCV() {
        return CCV;
    }

    public void setCCV(String CCV) {
        this.CCV = CCV;
    }

    @Override
    public String toString() {
        return "Payment{" + "NameOfCadholder=" + NameOfCadholder + ", CreditCardNo=" + CreditCardNo + ", ExpiryMonth=" + ExpiryMonth + ", CCV=" + CCV + ", ExpiryYear=" + ExpiryYear + '}';
    }

   
   
}
