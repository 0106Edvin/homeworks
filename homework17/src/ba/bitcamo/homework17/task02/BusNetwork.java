package ba.bitcamo.homework17.task02;

import ba.bircamp.homework17.task01.Client;
import ba.bircamp.homework17.task01.Computer;
import ba.bircamp.homework17.task01.Network;
import ba.bircamp.homework17.task01.Server;

public class BusNetwork extends Network implements Functionable {
	private int counter;

	public BusNetwork(String networkName) {
		super(networkName);

	}

	@Override
	/**
	 * Checking is our network functionable, and if more then 2 computers are connected returning true
	 */
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < getComputersInNetwork().length; i++) {
			if (getComputersInNetwork()[i] != null) {
				counter++;
			}
		}
		if (counter >= 2) {
			return true;
		} else
			return false;
	}

	@Override
	/**
	 * Extending our array of computers by one 
	 */
	public void addComputer(Computer c) throws IllegalArgumentException {

		if (c instanceof Server) {
			throw new IllegalArgumentException("Can't add server");

		} else {
			Computer[] temp = ArrayManipulation
					.extendArray(getComputersInNetwork());
			temp[temp.length - 1] = c;
			setComputersInNetwork(temp);
			if (c instanceof Client) {
				Client cl = (Client) c;
				cl.connect(this);

			}
		}

	}

	@Override
	/**
	 * Reducing our array of computers by one
	 */
	public void removeComputer(Computer c) throws IllegalArgumentException {
		boolean found = false;
		if (c instanceof Server) {
			throw new IllegalArgumentException("Can't remove server");
		} else if (c instanceof Client) {
			Client cl = (Client) c;
			cl.disconnect();
			for (int i = 0; i < getComputersInNetwork().length; i++) {
				if (c.equals(getComputersInNetwork()[i])) {
					ArrayManipulation.shrinkArray(getComputersInNetwork(), i);
					setComputersInNetwork(ArrayManipulation.shrinkArray(
							getComputersInNetwork(), i));

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
