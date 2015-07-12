package ba.bircamp.homework17.task01;

public class Server extends Computer {

	private int maxComputers;

	public Server(String name, char[] MAC, int maxComputers) {
		super(name, MAC);
		this.maxComputers = maxComputers;
	}

	public int getMaxComputers() {
		return maxComputers;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (maxComputers != other.maxComputers)
			return false;
		return true;
	}

	public String toString() {
		String s = super.toString();
		s += "Max computers on server " + maxComputers;
		return s;
	}
}
