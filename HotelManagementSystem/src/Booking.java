
public class Booking {
 String RoomType,RoomNo,MaximumOccupant,TariffPerNight,RoomFeatures,RoomDescription,
 BookingStartDate,NumberOfNight,BookingEndDate,SpecialInstruction,TotalTariff;
    
 
 public Booking(){}
    public Booking(String RoomType, String RoomNo, String MaximumOccupant, String TariffPerNight, String RoomFeatures, String RoomDescription, String BookingStartDate, String NumberOfNight, String BookingEndDate, String SpecialInstruction, String TotalTariff) {
        this.RoomType = RoomType;
        this.RoomNo = RoomNo;
        this.MaximumOccupant = MaximumOccupant;
        this.TariffPerNight = TariffPerNight;
        this.RoomFeatures = RoomFeatures;
        this.RoomDescription = RoomDescription;
        this.BookingStartDate = BookingStartDate;
        this.NumberOfNight = NumberOfNight;
        this.BookingEndDate = BookingEndDate;
        this.SpecialInstruction = SpecialInstruction;
        this.TotalTariff = TotalTariff;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String RoomNo) {
        this.RoomNo = RoomNo;
    }

    public String getMaximumOccupant() {
        return MaximumOccupant;
    }

    public void setMaximumOccupant(String MaximumOccupant) {
        this.MaximumOccupant = MaximumOccupant;
    }

    public String getTariffPerNight() {
        return TariffPerNight;
    }

    public void setTariffPerNight(String TariffPerNight) {
        this.TariffPerNight = TariffPerNight;
    }

    public String getRoomFeatures() {
        return RoomFeatures;
    }

    public void setRoomFeatures(String RoomFeatures) {
        this.RoomFeatures = RoomFeatures;
    }

    public String getRoomDescription() {
        return RoomDescription;
    }

    public void setRoomDescription(String RoomDescription) {
        this.RoomDescription = RoomDescription;
    }

    public String getBookingStartDate() {
        return BookingStartDate;
    }

    public void setBookingStartDate(String BookingStartDate) {
        this.BookingStartDate = BookingStartDate;
    }

    public String getNumberOfNight() {
        return NumberOfNight;
    }

    public void setNumberOfNight(String NumberOfNight) {
        this.NumberOfNight = NumberOfNight;
    }

    public String getBookingEndDate() {
        return BookingEndDate;
    }

    public void setBookingEndDate(String BookingEndDate) {
        this.BookingEndDate = BookingEndDate;
    }

    public String getSpecialInstruction() {
        return SpecialInstruction;
    }

    public void setSpecialInstruction(String SpecialInstruction) {
        this.SpecialInstruction = SpecialInstruction;
    }

    public String getTotalTariff() {
        return TotalTariff;
    }

    public void setTotalTariff(String TotalTariff) {
        this.TotalTariff = TotalTariff;
    }

    @Override
    public String toString() {
        return "Booking{" + "RoomType=" + RoomType + ", RoomNo=" + RoomNo + ", MaximumOccupant=" + MaximumOccupant + ", TariffPerNight=" + TariffPerNight + ", RoomFeatures=" + RoomFeatures + ", RoomDescription=" + RoomDescription + ", BookingStartDate=" + BookingStartDate + ", NumberOfNight=" + NumberOfNight + ", BookingEndDate=" + BookingEndDate + ", SpecialInstruction=" + SpecialInstruction + ", TotalTariff=" + TotalTariff + '}';
    }
 
}
