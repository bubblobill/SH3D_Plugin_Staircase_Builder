package beans;

import java.io.Serializable;


public class bean implements Serializable {
	private static final long serialVersionUID = 1L;

	//instance variables
		private long personID;
		private String firstName;
		
	public bean() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param personID
	 * @param firstName
	 */
	public bean(long personID, String firstName) {
		super();
		this.personID = personID;
		this.firstName = firstName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (personID ^ (personID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		bean other = (bean) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (personID != other.personID)
			return false;
		return true;
	}
	/**
	 * @return the personID
	 */
	public long getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(long personID) {
		this.personID = personID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

}
