package ba.bircamp.homework17.task01;

public class Client extends Computer implements Connectable {

	private Computer comp;
	private Network net;

	public Client(String name, char[] MAC) {
		super(name, MAC);
	}

	@Override
	public void connect(Computer c) throws IllegalArgumentException {
		if (comp != null || this.net != null) {
			throw new IllegalArgumentException(
					"Your computer is already conneceted");
		}
		comp = c;
	}

	@Override
	public void connect(Network net) throws IllegalArgumentException {
		if (this.net != null || comp != null) {
			throw new IllegalArgumentException(
					"Your computer is already conneceted");
		}
		this.net = net;

	}
	public Network net(){
		return net;
	}

	@Override
	public void disconnect() {
		comp = null;
		this.net = null;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (comp == null) {
			if (other.comp != null)
				return false;
		} else if (!comp.equals(other.comp))
			return false;
		if (net == null) {
			if (other.net != null)
				return false;
		} else if (!net.equals(other.net))
			return false;
		return true;
	}

	public String toString() {
		String s = super.toString();
		s += "Connected to comp: " + comp + "\n";
		s += "Connected to network: " + this.net + "\n";
		return s;
	}

}
