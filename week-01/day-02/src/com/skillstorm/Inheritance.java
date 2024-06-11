package com.skillstorm;

public class Inheritance {

	public static void main(String[] args) {
		
		/**
		 * Inheritance in Java
		 * 
		 * You can create classes which inherit from other classes
		 * to take on their properties and methods
		 * 
		 * Code reusability
		 * Structure
		 */
		
		MusicalInstrument mi = new MusicalInstrument("Woodwind", 10, 100.00);
		
		mi.makeNoise();
		System.out.println(mi.type);
		
		Saxophone sax = new Saxophone("Woodwind", 5, 1000.00, "Plastic");
		
		sax.makeNoise();
		System.out.println(sax.mouthpieceMaterial);
		
		AltoSaxophone alto = new AltoSaxophone("Woodwind", 7, 1500.00, "Brass", "F#");
		alto.makeNoise();

	}

}

class MusicalInstrument {
	
	// properties
	public String type;
	public double weight;
	public double price;
	
	// constructor
	public MusicalInstrument(String type, double weight, double price) {
		super();
		this.type = type;
		this.weight = weight;
		this.price = price;
	}
	
	// methods
	public void makeNoise() {
		System.out.println("Noise!!");
	}
}

// you can ONLY extend ONE class
class Saxophone extends MusicalInstrument {
	
	// properties
	public String mouthpieceMaterial;
	
	// constructor
	public Saxophone(String type, double weight, double price, String mouthpieceMaterial) {
		// calling the superclass constructor
		// this is called constructor chaining
		super(type, weight, price);
		this.mouthpieceMaterial = mouthpieceMaterial;
	}
	
	// methods
	public void makeNoise() {
		System.out.println("Honk!!");
	}
	
}

class AltoSaxophone extends Saxophone {
	
	public String highNote;

	public AltoSaxophone(String type, double weight, double price, String mouthpieceMaterial, String highNote) {
		super(type, weight, price, mouthpieceMaterial);
		this.highNote = highNote;
	}
	
	// methods
	public void makeNoise() {
		System.out.println("Honk an " + highNote + "!!");
	}

}
