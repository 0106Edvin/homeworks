package ba.bircamp.homework17.task01;

public class Computer {

	private String name;
	private MACAddress MAC;

	public Computer(String name, char[] MAC) {
		this.name = name;
		this.MAC = new MACAddress(MAC);
	}

	public Computer() {

	}

	public class MACAddress {
		// 0123456789ab
		/**
		 * Creating an array of chars which represents a mac address
		 */
		private char[] address = new char[12];

		public MACAddress(char[] address) {
			super();
			this.address = address;
		}

		// 01:23:45:67:89:ab
		/**
		 * adding a ":" after every 2 characters
		 */
		public String toString() {
			String s = "";
			int counter = 2;
			for (int i = 0; i < address.length; i++) {
				if (i == counter) {
					s += ":";
					counter += 2;

				}
				s += address[i];

			}
			return s;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			MACAddress other = (MACAddress) obj;

			if ((address == null) && (other.address != null))
				return false;
			else if ((address != null) && (other.address == null))
				return false;

			if ((address != null) && (other.address != null))
			{
				if (address.length != other.address.length)
					return false;
				else
					for (int i = 0; i < address.length; i++)
						if (address[i] != other.address[i])
							return false;
			}

			return true;
		}
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Computer other = (Computer) obj;

		if ((name == null) && (other.name != null))
			return false;
		else if ((name != null) && (other.name == null))
			return false;

		if ((name != null) && !name.equals(other.name))
			return false;
		else if ((other.name != null) && !other.name.equals(name))
			return false;

		if ((MAC == null) && (other.MAC != null))
			return false;
		else if ((MAC != null) && (other.MAC == null))
			return false;

		if ((MAC != null) && !MAC.equals(other.MAC))
			return false;
		else if ((other.MAC != null) && !other.MAC.equals(MAC))
			return false;

		return true;
	}

	public String toString() {
		String s = "Name: " + this.name + "\n";
		s += "Mac address: " + MAC + "\n";
		return s;
	}

}
