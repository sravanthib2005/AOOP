package com.Area;

public class Rectangle extends Shape{
	 private double width;
	    private double height;

	    public Rectangle(double width, double height) {
	        this.width = width;
	        this.height = height;
	    }


	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return width * height;
	}

}
