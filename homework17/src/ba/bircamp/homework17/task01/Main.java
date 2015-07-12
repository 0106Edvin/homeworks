package ba.bircamp.homework17.task01;

import java.util.Arrays;

import ba.bitcamo.homework17.task02.ArrayManipulation;
import ba.bitcamo.homework17.task02.StarNetwork;

public class Main {

	public static void main(String[] args) {

		char[] m1 = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'1', '2', 'a', 'b' };
		char[] m2 = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', '1', '2' };
		char[] server = new char[] { '1','1','1','1','1','1','1','1','1','1','1','1'};
		
		Server s = new Server("IMAC", server, 3);
		Client cl1 = new Client("Asus", m1);
		Client cl2 = new Client("Client2", m2);
		Client cl3 = new Client("Client3", new char[12]);
		Client cl4 = new Client("Client4", new char[12]);
		Client cl5 = new Client("Client5", new char[12]);
		Client cl6 = new Client("Client6", new char[12]);
		
		
		
		System.out.println("Testing connect and disconnect method\n");
		cl1.connect(s);
		System.out.println(cl1);
		cl1.disconnect();
		cl1.connect(s);
		System.out.println(cl1);

		System.out.println("***************************************************");
		System.out.println("Testing shrink and extend array method\n");
		
		char[] MAC = { 'a' };
		Computer[] comps = { new Computer("m1", MAC), new Computer("m2", MAC),
				new Computer("m3", MAC), new Computer("m4", MAC) };

		System.out.println(Arrays.toString(ArrayManipulation.shrinkArray(comps,
				2)));
		System.out
				.println(Arrays.toString(ArrayManipulation.extendArray(comps)));
		
		StarNetwork sn = new StarNetwork("Star Network", s);
		//sn.addComputer(cl1);
		sn.addComputer(cl2);
		sn.addComputer(cl3);
		sn.removeComputer(cl3);
		System.out.println(sn);
		
	    char[] mac1 = {12, 13, 14, 15};
	    char[] mac2 = {12, 13, 14, 15};

	    Computer c1 = new Computer("mirza", mac1);
	    Computer c2 = new Computer("mirza", mac2);
	  

        System.out.println(c1.equals(c2));
	}
}
