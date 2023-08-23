package com.jspiders.CarDekho_case_study.operation;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

import com.jspiders.CarDekho_case_study.entity.Car;
import com.jspiders.CarDekho_case_study.main.CarDekhoMenu;

public class CarOperation
{
	int id;
	String name;
	String fuelType;
	String brand;
	double price;
	boolean found=false;	
	static ArrayList<Car> cars=createList();
	public static ArrayList<Car> createList() {
	ArrayList<Car> car=new ArrayList<Car>();
	return car;
}	
    public void addCarDetails() 
    {
    	Scanner inp=new Scanner(System.in);
    	System.out.println("How many cars do you want to Add!!?? ");
        int carNo=inp.nextInt();
        for (int i = 1;i<=carNo; i++) 
        {
        	System.out.println("Enter the Car ID : ");
        	int car_id=inp.nextInt();
        	System.out.println("Enter the Car Name : ");
        	inp.nextLine();
        	String name=inp.nextLine();
        	System.out.println("Enter the Car Brand : ");
        	String brand=inp.nextLine();
        	System.out.println("Enter the Car Model : ");
        	String model=inp.nextLine();
        	System.out.println("Enter the  Car FuelType : ");
        	String fuelType=inp.nextLine();
        	System.out.println("Enter the Car Price : ");
        	double price=inp.nextDouble();
        	cars.add(new Car(car_id, name, brand, model, fuelType, price));
        	System.out.println("\n"+name+" Car details added successfully !!! ");
        }
   }     
public void searchCarDetails() 
{
	Scanner inp=new Scanner(System.in);
	System.out.println("======= Search Car by ======\n"
						+ "1. Enter Car Name : \n"
						+ "2. Enter Car Brand Name : \n"
						+ "3. Enter Car's Fuel Type : \n"
						+ "4. Go Back \n");
	int choice=inp.nextInt();
	switch (choice) {
	case 1:
		System.out.println("Enter Car Name : ");
		inp.nextLine();
		name=inp.nextLine();
		for(Car c:cars ) {
			if(c.getName().equals(name)) {
				System.out.println(c);
				found=true;
			}
		}
		if (!found) {
			System.out.println("Car with this "+ name+" is not present......");
		}
		break;
	case 2:
		System.out.println("Enter Car Brand : ");
	    inp.nextLine();
	    brand=inp.nextLine();
	    for(Car c:cars ) {
		if(c.getBrand().equals(brand)) {
			System.out.println(c);
			found=true;
		}
	}
	if (!found) {
		System.out.println("Car with this "+ brand +" brand name is not present......");
	}
	break;
	case 3:
		System.out.println("Enter Car fuelType");
	    inp.nextLine();
	    fuelType=inp.nextLine();
	    for(Car c:cars ) {
		if(c.getFuelType().equals(fuelType)) {
			System.out.println(c);
			found=true;
		}
	}
	if (!found) {
		System.out.println("Car with this"+ fuelType +" FuelType is not present........");
	}
	break;
	case 4:
		CarDekhoMenu.menu();
		break;

	default:
		System.out.println("Invalid choice \n Try Again!!!!");
		
	}
}
public void updateCarDetails() {
	Scanner inp=new Scanner(System.in);
	System.out.println("=========== Details of Car =====");	
	for(Car c:cars ) {
       System.out.println(c);		
	}
	System.out.println("======== Car's Details ========");
	System.out.println("1.find car for update details\n2.GO Back");
    int choice=inp.nextInt();
	switch (choice) {
	case 1:
		System.out.println("Enter the Car ID : ");
	     id=inp.nextInt();
	      for(Car c:cars) {
	    	if (c.getCarId()==id) {
	    		System.out.println("Enter the Car Name : ");
	    		inp.nextLine();
			name=inp.nextLine();
			System.out.println("Enter the Car's Brand : ");
			brand=inp.nextLine();
			System.out.println("Enter Car's Price : ");
            price=inp.nextDouble();
	      c.setName(name);
	      c.setBrand(brand);
	      c.setPrice(price);
	      System.out.println("!!!! Data is  Updated Successfully !!!!");
	      found=true;
		}
	}
	if (!found) 
	{
		System.out.println("Car with this "+ id +" is Not Present");
	}
	break;
	case 2:
		CarDekhoMenu.menu();
		break;		
	default:
		System.out.println("Invalid Choice \n " + " Please Enter Correct Input \n"+" Try Again!!!!\n");
		break;
	}
}
public void deleteCarDetails(){
	Scanner inp=new Scanner(System.in);
	System.out.println("Enter Car ID");
    id=inp.nextInt();
     for(Car c:cars) {
   	if (c.getCarId()==id) {
   		cars.remove(cars.indexOf(c));
     System.out.println("!!!! Data Deleted Successfully....!!!!!!");
     found=true;
	}
}
if (!found) {
	System.out.println("Car with this "+ id +" ID is not present");
}
inp.close();
}

}
