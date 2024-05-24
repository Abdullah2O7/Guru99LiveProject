package utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import java.io.IOException;


public class Listener extends Report implements ITestListener {

    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Pass Test case is: " + result.getName());
        }
    }

    public void onTestFailure(ITestResult result) {
      if (result.getStatus() == ITestResult.FAILURE) {
          extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
      }
      }
//            try {
//                extentTest.log(Status.FAIL,
//                        MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//                extentTest.log(Status.FAIL,
//                        MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//                //String imgPath = action.screenShot(BaseClass.getDriver(), result.getName());
//
//                //extentTest.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
//
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }

    public void onTestSkipped(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Skipped Test case is: " + result.getName());
        }
    }
}
