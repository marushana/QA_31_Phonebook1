package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        //if SignOut button present --->logout
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("marushana@yandex.ru").withPassword("Pokrov1304!"));
        }
    }

    @Test
    public void addNewContactSucsess(){
        Contact contact1 = Contact.builder().name("Marina").lastName("Siachin").phone("0538535553").email("marusha@list.ru").address("Haifa, Alexander Yannay, 28, 2").description("beloved mom").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact1);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isNewContactDisplayed(contact1));

    }
}
