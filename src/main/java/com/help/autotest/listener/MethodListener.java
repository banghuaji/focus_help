package com.help.autotest.listener;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MethodListener implements IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod iim, ITestResult itr) {
	}

	public void afterInvocation(IInvokedMethod iim, ITestResult itr) {

		if (iim.isTestMethod()) {
			if (StaticPara.resultCsvFilename != null) {
				try {
					String parameters = "";
					for (Object para : itr.getParameters()) {
						parameters += para.toString();
					}
					String MethodName = itr.getMethod().getMethodName();
					String Description = null;
					String Status = this.StatusDesc(itr.getStatus());
					String Repoter = "";
					String Colour = "\"#EE9CAF\"";
					if (itr.getMethod().getDescription() != null)
						Description = itr.getMethod().getDescription();
					else
						Description = "";
			        // 得到 reporter.log的输出
			        List<String> reporterlogList = Reporter.getOutput(itr);
			        for(String reporterlog : reporterlogList){
			            System.out.println(reporterlog);
			            Repoter = Repoter+"<br>"+reporterlog;
			        }


			        if(Status.endsWith("SUCCESS")){
			        	Colour = "\"#3AF1EB\"";
			        }

			        String std = "<tr bgcolor="+Colour+">"+
			                          "<td height=\"25\" width=\"100\" align=\"center\">"+MethodName+"</td>"+
			                          "<td height=\"25\" width=\"150\" align=\"center\">"+Description+"</td>"+
			                          "<td height=\"25\" width=\"100\" align=\"center\">"+Status+"</td>"+
			                          "<td height=\"25\" width=\"600\" align=\"left\">"+Repoter+"</td>"+
                          			"</tr>";

					switch (itr.getStatus()) {
					case 1:
						StaticPara.successCount++;
						StaticPara.allCount ++;
						StaticPara.successStr.append(std);
						break;
					case 2:
						StaticPara.failureCount++;
						StaticPara.allCount ++;
						StaticPara.failureStr.append(std);
						break;
					case 3:
						StaticPara.skipCount++;
						StaticPara.allCount ++;
						StaticPara.skipStr.append(std);
						break;
					default:
						StaticPara.unknowCount++;
						StaticPara.allCount ++;
						StaticPara.unknowStr.append(std);
						break;
					}
				} catch (Exception ex) {
					Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
				}
			}
		}

	}

	private String StatusDesc(int status) {
		switch (status) {
		case 1:
			return "SUCCESS";
		case 2:
			return "FAILURE";
		case 3:
			return "SKIP";
		default:
			return "未知状态：" + status;
		}
	}

}
