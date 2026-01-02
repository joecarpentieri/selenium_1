package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import static utilities.DropDownUtility.selectByVisibleText;

public class DatePickerMenuPage extends WidgetsPage {

    private By selectDateField = By.id("datePickerMonthYearInput");
    private By monthDropDown = By.className("react-datepicker__month-select");
    private By yearDropDown = By.className("react-datepicker__year-select");

    private By dayValue(String day) { // private as By is a webdriver API - do not want test to have access to the method
        return By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--')][text()='"+ day +"']");
    }

    public void clickDay(String day) {
        click(dayValue(day));
    }

    public void clickSelectDate() { // clicks on the selector
        click(selectDateField);
    }

    public String getDate() { //gets the date selected
        return find(selectDateField).getAttribute("value");
    }

    public void selectMonth(String month) {
        selectByVisibleText(monthDropDown, month);
    }

    public void selectYear(String year) {
        selectByVisibleText(yearDropDown, year);
    }
}
