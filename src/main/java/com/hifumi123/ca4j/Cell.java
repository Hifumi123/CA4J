package com.hifumi123.ca4j;

public interface Cell extends Cloneable {
	
	//TODO 此接口中似乎用不着 State
	public int getState();
	
	//TODO 此接口中似乎用不着 State
	public void setState(int state);
	
	public Object clone() throws CloneNotSupportedException;
}
