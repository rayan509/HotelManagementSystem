
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.control.ComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;








/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ITCI
 */
public class NewBookingForm extends javax.swing.JFrame {
  Booking booking;
  CustomerInfo customerInfo;
  Payment payment;
  LoginDB loginDB;
  Connection conn;
  
  
    public NewBookingForm() {
        initComponents();
        ConfirmBookingButton.setEnabled(false);
         loginDB=new LoginDB("hotelmanagementsystemdb","root","");
         conn=loginDB.getConnection();
         
         
         
       
    }
    public void ResetAll(){
    RoomTypeComboBox.setSelectedIndex(0);
    RoomNoComboBox.setSelectedIndex(0);
    MaximumOccupantField.setText("");
    TariffPerNightField.setText("");
    RoomFeatures.setText("");
    RoomDescription.setText("");
    NumberOfNight.setValue(new Integer(0));
    BookingEndDate.setText("");
    SpecialInstruction.setText("");
    FirstNameField.setText("");
    LastNameField.setText("");
    DayComboBox.setSelectedIndex(-1);
    MonthComboBox.setSelectedIndex(-1);
    YearsComboBox.setSelectedIndex(-1);
    MaleRadioButton.setSelected(true);
    FemaleRadioButton.setSelected(false);
    UnitNoField.setText("");
    StreetNoField.setText("");
    StreetNameField.setText("");
    SuburbField.setText("");
    StateComboBox.setSelectedIndex(-1);
    ZIPTextField.setText("");
    CountryTextField.setText("");
    HomePhoneField.setText("");
    WorkPhoneField.setText("");
    MobileField.setText(null);
    EmailField.setText("");
    CashRadioButton.setSelected(true);
    CreditCardRadioButton.setSelected(false);
    NameOfCadholderField.setText("");
    CreditCardNoField.setText("");
    ExpiryDateYearsCompobox.setSelectedIndex(-1);
    ExpiryDateMonthCompobox.setSelectedIndex(-1);
    CVVField.setText("");
    TotalTariff.setText("");
    BookingStartDateField.setText("");
    BookingEndDate.setText("");
    checkAvalibility.setText("");
    }
    private boolean validationBooking(){
        if(RoomTypeComboBox.getSelectedIndex()==-1){
    JOptionPane.showMessageDialog(this,"Pleas chooes Room type", "Room type missing",JOptionPane.ERROR_MESSAGE);
    RoomTypeComboBox.requestFocus();
    return false;
    }
     else if(RoomNoComboBox.getSelectedItem()=="Choose Room Number"){
    JOptionPane.showMessageDialog(this,"Pleas chooes Room number", "Room number missing",JOptionPane.ERROR_MESSAGE);
    RoomNoComboBox.requestFocus();
    return false;
    }else
      if(BookingStartDateField.getText().equals("")){
    JOptionPane.showMessageDialog(this,"Pleas Enter Start Date", "StartDate missing",JOptionPane.ERROR_MESSAGE);
    BookingStartDateField.requestFocus();
    return false;
    }else if((int)NumberOfNight.getValue()<=0){
    JOptionPane.showMessageDialog(this,"Pleas chooes Number of night", "number of night missing",JOptionPane.ERROR_MESSAGE);
    NumberOfNight.requestFocus();
    return false;
    }else if(BookingEndDate.getText().equals("")){
    JOptionPane.showMessageDialog(this,"Pleas Enter End Date", "End Date missing",JOptionPane.ERROR_MESSAGE);
    BookingEndDate.requestFocus();
    return false;
    }else
         return true;
    }
    
    
    private boolean validationInputForm(){
    if(RoomTypeComboBox.getSelectedIndex()==-1){
    JOptionPane.showMessageDialog(this,"Pleas chooes Room type", "Room type missing",JOptionPane.ERROR_MESSAGE);
    RoomTypeComboBox.requestFocus();
    return false;
    }
     else if(RoomNoComboBox.getSelectedIndex()==-1){
    JOptionPane.showMessageDialog(this,"Pleas chooes Room number", "Room number missing",JOptionPane.ERROR_MESSAGE);
    RoomNoComboBox.requestFocus();
    return false;
    }
     else if((int)NumberOfNight.getValue()<=0){
    JOptionPane.showMessageDialog(this,"Pleas chooes Number of night", "number of night missing",JOptionPane.ERROR_MESSAGE);
    NumberOfNight.requestFocus();
    return false;
    }
      else if(BookingEndDate.getText()=="" && !BookingEndDate.getText().matches("[0-9]+") ){
    JOptionPane.showMessageDialog(this,"Pleas Enter Booking End date", "Booking End date missing",JOptionPane.ERROR_MESSAGE);
    BookingEndDate.requestFocus();
    return false;
    }
       else if(FirstNameField.getText()==""){
    JOptionPane.showMessageDialog(this,"Pleas Enter First Name", "First Name missing",JOptionPane.ERROR_MESSAGE);
    FirstNameField.requestFocus();
    return false;
    }
      else if(LastNameField.getText()==""){
    JOptionPane.showMessageDialog(this,"Pleas Enter Last Name", "Last Name missing",JOptionPane.ERROR_MESSAGE);
    LastNameField.requestFocus();
    return false;
    }
      else if(DayComboBox.getSelectedIndex()==-1||MonthComboBox.getSelectedIndex()==-1 || YearsComboBox.getSelectedIndex()==-1){
    JOptionPane.showMessageDialog(this,"Pleas Enter Date Of Birth", "Date Of Birth missing",JOptionPane.ERROR_MESSAGE);
    DayComboBox.requestFocus();
    return false;
    }
    else if(!MaleRadioButton.isSelected() && !FemaleRadioButton.isSelected()){
    JOptionPane.showMessageDialog(this,"Pleas Enter sex", "sex missing",JOptionPane.ERROR_MESSAGE);
    MaleRadioButton.requestFocus();
    return false;
    }
    else if(UnitNoField.getText()=="" || StreetNoField.getText()==""||StreetNameField.getText()==""||SuburbField.getText()==""||StateComboBox.getSelectedIndex()==-1 || ZIPTextField.getText()=="" ||CountryTextField.getText()==""){
    JOptionPane.showMessageDialog(this,"Pleas Enter Full Address", "Full Address missing",JOptionPane.ERROR_MESSAGE);
    UnitNoField.requestFocus();
    return false;
    }
    else if(HomePhoneField.getText()=="" || WorkPhoneField.getText()=="" ||MobileField.getText()==""|| EmailField.getText()==""){
    JOptionPane.showMessageDialog(this,"Pleas Enter Full Contuct details", "Full Contuct details missing",JOptionPane.ERROR_MESSAGE);
    UnitNoField.requestFocus();
    return false;
    }
    else if(CreditCardRadioButton.isSelected()){
        if(NameOfCadholderField.getText()=="" || CreditCardNoField.getText()=="" ||(int) ExpiryDateYearsCompobox.getSelectedItem()<=0 || (int)ExpiryDateMonthCompobox.getSelectedItem()<=0 || CVVField.getText()==""){
    JOptionPane.showMessageDialog(this,"Pleas Enter Full Card details", "Full Card details missing",JOptionPane.ERROR_MESSAGE);
    NameOfCadholderField.requestFocus();
    return false;
        }
    }
    return true;
    }
    private void loadBookingObject(){
    booking = new Booking();
    booking.setRoomType(RoomTypeComboBox.getSelectedItem().toString());
    booking.setRoomNo(RoomNoComboBox.getSelectedItem().toString());
    booking.setMaximumOccupant(MaximumOccupantField.getText());
    booking.setTariffPerNight(TariffPerNightField.getText());
    booking.setRoomFeatures(RoomFeatures.getText());
    booking.setRoomDescription(RoomDescription.getText());
    booking.setBookingStartDate(BookingStartDateField.getText());
    booking.setNumberOfNight(NumberOfNight.getValue().toString());
    booking.setBookingEndDate(BookingEndDate.getText());
    booking.setSpecialInstruction(SpecialInstruction.getText());
    booking.setTotalTariff(TotalTariff.getText());
    }
    private void loadCustomerInfoObject(){
     customerInfo = new CustomerInfo();
     customerInfo.setFirstName(FirstNameField.getText());
     customerInfo.setLastName(LastNameField.getText());
     customerInfo.setDOB(YearsComboBox.getSelectedItem()+"-"+MonthComboBox.getSelectedItem()+"-"+DayComboBox.getSelectedItem());
     customerInfo.setUnitNo(UnitNoField.getText());
     customerInfo.setStreetNo(StreetNoField.getText());
     customerInfo.setStreetName(StreetNameField.getText());
     customerInfo.setSuburb(SuburbField.getText());
     customerInfo.setState(StateComboBox.getSelectedItem().toString());
     customerInfo.setZIP(ZIPTextField.getText());
     customerInfo.setCountry(CountryTextField.getText());
     customerInfo.setHomePhone(HomePhoneField.getText());
     customerInfo.setWorkPhone(WorkPhoneField.getText());
     customerInfo.setMobile(MobileField.getText());
     customerInfo.setEmail(EmailField.getText());
     if(MaleRadioButton.isSelected())
     customerInfo.setSex("Male");
     else
     customerInfo.setSex("Female");    
    }
    private void loadPaymentObject(){
    payment = new Payment();
    payment.setNameOfCadholder(NameOfCadholderField.getText());
    payment.setCreditCardNo(CreditCardNoField.getText());
    payment.setExpiryYear(ExpiryDateYearsCompobox.getSelectedItem().toString());
    payment.setExpiryMonth(ExpiryDateMonthCompobox.getSelectedItem().toString());
    payment.setCCV(CVVField.getText());
    }
    
