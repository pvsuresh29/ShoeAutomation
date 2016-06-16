package com.discount.automation.fitment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WheelsByVehiclePage {

	WebDriver driver;
	
	
	//@FindBy(xpath="//*[@id='mm-0']/div[1]/div/div/div/div/div/div[3]/div[1]/div/div/div[1]")
	@FindBy(xpath="//*[@id='mm-0']/div[1]/div/div/div/div/div/div[3]/div[1]/div/div/div[1]")
	WebElement yearDropDown;
	
	@FindBy(xpath="//*[@id='mm-0']/div[1]/div/div/div/div/div/div[3]/div[2]/div/div/div[1]")
	WebElement makeDropDown;
	
	@FindBy(xpath="//*[@id='mm-0']/div[1]/div/div/div/div/div/div[3]/div[3]/div/div/div[1]")
	WebElement modelDropDown;
	
	@FindBy(xpath="//*[@id='mm-0']/div[1]/div/div/div/div/div/div[3]/div[4]/div/div/div[1]")
	WebElement trimDropDown;
	
	@FindBy(xpath="//*[@id='mm-0']/div[1]/div/div/div/div/div/div[3]/div[5]/div/div/div[1]")
	WebElement assemblyDropDown;
	
	public WheelsByVehiclePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getYearDropDown() {
		return yearDropDown;
	}

	public void setYearDropDown(WebElement yearDropDown) {
		this.yearDropDown = yearDropDown;
	}

	public WebElement getMakeDropDown() {
		return makeDropDown;
	}

	public void setMakeDropDown(WebElement makeDropDown) {
		this.makeDropDown = makeDropDown;
	}

	public WebElement getModelDropDown() {
		return modelDropDown;
	}

	public void setModelDropDown(WebElement modelDropDown) {
		this.modelDropDown = modelDropDown;
	}

	public WebElement getTrimDropDown() {
		return trimDropDown;
	}

	public void setTrimDropDown(WebElement trimDropDown) {
		this.trimDropDown = trimDropDown;
	}

	public WebElement getAssemblyDropDown() {
		return assemblyDropDown;
	}

	public void setAssemblyDropDown(WebElement assemblyDropDown) {
		this.assemblyDropDown = assemblyDropDown;
	}
	
	
	@FindBy(className = "fitment-box__container")
	public static WebElement fitmentBoxContainer;
		
	@FindBy(xpath = ".//*[@id='mm-0']/div[1]/div/div/div/div/div/div[2]/div/a[1]")
	public static WebElement whatYouDriveButton;
	       
	@FindBy(linkText = "tire size")
	public static WebElement tireSizeButton;
	
	@FindBy(linkText = "wheel size")
	public static WebElement wheelSizeButton;
			
	@FindBy(className = "fitment-box__shop")
	public static WebElement shopForTiresButton;
	
	@FindBy(className = "fitment-box__shop")
	public static WebElement shopForWheelsButton;
	
	@FindBy(className = "fitment-box__my-vehicle")
	public static WebElement ThatIsMyVehicleButton;
			
    @FindBy(className = "fitment-box__option3")
    public static WebElement wheelSizeTab;
    
    @FindBy(className = "fitment-box__driveform")
    public static WebElement fitmentFormEle;
}




