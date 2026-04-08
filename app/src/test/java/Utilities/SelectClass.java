package Utilities;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class SelectClass {

    private Select select;

    public void SelectDropdown(WebElement dropdownElement) {
        select = new Select(dropdownElement);
    }

    public void selectVisibleText(String day) {
        select.selectByVisibleText(day);
    }

    public void selectValue(String month) {
        select.selectByValue(month);
    }

    public void selectIndex(String year) {
        select.selectByIndex(Integer.parseInt(year));
    }
}
