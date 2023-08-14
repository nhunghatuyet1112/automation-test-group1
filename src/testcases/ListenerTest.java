package testcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
	@Override
	public void onFinish(ITestContext arg0) {
		System.out.print(arg0.getName() + " Done");
	}
<<<<<<< HEAD

=======
	
>>>>>>> master
	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Start To " + arg0.getName());
	}
<<<<<<< HEAD

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println(arg0.getName() + " has failed");
	}

=======
	
	
	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println(arg0.getName()+ " has failed");
	}
	
>>>>>>> master
	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println(arg0.getName() + " has been skipped");
	}
<<<<<<< HEAD

=======
	
>>>>>>> master
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println(arg0.getName() + " is testing");
	}
<<<<<<< HEAD

=======
	
>>>>>>> master
	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(arg0.getName() + " has successed");
	}
}
<<<<<<< HEAD
=======

>>>>>>> master
