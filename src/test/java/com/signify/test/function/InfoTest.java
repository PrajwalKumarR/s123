package com.signify.test.function;

import com.signify.AppiumConfig;
import com.signify.annotations.Xray;
import com.signify.controller.*;
import com.signify.controller.interfaces.*;
import com.signify.data.DataConstant;
import com.signify.test.cases.IInfoTestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.signify.util.Helper;

import static com.signify.BaseController.IsExecutionOSAndroid;

public class InfoTest extends BaseTestClass implements IInfoTestCases {

    IInfoController infoController;
    ILoginController loginController;
    ISystemController systemController;
    IScanController scanController;
    IMoreController moreController;
    ICameraPermissionController cameraPermissionController;


    @BeforeClass
    @Override
    public void init() {

        if (infoController == null) {
            infoController = new InfoController();
        }
        if (loginController == null) {
            loginController = new LoginController();
        }
        if (systemController == null) {
            systemController = new SystemController();
        }
        if (scanController == null) {
            scanController = new ScanController();
        }
        if (moreController == null) {
            moreController = new MoreController();
        }
        if (cameraPermissionController == null) {
            cameraPermissionController = new CameraPermissionController();
        }
        infoController.waitUntilPageDisplayed();

    }

    @Test(priority = 1)
    @Override
    public void MST_1827_VerifyInFirstLaunchTheWelcomeScreenIsDisplayed() {
        infoController.waitUntilPageDisplayed();
        Assert.assertTrue(infoController.isPageDisplayed());
//        Assert.assertTrue(infoController.isWelcomeToPhilipsServiceTagTextMatched());

        Assert.assertTrue(infoController.isScanQRCodeImageDisplayed());
        //Assert.assertTrue(infoController.isScanQRCodeTitleTextMatched());
        Assert.assertTrue(infoController.isScanQRCodeDescriptionTextMatched());

        Assert.assertTrue(infoController.isRegLuminaireImageDisplayed());
        Assert.assertTrue(infoController.isRegLuminaireTitleTextMatched());
        Assert.assertTrue(infoController.isRegLuminaireDescriptionTextMatched());

//        if (AppiumConfig.executionOS == AppiumConfig.OS.ANDROID) {
//            Assert.assertTrue(infoController.isNfcImageDisplayed());
//            Assert.assertTrue(infoController.isNfcTitleTextMatched());
//            Assert.assertTrue(infoController.isNfcDescription1TextMatched());
//            Assert.assertTrue(infoController.isNfcDescription2TextMatched());
//        }

        Assert.assertTrue(infoController.isOrderServicePartsImageDispalyed());
        Assert.assertTrue(infoController.isOrderServicePartsTitleTextMatched());
        Assert.assertTrue(infoController.isOrderServicePartsDescriptionTextMatched());

        Assert.assertTrue(infoController.isLogActivityImageDisplayed());
        Assert.assertTrue(infoController.isLogActivityTitleTextMatched());
        Assert.assertTrue(infoController.isLogActivityDescriptionTextMatched());

        Assert.assertTrue(infoController.isNextButtonTextMatched());
        ITestResult result = Reporter.getCurrentTestResult();
        result.setAttribute("test","MST-1827");
        result.setAttribute("label","MST-1827");
    }
}