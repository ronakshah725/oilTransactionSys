package com.ots.common;

public class ReportOilBean{
	private float sums;
	private boolean payment_avl;
	private boolean is_cancelled;
	public float getSums() {
		return sums;
	}
	public void setSums(float sums) {
		this.sums = sums;
	}
	public boolean getPayment_avl() {
		return payment_avl;
	}
	public void setPayment_avl(boolean payment_avl) {
		this.payment_avl = payment_avl;
	}
	public boolean getIs_cancelled() {
		return is_cancelled;
	}
	public void setIs_cancelled(boolean is_not_cancelled) {
		this.is_cancelled = is_not_cancelled;
	}
	@Override
	public String toString() {
		return "ReportOilBean [sums=" + sums + ", payment_avl=" + payment_avl + ", is_cancelled=" + is_cancelled + "]";
	}
	
	
}