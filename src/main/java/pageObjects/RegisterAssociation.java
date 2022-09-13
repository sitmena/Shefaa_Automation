package pageObjects;

import managers.FileReaderManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Wait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RegisterAssociation {


    private final WebDriver webDriver;

    public RegisterAssociation(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "licnum")
    private WebElement licNum;
    @FindBy(id = "inquiry")
    private WebElement inquiryBtn;
    @FindBy(id = "sendbtn")
    private WebElement sendBtn;
    @FindBy(id = "mobilenumber")
    private WebElement mobileNum;
    @FindBy(id = "dateofbirth")
    private WebElement dob;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "id")
    private WebElement id;
    @FindBy(id = "confirmbtn")
    private WebElement confirmationBtn;
    @FindBy(id = "otp1")
    private WebElement otp1;
    @FindBy(id = "associationname")
    private WebElement associationName;
    @FindBy(id = "associationtype")
    private WebElement associationType;
    @FindBy(id = "specializedsublist")
    private WebElement specializedSublist;

    @FindBy(id = "associationlogo")
    private WebElement associationLogo;
    @FindBy(id = "expirydate")
    private WebElement expiryDate;
    @FindBy(id = "licensefile")
    private WebElement licenseFile;
    @FindBy(id = "iban")
    private WebElement iban;
    @FindBy(id = "bankaccount")
    private WebElement bankAccount;
    @FindBy(id = "associationnumber")
    private WebElement associationNumber;
    @FindBy(id = "email1")
    private WebElement email1;
    @FindBy(id = "secondotp")
    private WebElement secondOtp;
    @FindBy(id = "associationlocation")
    private WebElement associationLocation;
    @FindBy(id = "city")
    private WebElement city;;
    @FindBy(id = "town")
    private WebElement town;
    @FindBy(id = "locationlink")
    private WebElement locationLink;
    @FindBy(id = "numberofproviders")
    private WebElement numberOfProviders;
    @FindBy(id = "hospitalname")
    private WebElement hospitalName;
    @FindBy(id = "discountrate")
    private WebElement discountRate;

    @FindBy(id = "ceoname")
    private WebElement ceoName;
    @FindBy(id = "ceonumber")
    private WebElement ceoNumber;
    @FindBy(id = "rules")
    private WebElement rules;
    @FindBy(id = "successmessage")
    private WebElement successMsg;
    @FindBy(id = "emailotp")
    private WebElement emailOtp;
    @FindBy(id = "mobileotp")
    private WebElement mobileOtp;
    @FindBy(id = "confirmmobileotp")
    private WebElement confirmmobileOtp;
    @FindBy(id = "confirmemailotp")
    private WebElement confirmemailOtp;

    @FindBy(id = "calendarIcon")
    private WebElement calendarIcon;

    @FindBy(id = "calendarYear")
    private WebElement calendarYear;
    @FindBy(id = "calendarMonth")
    private WebElement calendarMonth;
    @FindBy(id = "previousYear")
    private WebElement previousYear;

    @FindBy(id = "dateCells")
    private List<WebElement> dateCells;
    @FindBy(id = "monthCellsselector")
    private List<WebElement> monthCellsselector;

    @FindBy(id = "endcalendarIcon")
    private WebElement endcalendarIcon;

    @FindBy(id = "calendarToday")
    private WebElement calendarToday;

    @FindBy(id = "nextMonth")
    private WebElement nextMonth;


    @FindBy(id = "dayCells")
    private List<WebElement> dayCells;


    public void userfillrequiredfields(int mobilenum, int year,String month,int day, String email, int id) throws IOException, InterruptedException {
        this.mobileNum.sendKeys(""+mobilenum+"");
        calendarBirthDate_WebElement(calendarIcon,calendarYear,calendarMonth,previousYear,dateCells,monthCellsselector,year,month,day);
        this.email.sendKeys(email);
        this.id.sendKeys(""+id+"");

    }
    public void confirm()
    {

        this.confirmationBtn.click();
        Wait.untilElementIsVisible(webDriver,otp1,20L);
        Assert.assertTrue(otp1.isDisplayed());
    }
    public void fillmobileotp(){this.mobileOtp.click();}
    public void fillEmailOtp(){
        this.emailOtp.click();
    }

    public void confirmmobileOtp() {
        this.confirmmobileOtp.click();
        }


    public void confirmemailOtp() {
        this.confirmemailOtp.click();
    }



    public void userFilllicNumber(int licnum) throws InterruptedException{

        this.licNum.sendKeys(""+licnum+"");
        // This sleep is temp and fluent wait should be added to core in order to use elementisenabled
        Thread.sleep(2000);
        Assert.assertTrue(inquiryBtn.isEnabled());

    }
    public void chooseInquiry()
    {

        this.inquiryBtn.click();
        Wait.untilElementIsVisible(webDriver,associationName,20L);
        Assert.assertTrue(associationName.isDisplayed());


    }

    public void userfillassociationinfo (int iban,int associationnumber,String email,int secondotp,String associationlocation,String localink,int numberofproviders, int discountrate,String ceoname,int ceonumber) throws IOException, InterruptedException {

        List<WebElement> associationOptions = new ArrayList();
        Select association_type = new Select(associationType);
        associationOptions = association_type.getOptions();
        int associationOptionsSize = associationOptions.size();
        int randomFromassociationOptions = randomNumBetweenGivenValues(0, associationOptionsSize);
        String SelectorText = null;
      for(int i=0 ;i<=associationOptions.size();i++){
          if(i==randomFromassociationOptions){
              SelectorText=  associationOptions.get(i).getText();
              break;
          }

        }
       association_type.selectByIndex(randomFromassociationOptions);
       if( SelectorText.equals("العامة")) {

       } else{

           List<WebElement> specializedOptions = new ArrayList();
           Select specialized_sublist = new Select(specializedSublist);
           specializedOptions = specialized_sublist.getOptions();
           int specializedOptionssize = specializedOptions.size();
           int randomFromspecializedoption= randomNumBetweenGivenValues(0, specializedOptionssize);
           specialized_sublist.selectByIndex(randomFromspecializedoption);
       }

        uploadlogo();

        calendarInFutureWE( endcalendarIcon , calendarToday, nextMonth, dayCells);
        uploadfile();
      this.iban.sendKeys(""+iban+"");
      uploadbankaccount();
      this.associationNumber.sendKeys(""+associationnumber+"");
      this.email1.sendKeys(email);
      this.secondOtp.sendKeys(""+secondotp+"");
      this.associationLocation.sendKeys(associationlocation);

        List<WebElement> cityOptions = new ArrayList();
        Select city_list = new Select(city);
        cityOptions = city_list.getOptions();
        int cityoptionssize = cityOptions.size();
        int randomFromcityoption= randomNumBetweenGivenValues(0, cityoptionssize);
        city_list.selectByIndex(randomFromcityoption);



        List<WebElement> townOptions = new ArrayList();
        Select town_list = new Select(town);
        townOptions = town_list.getOptions();
        int townoptionssize = cityOptions.size();
        int randomFromtownoption= randomNumBetweenGivenValues(0, townoptionssize);
        town_list.selectByIndex(randomFromtownoption);

      this.locationLink.sendKeys(localink);

      this.numberOfProviders.sendKeys(""+numberofproviders+"");


        List<WebElement> hospitaloptions = new ArrayList();
        Select hospital_list = new Select(hospitalName);
        hospitaloptions = hospital_list .getOptions();
        int hospitaloptionssize = hospitaloptions.size();
        int randomFromhospitaloption= randomNumBetweenGivenValues(0, hospitaloptionssize);
        hospital_list.selectByIndex(randomFromhospitaloption);


      this.discountRate.sendKeys(""+discountrate+"");

      this.ceoName.sendKeys(ceoname);

      this.ceoNumber.sendKeys(""+ceonumber+"");


    }
