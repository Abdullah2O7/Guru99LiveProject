package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static void setExtentReports()
    {
        htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Guru99 Live Project");
        htmlReporter.config().setTheme(Theme.STANDARD);

        // To add test cases in the report
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        extentReports.setSystemInfo("Tester", "Abdullah");
        extentReports.setSystemInfo("Browser", "FireFox");
    }
    public static void endReport()
    {
        extentReports.flush();
    }
}
