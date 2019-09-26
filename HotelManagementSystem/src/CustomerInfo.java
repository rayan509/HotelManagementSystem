
public class CustomerInfo {
  String FirstName,LastName,DOB,Sex,UnitNo,StreetNo,StreetName,Suburb,State,ZIP,Country,
  HomePhone,WorkPhone,Mobile,Email;
  public CustomerInfo(){}
    public CustomerInfo(String FirstName, String LastName, String DOB, String Sex, String UnitNo, String StreetNo, String StreetName, String Suburb, String State, String ZIP, String Country, String HomePhone, String WorkPhone, String Mobile, String Email) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DOB = DOB;
        this.Sex = Sex;
        this.UnitNo = UnitNo;
        this.StreetNo = StreetNo;
        this.StreetName = StreetName;
        this.Suburb = Suburb;
        this.State = State;
        this.ZIP = ZIP;
        this.Country = Country;
        this.HomePhone = HomePhone;
        this.WorkPhone = WorkPhone;
        this.Mobile = Mobile;
        this.Email = Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getUnitNo() {
        return UnitNo;
    }

    public void setUnitNo(String UnitNo) {
        this.UnitNo = UnitNo;
    }

    public String getStreetNo() {
        return StreetNo;
    }

    public void setStreetNo(String StreetNo) {
        this.StreetNo = StreetNo;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String StreetName) {
        this.StreetName = StreetName;
    }

    public String getSuburb() {
        return Suburb;
    }

    public void setSuburb(String Suburb) {
        this.Suburb = Suburb;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }

    public String getWorkPhone() {
        return WorkPhone;
    }

    public void setWorkPhone(String WorkPhone) {
        this.WorkPhone = WorkPhone;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" + "FirstName=" + FirstName + ", LastName=" + LastName + ", DOB=" + DOB + ", Sex=" + Sex + ", UnitNo=" + UnitNo + ", StreetNo=" + StreetNo + ", StreetName=" + StreetName + ", Suburb=" + Suburb + ", State=" + State + ", ZIP=" + ZIP + ", Country=" + Country + ", HomePhone=" + HomePhone + ", WorkPhone=" + WorkPhone + ", Mobile=" + Mobile + ", Email=" + Email + '}';
    }
  
}
