package ba.bitcamo.homework17.task02;

import java.util.Arrays;

import ba.bircamp.homework17.task01.Client;
import ba.bircamp.homework17.task01.Computer;
import ba.bircamp.homework17.task01.Network;
import ba.bircamp.homework17.task01.Server;

public class StarNetwork extends Network implements Functionable {
	private int counter = 0;
	private Server s;

	public StarNetwork(String networkName, Server s) {
		super(networkName);
		this.s = s;
	}

	@Override
	/**
	 * Checking if our Network is in function
	 * and counting how many computers are connected on network
	 */
	public boolean isFunctioning() throws IllegalArgumentException {
		Client c;
		System.out.println(Arrays.toString(getComputersInNetwork()));
		for (int i = 0; i < getComputersInNetwork().length; i++) {
			if (getComputersInNetwork()[i] instanceof Client) {
				c = (Client) getComputersInNetwork()[i];
				if (c.net() != null)
					counter++;
			}
		}
		if (counter > s.getMaxComputers())
			return false;
		else
			return true;
	}

	@Override
	/**
	 * Extending our array of computer by one
	 */
	public void addComputer(Computer c) {
		if (c instanceof Server) {
			throw new IllegalArgumentException("You can't add server.");
		} else {

			Computer[] temp = ArrayManipulation
					.extendArray(getComputersInNetwork());
			temp[temp.length - 1] = c;
			setComputersInNetwork(temp);
			if (c instanceof Client) {
				Client cl = (Client) c;

				cl.connect(s);
			}
		}
	}

	@Override
	/**
	 * Reducing out array of computer by one
	 */
	public void removeComputer(Computer c) {
		boolean found = false;
		if (c instanceof Server) {
			throw new IllegalArgumentException("Can't remove server");
		} else if (c instanceof Client) {
			Client cl = (Client) c;
			for (int i = 0; i < getComputersInNetwork().length; i++) {
				if (c.equals(getComputersInNetwork()[i])) {
					ArrayManipulation.shrinkArray(getComputersInNetwork(), i);
					setComputersInNetwork(ArrayManipulation.shrinkArray(
							getComputersInNetwork(), i));
					cl.disconnect();
					found = true;
				}
			}

		}
		if (!found) {

			throw new IllegalArgumentException("Computer not found");
		}
	}

	public String toString() {
		String s = "Number of computers in network " + getComputersInNetwork().length
				+ "\n";
		s += "Network in function: " + isFunctioning();
		return s;
	}
}
