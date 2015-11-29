package com.ots.common;

public class ReportOilBean{
	private float sums;
	private boolean paymentAvl;
	private boolean isCancelled;
	public float getSums() {
		return sums;
	}
	public void setSums(float sums) {
		this.sums = sums;
	}
	public boolean getPayment_avl() {
		return paymentAvl;
	}
	public void setPayment_avl(boolean payment_avl) {
		this.paymentAvl = payment_avl;
	}
	public boolean getIs_cancelled() {
		return isCancelled;
	}
	public void setIs_cancelled(boolean is_not_cancelled) {
		this.isCancelled = is_not_cancelled;
	}
	@Override
	public String toString() {
		return "ReportOilBean [sums=" + sums + ", payment_avl=" + paymentAvl + ", is_cancelled=" + isCancelled + "]";
	}
	
	
}