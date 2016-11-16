package dtc.web.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dtc.web.pages.BrandsPage;
import utilities.Driver;

/**
 * Created by Suresh Venkata on 10/26/16.
 */
public class BrandsPageSteps {

    private BrandsPage brandsPage;

    public BrandsPageSteps(Driver driver) {
        brandsPage = new BrandsPage(driver);
    }

    @Then("^I see the \"(.*?)\" that I selected$")
    public void i_see_the_that_I_selected(String brand) throws Throwable {
        brandsPage.verifyBrandSelected(brand);
    }


    @When("^I select \"(.*?)\" to shop$")
    public void i_select_to_shop(String subCategory) throws Throwable {
        brandsPage.clickShopBrandCategoryTires(subCategory);
    }

    @Then("^I can see \"(.*?)\" PLP page$")
    public void i_can_see_PLP_page(String brand) throws Throwable {
        brandsPage.verifyBrandCatalogPage(brand);
    }

}
