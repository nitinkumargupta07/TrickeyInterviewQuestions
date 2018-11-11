package enumconcept;

enum Suit {
	CLUBS(1), SPADES(2), HEARTS(3), DIAMONDS(4);

	int value;

	public int getValue() {
		return this.value;
	}

	private Suit(int v) {
		value = v;
	}
};

enum TrafficSignal {
	RED("stop"), GREEN("start"), ORANGE("slow down");

	private String action;

	public String getAction() {
		return this.action;
	}

	private TrafficSignal(String action) {
		this.action = action;
	}
}

public class EnumTest {

	public static void main(String[] args) {
		
		Suit suit=Suit.CLUBS;
		System.out.println("name : " + suit.name() + " value : " + suit.getValue());
		
		Suit suit1=Suit.valueOf("CLUBS");
		System.out.println("name : " + suit1.name() + " value : " + suit1.getValue());

		
		TrafficSignal signal = TrafficSignal.valueOf("RED");
		System.out.println("name : " + signal.name() + " action : " + signal.getAction());

		// Another Enum valueOf exampel
		signal = TrafficSignal.valueOf("GREEN");
		System.out.println("name : " + signal.name() + " action : " + signal.getAction());

		// valueOf will throw IllegalArgumentException if we pass invalid String
		signal = TrafficSignal.valueOf("Green");

	}

}