public void uploadlogo(){
        String os= FileReaderManager.getInstance().getConfigFileReader().getProperty("os");

        String userDirectory=System.getProperty("user.dir");
        String logoPath=userDirectory+"\\src\\test\\resources\\testlogo.png";
    if(os.equals("windows")){
       //leave it as it is
    }else{
        logoPath = logoPath.replace("\\", "//");
    }
        this.associationLogo.sendKeys(logoPath);
}


    public void uploadfile(){
        String os= FileReaderManager.getInstance().getConfigFileReader().getProperty("os");

        String userDirectory=System.getProperty("user.dir");
        String filePath=userDirectory+"src\\test\\resources\\وثيقة متطلبات الأعمال  V.3.1";
        if(os.equals("windows")){
            //leave it as it is
        }else{
            filePath = filePath.replace("\\", "//");
        }
        this.licenseFile.sendKeys(filePath);
    }

    public void uploadbankaccount(){
        String os= FileReaderManager.getInstance().getConfigFileReader().getProperty("os");

        String userDirectory=System.getProperty("user.dir");
        String bankaccountPath=userDirectory+"src\\test\\resources\\وثيقة متطلبات الأعمال  V.3.1";
        if(os.equals("windows")){
            //leave it as it is
        }else{
            bankaccountPath = bankaccountPath.replace("\\", "//");
        }
        this.bankAccount.sendKeys(bankaccountPath);
    }





    public void confirmrules() throws InterruptedException{

        this.rules.click();
        Thread.sleep(2000);
        Assert.assertTrue(sendBtn.isEnabled());
    }


    public void pressSendBtn(){
        this.sendBtn.click();
        Wait.untilElementIsVisible(webDriver,successMsg,20L);
        Assert.assertTrue(successMsg.isDisplayed());

    }


