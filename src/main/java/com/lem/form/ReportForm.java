package com.lem.form;

import java.util.Date;

/**
 * 
 * @author ukathinokkula
 *
 */
public class ReportForm {
	
	private Double totalHoursFrom;
	private Double totalHoursTo;
	private Date fromDate;
	private Date toDate;
	private String projectName;
	
	public Double getTotalHoursFrom() {
		return totalHoursFrom;
	}
	public void setTotalHoursFrom(Double totalHoursFrom) {
		this.totalHoursFrom = totalHoursFrom;
	}
	public Double getTotalHoursTo() {
		return totalHoursTo;
	}
	public void setTotalHoursTo(Double totalHoursTo) {
		this.totalHoursTo = totalHoursTo;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
