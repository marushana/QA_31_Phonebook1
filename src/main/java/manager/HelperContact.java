package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }


    public void openContactForm() {
        click(By.xpath("//*[text() = 'ADD']"));
    }

    public void fillContactForm(Contact contact1) {
        type(By.xpath("//*[@placeholder='Name']"), contact1.getName());
        type(By.xpath("//*[@placeholder = 'Last Name']"), contact1.getLastName());
        type(By.xpath("//*[@placeholder = 'Phone']"), contact1.getPhone());
        type(By.xpath("//*[@placeholder = 'email']"), contact1.getEmail());
        type(By.xpath("//*[@placeholder = 'Address']"), contact1.getAddress());
        type(By.xpath("//*[@placeholder = 'description']"), contact1.getDescription());
    }

    public void submitContactForm() {
        click(By.xpath("//*[text() = 'Save']"));
    }

    public boolean isNewContactDisplayed(Contact contact) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.textToBePresentInElement
                (wd.findElement(By.cssSelector(".contact-page_leftdiv__yhyke")), contact.getName()));
    }


}
