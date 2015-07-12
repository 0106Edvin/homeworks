package ba.bircamp.homework17.task01;

public abstract class Network {

	private String networkName;
	protected Computer[] computersInNetwork;

	public Network(String networkName) {
		super();
		this.networkName = networkName;
		this.computersInNetwork = new Computer[0];
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public Computer[] getComputersInNetwork() {
		return computersInNetwork;
	}

	public void setComputersInNetwork(Computer[] computersInNetwork) {
		this.computersInNetwork = computersInNetwork;
	}

	public abstract void addComputer(Computer c);

	public abstract void removeComputer(Computer c);
}