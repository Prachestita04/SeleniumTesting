package FailedScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static FailedScreenshot.$2BaseClass.failed;

public class _3CustomListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        try {
            failed();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
