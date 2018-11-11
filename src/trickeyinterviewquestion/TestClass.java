package trickeyinterviewquestion;

import java.util.*;
class A{}
class B extends A {}
class C extends B{}


public class TestClass {
	public static void main(String[] args) {
	Properties p=System.getProperties();
	p.setProperty("pirate", "scurvy");
	String s=p.getProperty("sddsdsd")+" ";
	s +=p.getProperty("pirate");
	System.out.println(s);
	
	}
	
	
}
