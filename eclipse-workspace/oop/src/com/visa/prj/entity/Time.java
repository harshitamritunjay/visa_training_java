/**
 * 
 */
package com.visa.prj.entity;

/**
 * @author Administrator
 *
 */
public class Time {
	
	
	private int hours;
	private int minutes;
	
	public Time() {
		super();
	}
	public Time(int hours, int minutes) {
		super();
		this.hours = hours;
		this.minutes = minutes;
	}
	public Time add(Time a)
	{
		Time r= new Time();
		int x=a.minutes+this.minutes;
		int y=a.hours+this.hours;
		if(x>=60) {
			x=x-60;
			y=y+1;
		}
		r.hours=y;
		r.minutes=x;
		return r;
	}
	public static Time add(Time a, Time b) {
		Time r= new Time();
		int x=a.minutes+b.minutes;
		int y=a.hours+b.hours;
		if(x>=60) {
			x=x-60;
			y=y+1;
		}
		r.hours=y;
		r.minutes=x;
		return r;
	}
	public int getHours() {
		return this.hours;
	}
	
	public int getMinutes() {
		return this.minutes;
	}
}
