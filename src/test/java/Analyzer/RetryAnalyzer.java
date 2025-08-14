package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITest;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    int retryLimit = 3;

    public boolean retry(ITestResult result) {
        while (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}