//to select date of birth
    public void  calendarBirthDate_WebElement(WebElement calendarIcon , WebElement calendarYear, WebElement calendarMonth, WebElement previousYear, List<WebElement> dateCells, List<WebElement> monthCellsselector, int year, String month, int day) throws IOException, InterruptedException {
        calendarIcon.click();
        Thread.sleep(1000);
        calendarIcon.click();

        Thread.sleep(2000);

        String yeartitle;
        String monthTitle;
        String todayTitle;

        int todayDB = day;

        if(todayDB>=1 && todayDB<=9) {
            todayTitle  = "0"+String.valueOf(todayDB);
        }else {
            todayTitle = String.valueOf(todayDB);
        }



        int  monthDB;
        int yearDB;


        for(int yt = 0; yt <= 60; yt++) {
            yeartitle = calendarYear.getText();
            yearDB = Integer.parseInt(yeartitle);

            if(yearDB == year) {
                calendarMonth.click();
                // For for month
                java.util.List<WebElement> monthCells = new ArrayList();
                Thread.sleep(4000);
                monthCells = monthCellsselector;
                for (int mc = 0; mc <monthCells.size(); mc++) {
                    if(monthCells.get(mc).getAttribute("title").equalsIgnoreCase(month)) {
                        monthCells.get(mc).click();
                        Thread.sleep(1000);
                        monthDB = Integer.parseInt(calendarMonth.getText());
                        if(monthDB>=1 && monthDB<=9) {
                            monthTitle = "0"+String.valueOf(monthDB);
                        }else {
                            monthTitle = String.valueOf(monthDB);
                        }
                        Thread.sleep(1000);
                        // For for day
                        java.util.List<WebElement> dateCells1 = new ArrayList();
                        Thread.sleep(2000);
                        dateCells1 = dateCells;
                        for(int dc1 = 0; dc1 < dateCells1.size(); dc1++) {
                            if((dateCells1.get(dc1).getAttribute("title").split("-")[1].equals(monthTitle)) && (dateCells1.get(dc1).getAttribute("title").split("-")[2].equals(todayTitle)) ) {
                                dateCells1.get(dc1).click();
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }else {
                previousYear.click();
            }
        }

    }
    public int randomNumBetweenGivenValues(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }


   // Choosing Calendar in the future (Next Month Only)

  public void  calendarInFutureWE(WebElement endcalendarIcon , WebElement calendarToday, WebElement nextMonth, List<WebElement> dayCells) throws IOException, InterruptedException {
    endcalendarIcon.click();
    Thread.sleep(2000);

    String todaytitle = calendarToday.getAttribute("title").split(",")[1];
    // Keep num
    String keepNumsOnly = todaytitle.replaceAll("[^\\d.]", "");
    todaytitle = keepNumsOnly.trim();

    String currentMonth = calendarToday.getAttribute("title").split(",")[1];
    // Keep text
    String keepCharsOnly = currentMonth.replaceAll("[?:^\\d.]", "");
    currentMonth = keepCharsOnly.trim();

    switch (currentMonth){
        case"January":
            currentMonth ="01";
            break;
        case"February":
            currentMonth = "02";
            break;
        case"March":
            currentMonth = "03";
            break;
        case"April":
            currentMonth = "04";
            break;
        case"May":
            currentMonth = "05";
            break;
        case"June":
            currentMonth = "06";
            break;
        case"July":
            currentMonth = "07";
            break;
        case"August":
            currentMonth = "08";
            break;
        case"September":
            currentMonth= "09";
            break;
        case"October":
            currentMonth = "10";
            break;
        case"Novermber":
            currentMonth = "11";
            break;
        case"December":
            currentMonth = "12";
            break;
    }
    System.out.println("The current today:   "+todaytitle);
    System.out.println("The current month:   "+currentMonth);
    Thread.sleep(2000);

    int today = 0;
    int month = 0;
    String DateDay = null;
    String DateMonth = null;

    if (todaytitle.equalsIgnoreCase("27")||todaytitle.equalsIgnoreCase("28")||todaytitle.equalsIgnoreCase("29")||todaytitle.equalsIgnoreCase("30") ||todaytitle.equalsIgnoreCase("31")){
        today = 3;
        month = Integer.parseInt(currentMonth)+1;
        nextMonth.click();
        Thread.sleep(1000);
    } else {
        today =   Integer.parseInt(todaytitle)+1;
        month = Integer.parseInt(currentMonth);
    }

    int min=today;
    int max=28;
    int dayCell = ThreadLocalRandom.current().nextInt(min, max);

    if(dayCell >= 1 && dayCell <=9) {
        System.out.println("This is if: ");
        DateDay = "0"+ String.valueOf(dayCell);

    }else {
        System.out.println("This is else: ");
        DateDay = String.valueOf(dayCell);
    }

    if(month >= 1 && month <=9) {
        DateMonth = "0"+String.valueOf(month);
    }else {
        DateMonth = String.valueOf(month);
    }

    System.out.println(DateDay);
    System.out.println(DateMonth);

    java.util.List<WebElement> dateCells = new ArrayList();
    Thread.sleep(2000);
    dateCells = dayCells;
    for(int dc = 0; dc < dateCells.size(); dc++) {
        // converting month to num along with extracting date
        String day = dateCells.get(dc).getAttribute("title").split(",")[1];
        // Keep num
        day = day.replaceAll("[^\\d.]", "").trim();

        String date = dateCells.get(dc).getAttribute("title").split(",")[1];
        // Keep text
        date = date.replaceAll("[?:^\\d.]", "").trim();

        switch (date){
            case"January":
                date ="01";
                break;
            case"February":
                date = "02";
                break;
            case"March":
                date = "03";
                break;
            case"April":
                date = "04";
                break;
            case"May":
                date = "05";
                break;
            case"June":
                date = "06";
                break;
            case"July":
                date = "07";
                break;
            case"August":
                date = "08";
                break;
            case"September":
                date= "09";
                break;
            case"October":
                date = "10";
                break;
            case"Novermber":
                date = "11";
                break;
            case"December":
                date = "12";
                break;
        }

        if((date.equals(DateMonth)) && (day.equals(DateDay)) ) {
            dateCells.get(dc).click();
            break;
        }
    }
}

}
