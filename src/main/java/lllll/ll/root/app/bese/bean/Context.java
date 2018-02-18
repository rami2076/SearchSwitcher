package lllll.ll.root.app.bese.bean;

import lllll.ll.root.app.func.search.common.bean.InputBean;
import lllll.ll.root.app.func.search.common.bean.JobBean;



public class Context {

	private JobBean jobBean;
	private InputBean inputBean;
	private String sendPage;
	private String returnPage;

	public String getSendPage() {
		return sendPage;
	}
	public void setSendPage(String sendPage) {
		this.sendPage = sendPage;
	}
	public String getReturnPage() {
		return returnPage;
	}
	public void setReturnPage(String returnPage) {
		this.returnPage = returnPage;
	}
	public JobBean getJobBean() {
		return jobBean;
	}
	public void setJobBean(JobBean jobBean) {
		this.jobBean = jobBean;
	}
	public InputBean getInputBean() {
		return inputBean;
	}
	public void setInputBean(InputBean inputBean) {
		this.inputBean = inputBean;
	}


}
