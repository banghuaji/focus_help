package com.help.autotest.listener;

import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
	@Override
	public void onFinish(ISuite arg0) {
		StaticPara.endStr.append("</table></body></html>");
		try {
			FileWriter bw = new FileWriter(StaticPara.resultCsvFilename, false);

			String result = "(总数：" + StaticPara.allCount + "，成功："
					+ StaticPara.successCount + "，失败："
					+ StaticPara.failureCount + "，跳过：" + StaticPara.skipCount
					+ ")";

			StringBuffer allstr = new StringBuffer();
			allstr.append(StaticPara.headStr.toString().replace("{$result}", result));

			allstr.append(StaticPara.failureStr.toString());
			allstr.append(StaticPara.unknowStr.toString());
			allstr.append(StaticPara.skipStr.toString());
			allstr.append(StaticPara.successStr.toString());
			allstr.append(StaticPara.endStr.toString());

			bw.write(allstr.toString());
			bw.close();
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	/**
	 * Suit开始，创建输出文件
	 */
	@Override
	public void onStart(ISuite arg0) {

		try {
			String filepath = arg0.getOutputDirectory();
			File myPath = new File(filepath);
			if (!myPath.exists()) {
				myPath.mkdir();
			}
			StaticPara.resultCsvFilename = arg0.getOutputDirectory()
					+ "\\result.html";
			System.out.println("my reportfile local place:"+StaticPara.resultCsvFilename);
			String str = "<html>"
					+ "<head>"
					+ "<meta http-equiv=\"Content-Type\" content=\"text/html\"  />"
//					charset=\"UTF-8\"
					+ "<title>自动化测试结果</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1 align=\"center\">自动测试结果</h1>"
					+ "<p>自动测试结果{$result}</p>"
					+ "<table width=\"100%\" height=\"100\" border=\"0\" cellspacing=\"1\" bgcolor=\"#000000\">"
					+ "<tr bgcolor=\"#FFFFFF\">"
					+ "<td height=\"25\"  align=\"center\">MethodName</td>"
					+ "<td height=\"25\"  align=\"center\">Description</td>"
					+ "<td height=\"25\"  align=\"center\">Status</td>"
					+ "<td height=\"25\"  align=\"center\">Repoter</td>"
					+ "</tr>";
			StaticPara.headStr.append(str);

		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,
					ex);
		}
	}
}