        public void InsetIntoBookingTransactiontable(){
         
        
          if(validationInputForm()){
            loadBookingObject();
           loadCustomerInfoObject();
          loadPaymentObject();
          
          Calendar cal = Calendar.getInstance();
        String bookingDate=cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH);
      if(conn!=null){
       String sql1="INSERT INTO bookingtransactiontable VALUES ('"+"HMS"+booking.RoomNo+BookingStartDateField.getText()+"','"+
        booking.getRoomNo()+"','"+
        bookingDate+"','"+
        booking.getBookingStartDate()+"','"+
        booking.getNumberOfNight()+"','"+
        booking.getBookingEndDate()+"','"+
        booking.getTotalTariff()+"','"+
        booking.getSpecialInstruction()+"')";
        boolean result1=loginDB.insertUpdateData(conn, sql1);
        if(result1){
        JOptionPane.showMessageDialog(this,"Insert into database has been done","Done",JOptionPane.INFORMATION_MESSAGE);
        }else
              JOptionPane.showMessageDialog(this,"Error Connecton","Error",JOptionPane.ERROR_MESSAGE);
      }
          }
      }
        
        public void InsertIntoCustomerinfo(){
      
        Calendar cal = Calendar.getInstance();
        String bookingDate=cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH);
        
        if(validationInputForm()){
            loadBookingObject();
        loadCustomerInfoObject();
         loadPaymentObject();
        if(conn!=null){
       String sql2="INSERT INTO customerinfo VALUES ('"+"HMS"+booking.RoomNo+BookingStartDateField.getText()+"','"+
       customerInfo.getFirstName()+"','"+
       customerInfo.getLastName()+"','"+
       customerInfo.getSex()+"','"+
       customerInfo.getDOB()+"','"+
       customerInfo.getUnitNo()+"','"+
       customerInfo.getStreetNo()+"','"+
       customerInfo.getStreetName()+"','"+
       customerInfo.getSuburb()+"','"+
       customerInfo.getState()+"','"+
       customerInfo.getZIP()+"','"+
       customerInfo.getCountry()+"','"+
       customerInfo.getHomePhone()+"','"+
       customerInfo.getWorkPhone()+"','"+
       customerInfo.getMobile()+"','"+
       customerInfo.getEmail()+"')";
       boolean result=loginDB.insertUpdateData(conn, sql2);
       if(result){
       JOptionPane.showMessageDialog(this,"Insert into database has been done","Done",JOptionPane.INFORMATION_MESSAGE);
       }else
           JOptionPane.showMessageDialog(this,"Error Connecton","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
        }
      
      
      
      public void InsertIntoPaymentdetails(){
              String Expirmonth="";
        if(ExpiryDateMonthCompobox.getSelectedIndex()==0){Expirmonth="1";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==1){Expirmonth="2";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==2){Expirmonth="3";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==3){Expirmonth="4";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==4){Expirmonth="5";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==5){Expirmonth="6";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==6){Expirmonth="7";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==7){Expirmonth="8";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==8){Expirmonth="9";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==9){Expirmonth="10";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==10){Expirmonth="11";}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==11){Expirmonth="12";}
           String paymentMethod;
        if(CashRadioButton.isSelected()){
           paymentMethod="Cash";
        }else
            paymentMethod="Credit Card";
       if(validationInputForm()){
            loadBookingObject();
           loadCustomerInfoObject();
          loadPaymentObject();
      if(conn!=null){
       String sql3="INSERT INTO paymentdetails VALUES ('"+"HMS"+booking.RoomNo+BookingStartDateField.getText()+"','"+
       paymentMethod+"','"+
       payment.getNameOfCadholder()+"','"+
       payment.getCreditCardNo()+"','"+
       Expirmonth+"','"+
       payment.getExpiryYear()+"','"+
       payment.getCCV()+"')";
        boolean result3=loginDB.insertUpdateData(conn, sql3);
        if(result3){
        JOptionPane.showMessageDialog(this,"Insert into database has been done","Done",JOptionPane.INFORMATION_MESSAGE);
        }
       } else
           JOptionPane.showMessageDialog(this,"Error Connecton","Error",JOptionPane.ERROR_MESSAGE);
      }
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MaximumOccupantField = new javax.swing.JTextField();
        RoomNoComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        RoomTypeComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        TariffPerNightField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RoomFeatures = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        RoomDescription = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NumberOfNight = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        BookingEndDate = new javax.swing.JTextField();
        CheckAvalibalitiy = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        SpecialInstruction = new javax.swing.JTextArea();
        checkAvalibility = new javax.swing.JLabel();
        BookingStartDateField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TotalTariff = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        DayComboBox = new javax.swing.JComboBox();
        MonthComboBox = new javax.swing.JComboBox();
        YearsComboBox = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        MaleRadioButton = new javax.swing.JRadioButton();
        FemaleRadioButton = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        UnitNoField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        StreetNoField = new javax.swing.JTextField();
        StreetNameField = new javax.swing.JTextField();
        SuburbField = new javax.swing.JTextField();
        StateComboBox = new javax.swing.JComboBox();
        ZIPTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        CountryTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        HomePhoneField = new javax.swing.JTextField();
        WorkPhoneField = new javax.swing.JTextField();
        MobileField = new javax.swing.JTextField();
        EmailField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        CashRadioButton = new javax.swing.JRadioButton();
        CreditCardRadioButton = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        NameOfCadholderField = new javax.swing.JTextField();
        CreditCardNoField = new javax.swing.JTextField();
        CVVField = new javax.swing.JTextField();
        VerifyButton = new javax.swing.JButton();
        VerifyField = new javax.swing.JLabel();
        ExpiryDateMonthCompobox = new javax.swing.JComboBox();
        ExpiryDateYearsCompobox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        ConfirmBookingButton = new javax.swing.JButton();
        ResetAllButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Tariff Per Night");

        jLabel3.setText("maximum occupant");

        RoomNoComboBox.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                RoomNoComboBoxComponentAdded(evt);
            }
        });
        RoomNoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RoomNoComboBoxItemStateChanged(evt);
            }
        });
        RoomNoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomNoComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Room No.");

        RoomTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose Room Type", "Single", "Double", "Deluxe Double", "Family Room", "Superior Family Room", "Suite", "Presedential Suite" }));
        RoomTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RoomTypeComboBoxItemStateChanged(evt);
            }
        });
        RoomTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomTypeComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Room Type");

        jLabel5.setText("Room Features");

        RoomFeatures.setColumns(20);
        RoomFeatures.setRows(5);
        jScrollPane1.setViewportView(RoomFeatures);

        jLabel6.setText("Room Description");

        RoomDescription.setColumns(20);
        RoomDescription.setRows(5);
        jScrollPane2.setViewportView(RoomDescription);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MaximumOccupantField)
                                    .addComponent(TariffPerNightField, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                .addGap(183, 183, 183))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(63, 63, 63)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RoomTypeComboBox, 0, 190, Short.MAX_VALUE)
                                    .addComponent(RoomNoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RoomTypeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RoomNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(MaximumOccupantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TariffPerNightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Booking Start Date");

        jLabel8.setText("Number of Night");

        NumberOfNight.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                NumberOfNightAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        NumberOfNight.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                NumberOfNightStateChanged(evt);
            }
        });
        NumberOfNight.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                NumberOfNightInputMethodTextChanged(evt);
            }
        });

        jLabel9.setText("Special instruction");

        jLabel10.setText("Booking End Date");

        BookingEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingEndDateActionPerformed(evt);
            }
        });

        CheckAvalibalitiy.setText("Check Avalibalitiy");
        CheckAvalibalitiy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckAvalibalitiyActionPerformed(evt);
            }
        });

        SpecialInstruction.setColumns(20);
        SpecialInstruction.setRows(5);
        jScrollPane3.setViewportView(SpecialInstruction);

        checkAvalibility.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BookingStartDateField))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(NumberOfNight, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BookingEndDate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckAvalibalitiy))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkAvalibility, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(BookingStartDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(NumberOfNight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(BookingEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckAvalibalitiy)
                    .addComponent(checkAvalibility, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel9)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Total Tariff");

        TotalTariff.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(TotalTariff, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(TotalTariff, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Booking", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Personal Detailse"));

        jLabel13.setText("First Name");

        jLabel14.setText("Last Name");

        jLabel15.setText("DOB");

        DayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        DayComboBox.setSelectedIndex(-1);

        MonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        MonthComboBox.setSelectedIndex(-1);

        YearsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", " " }));
        YearsComboBox.setSelectedIndex(-1);

        jLabel16.setText("Sex");

        buttonGroup2.add(MaleRadioButton);
        MaleRadioButton.setText("Male");

        buttonGroup2.add(FemaleRadioButton);
        FemaleRadioButton.setText("Female");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FirstNameField))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastNameField)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(DayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(YearsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MaleRadioButton)
                            .addComponent(FemaleRadioButton))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(122, 122, 122))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(DayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YearsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(MaleRadioButton)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel16)
                        .addGap(9, 9, 9)
                        .addComponent(FemaleRadioButton)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Address"));

        jLabel17.setText("Unit No.");

        jLabel18.setText("Street Name");

        jLabel19.setText("Suburb");

        jLabel20.setText("State");

        jLabel21.setText("ZIP");

        jLabel22.setText("Street No.");

        StateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NSW", "VIC", "ACT" }));
        StateComboBox.setSelectedIndex(-1);

        jLabel23.setText("Country");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StreetNameField)
                            .addComponent(SuburbField)
                            .addComponent(StateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(ZIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CountryTextField))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(26, 26, 26)
                        .addComponent(UnitNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(StreetNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(UnitNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(StreetNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(StreetNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(SuburbField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(StateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ZIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(CountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contact Detailes"));

        jLabel24.setText("Home Phone");

        jLabel25.setText("Work Phone");

        jLabel26.setText("Mobile");

        jLabel27.setText("Email");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HomePhoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(WorkPhoneField)
                            .addComponent(MobileField)
                            .addComponent(EmailField))))
                .addGap(10, 10, 10))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(HomePhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(WorkPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(MobileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer Info", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Payment Method"));

        buttonGroup1.add(CashRadioButton);
        CashRadioButton.setText("Cash");
        CashRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(CreditCardRadioButton);
        CreditCardRadioButton.setText("Credit Card");
        CreditCardRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditCardRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreditCardRadioButton)
                    .addComponent(CashRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(CashRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreditCardRadioButton)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Card details"));

        jLabel28.setText("Name of Cadholder");

        jLabel29.setText("Credit Card No.");

        jLabel30.setText("Expiry Date");

        jLabel31.setText("CCV");

        NameOfCadholderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameOfCadholderFieldActionPerformed(evt);
            }
        });

        VerifyButton.setText("verify");
        VerifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerifyButtonActionPerformed(evt);
            }
        });

        VerifyField.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ExpiryDateMonthCompobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January\t", "February", "March\t", "April\t", "May\t", "June\t", "July\t", "August\t", "September\t", "October\t", "November\t", "December" }));

        ExpiryDateYearsCompobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", " " }));

        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(CreditCardNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(ExpiryDateMonthCompobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ExpiryDateYearsCompobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CVVField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VerifyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VerifyField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NameOfCadholderField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(NameOfCadholderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(CreditCardNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(ExpiryDateMonthCompobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExpiryDateYearsCompobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VerifyField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(VerifyButton)
                                .addComponent(CVVField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ConfirmBookingButton.setForeground(new java.awt.Color(0, 0, 153));
        ConfirmBookingButton.setText("Confirm Booking");
        ConfirmBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmBookingButtonActionPerformed(evt);
            }
        });

        ResetAllButton.setText("Reset All");
        ResetAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetAllButtonActionPerformed(evt);
            }
        });

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ConfirmBookingButton, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(CloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResetAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(ConfirmBookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ResetAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(327, 327, 327))
        );

        jTabbedPane1.addTab("Payment", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckAvalibalitiyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckAvalibalitiyActionPerformed
        if(validationBooking()){
        if(conn!=null){
       String sql1="SELECT * FROM roomtypemaster WHERE roomType = '"+RoomTypeComboBox.getSelectedItem().toString()+"' AND roomNumber= '"+RoomNoComboBox.getSelectedItem().toString()+"'";
       String sql2="SELECT * FROM bookingtransactiontable WHERE roomNumber = '"+RoomNoComboBox.getSelectedItem().toString()+"'";
       ResultSet rs1=loginDB.getResultSet(conn, sql1);
       ResultSet rs2=loginDB.getResultSet(conn, sql2);
       try{
       while(rs1.next()){
       
       MaximumOccupantField.setText(rs1.getString(4));
       TariffPerNightField.setText(rs1.getString(5));
       RoomFeatures.setText(rs1.getString(3));
       RoomDescription.setText(rs1.getString(6));
       TotalTariff.setText(""+Integer.parseInt(TariffPerNightField.getText().toString())*Integer.parseInt(NumberOfNight.getValue().toString()));
       }
        if(rs2.wasNull()){
         checkAvalibility.setText("Aviliable");
         ConfirmBookingButton.setEnabled(true);
        }
        while(rs2.next()){
       String startdateY = rs2.getString(4).substring(0,4);
       int bookingDateY=Integer.parseInt(startdateY);
       String startdateM = rs2.getString(4).substring(5,7);
       int bookingDateM=Integer.parseInt(startdateM);
       String startdateD = rs2.getString(4).substring(8,10);
       int bookingDateD=Integer.parseInt(startdateD);
       
       String endDateY=rs2.getString(6).substring(0,4);
       int bookingEndDateY=Integer.parseInt(endDateY);
       String endDateM=rs2.getString(6).substring(5,7);
       int bookingEndDateM=Integer.parseInt(endDateM);
       String endDateD=rs2.getString(6).substring(8,10);
       int bookingEndDateD=Integer.parseInt(endDateD);
       
       String startDateYF=BookingStartDateField.getText().substring(0,4);
       int bookingDateYF=Integer.parseInt(startDateYF);
       String startDateMF=BookingStartDateField.getText().substring(5,7);
       int bookingDateMF=Integer.parseInt(startDateMF);
       String startDateDF=BookingStartDateField.getText().substring(8,10);
       int bookingDateDF=Integer.parseInt(startDateDF);
       
       String endDateYF=BookingEndDate.getText().substring(0,4);
       int bookingEndDateYF=Integer.parseInt(startDateYF);
       String endDateMF=BookingEndDate.getText().substring(5,7);
       int bookingEndDateMF=Integer.parseInt(startDateMF);
       String endDateDF=BookingEndDate.getText().substring(8,10);
       int bookingEndDateDF=Integer.parseInt(startDateDF);
       
       if(bookingDateYF==bookingDateY){
       if(bookingDateMF==bookingDateM){
       if(bookingDateDF==bookingDateD || bookingEndDateDF<bookingEndDateD||bookingDateDF<=bookingEndDateD){
       checkAvalibility.setText("Unaviliable");
       ConfirmBookingButton.setEnabled(false);
       }else{
       checkAvalibility.setText("Aviliable");
       ConfirmBookingButton.setEnabled(true);
       }
       }else
       checkAvalibility.setText("Aviliable");
       ConfirmBookingButton.setEnabled(true);
       }else
       checkAvalibility.setText("Aviliable");
       ConfirmBookingButton.setEnabled(true);
      
      
        }
        
       }catch(SQLException e){
       
       }
       } else
           JOptionPane.showMessageDialog(this,"Error Connecton","Error",JOptionPane.ERROR_MESSAGE);
    
        }    
    }//GEN-LAST:event_CheckAvalibalitiyActionPerformed

    private void ResetAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetAllButtonActionPerformed
        ResetAll();
    }//GEN-LAST:event_ResetAllButtonActionPerformed


  
    private void VerifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerifyButtonActionPerformed
        int month=0;
        if(ExpiryDateMonthCompobox.getSelectedIndex()==0){month=1;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==1){month=2;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==2){month=3;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==3){month=4;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==4){month=5;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==5){month=6;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==6){month=7;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==7){month=8;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==8){month=9;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==9){month=10;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==10){month=11;}
        if(ExpiryDateMonthCompobox.getSelectedIndex()==11){month=12;}
       
       
        
        Calendar cal = Calendar.getInstance();
        int monthNow=cal.get(Calendar.MONTH);
        CVVField.setText(""+monthNow);
        String msg=CreditCardNoField.getText().trim();
        if(msg.length()<16||msg.length()>16){
        jLabel12.setText("must be 16 degit");
        VerifyField.setText("Invalid");
        ConfirmBookingButton.setEnabled(false);
        }else if(month<monthNow){
            VerifyField.setText("Invalid"); 
            jLabel12.setText("");
        } else{
           VerifyField.setText("Valid");
           jLabel12.setText("");
        }
    }//GEN-LAST:event_VerifyButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void RoomTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomTypeComboBoxActionPerformed
          
    }//GEN-LAST:event_RoomTypeComboBoxActionPerformed

    private void NameOfCadholderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameOfCadholderFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameOfCadholderFieldActionPerformed

    private void CashRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashRadioButtonActionPerformed
             if(CashRadioButton.isSelected()){
        NameOfCadholderField.setEnabled(false);
        CreditCardNoField.setEnabled(false);
        CVVField.setEnabled(false);
        VerifyButton.setEnabled(false);
        }
             
                 
    }//GEN-LAST:event_CashRadioButtonActionPerformed

    private void CreditCardRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditCardRadioButtonActionPerformed
       if(CreditCardRadioButton.isSelected()){
        NameOfCadholderField.setEnabled(true);
        CreditCardNoField.setEnabled(true);
        CVVField.setEnabled(true);
        VerifyButton.setEnabled(true);
             }
    }//GEN-LAST:event_CreditCardRadioButtonActionPerformed

    private void RoomNoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomNoComboBoxActionPerformed
      
    }//GEN-LAST:event_RoomNoComboBoxActionPerformed

    private void RoomTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RoomTypeComboBoxItemStateChanged
       
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<String> roomNo = new ArrayList<String>();
        model.addElement("Choose Room Number");
        if(conn!=null){
       String sql1="SELECT roomNumber FROM roomtypemaster WHERE roomType = '"+RoomTypeComboBox.getSelectedItem().toString()+"'";
       ResultSet rs1=loginDB.getResultSet(conn, sql1);
    
      
       try{
           
       while(rs1.next()){
       roomNo.add(rs1.getString(1));
       }
       for(int i =0;i<roomNo.size();i++){
           model.addElement(roomNo.get(i));
           //RoomNoComboBox.addItem(roomNo.get(i));
       }
       roomNo.clear();
       RoomNoComboBox.setModel(model);
      
       }catch(SQLException ex){
           
       }}        
     
    }//GEN-LAST:event_RoomTypeComboBoxItemStateChanged

    private void NumberOfNightAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_NumberOfNightAncestorAdded
       
    }//GEN-LAST:event_NumberOfNightAncestorAdded

    private void BookingEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingEndDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookingEndDateActionPerformed
     
  
         
    
    private void ConfirmBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmBookingButtonActionPerformed
         InsetIntoBookingTransactiontable();
         InsertIntoCustomerinfo();
         InsertIntoPaymentdetails();
    }//GEN-LAST:event_ConfirmBookingButtonActionPerformed

    private void RoomNoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RoomNoComboBoxItemStateChanged
         
        if(conn!=null){
       String sql1="SELECT * FROM roomtypemaster WHERE roomNumber = '"+RoomNoComboBox.getSelectedItem().toString()+"'";
       ResultSet rs1=loginDB.getResultSet(conn, sql1);
      ArrayList<String> roomNo = new ArrayList<String>();
       try{
           
       while(rs1.next()){
       RoomFeatures.setText(rs1.getString(3));
       MaximumOccupantField.setText(rs1.getString(4));
       TariffPerNightField.setText(rs1.getString(5));
       RoomDescription.setText(rs1.getString(6));
       }
       }catch(SQLException ex){
       }
                      }
    }//GEN-LAST:event_RoomNoComboBoxItemStateChanged

    private void RoomNoComboBoxComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_RoomNoComboBoxComponentAdded
   
    }//GEN-LAST:event_RoomNoComboBoxComponentAdded

    private void NumberOfNightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_NumberOfNightStateChanged
       
    }//GEN-LAST:event_NumberOfNightStateChanged

    private void NumberOfNightInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_NumberOfNightInputMethodTextChanged
       
    }//GEN-LAST:event_NumberOfNightInputMethodTextChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewBookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewBookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewBookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewBookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewBookingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookingEndDate;
    private javax.swing.JTextField BookingStartDateField;
    private javax.swing.JTextField CVVField;
    private javax.swing.JRadioButton CashRadioButton;
    private javax.swing.JButton CheckAvalibalitiy;
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton ConfirmBookingButton;
    private javax.swing.JTextField CountryTextField;
    private javax.swing.JTextField CreditCardNoField;
    private javax.swing.JRadioButton CreditCardRadioButton;
    private javax.swing.JComboBox DayComboBox;
    private javax.swing.JTextField EmailField;
    private javax.swing.JComboBox ExpiryDateMonthCompobox;
    private javax.swing.JComboBox ExpiryDateYearsCompobox;
    private javax.swing.JRadioButton FemaleRadioButton;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JTextField HomePhoneField;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JRadioButton MaleRadioButton;
    private javax.swing.JTextField MaximumOccupantField;
    private javax.swing.JTextField MobileField;
    private javax.swing.JComboBox MonthComboBox;
    private javax.swing.JTextField NameOfCadholderField;
    private javax.swing.JSpinner NumberOfNight;
    private javax.swing.JButton ResetAllButton;
    private javax.swing.JTextArea RoomDescription;
    private javax.swing.JTextArea RoomFeatures;
    private javax.swing.JComboBox RoomNoComboBox;
    private javax.swing.JComboBox RoomTypeComboBox;
    private javax.swing.JTextArea SpecialInstruction;
    private javax.swing.JComboBox StateComboBox;
    private javax.swing.JTextField StreetNameField;
    private javax.swing.JTextField StreetNoField;
    private javax.swing.JTextField SuburbField;
    private javax.swing.JTextField TariffPerNightField;
    private javax.swing.JLabel TotalTariff;
    private javax.swing.JTextField UnitNoField;
    private javax.swing.JButton VerifyButton;
    private javax.swing.JLabel VerifyField;
    private javax.swing.JTextField WorkPhoneField;
    private javax.swing.JComboBox YearsComboBox;
    private javax.swing.JTextField ZIPTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel checkAvalibility;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
