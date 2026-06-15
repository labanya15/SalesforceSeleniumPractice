package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.AccountPage;
import com.automation.pages.AppLauncherPage;
import com.automation.pages.sfLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void createAccountTest(){
        setUp();
        sfLoginPage login = new sfLoginPage(driver);
        login.login("labanyahota15.14aaa31f1437@agentforce.com","Test@123");

        AppLauncherPage app = new AppLauncherPage(driver);
        app.openSalesConsole();

        AccountPage acc = new AccountPage(driver);
        acc.openAccounts();

        String accName = acc.createAccount();
        boolean isPresent = acc.verifyAccountInList(accName);

        Assert.assertTrue(isPresent);

        tearDown();
    }

}
