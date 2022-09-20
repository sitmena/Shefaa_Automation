package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Wait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SetDonorInfo {
    private final WebDriver webDriver;

    public SetDonorInfo(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(id = "personalinfobtn")
    private WebElement personalInfoBtn;
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "lastname")
    private WebElement lastName;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "area")
    private WebElement area;

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
    @FindBy(id = "savebtn")
    private WebElement femaleoption;
    @FindBy(id = "femaleOption")
    private WebElement maleoption;
    @FindBy(id = "maleOption")
    private WebElement saveBtn;

    @FindBy(id = "sucessmsg")
    private WebElement successMsg;

    public void choosepersonalinfobtn(){
        this.personalInfoBtn.click();
        Wait.untilElementIsVisible(webDriver,firstName,20L);
        Assert.assertTrue(firstName.isDisplayed());

    }
    public  void fillrequiredinformation(String firstname,String lastname,String email,int year,String month,int day)throws IOException, InterruptedException {
        this.firstName.sendKeys(firstname);
        this.lastName.sendKeys(lastname);
        this.email.sendKeys(email);
        calendarBirthDate_WebElement(calendarIcon,calendarYear,calendarMonth,previousYear,dateCells,monthCellsselector,year,month,day);
        choosegender();

        List<WebElement> areaOptions = new ArrayList();
        Select area_list = new Select(area);
        areaOptions = area_list.getOptions();
        int areaoptionssize = areaOptions.size();
        int randomFromareaoption= randomNumBetweenGivenValues(0, areaoptionssize);
       area_list.selectByIndex(randomFromareaoption);
    }
    public int randomNumBetweenGivenValues(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }
    public void choosegender(){
        this.femaleoption.click();

    }
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

    public void presssavebtn(){
        this.saveBtn.click();

    }
public void verifytheprocess(){
    Wait.untilElementIsVisible(webDriver,successMsg,20L);
    Assert.assertTrue(successMsg.isDisplayed());
}
}