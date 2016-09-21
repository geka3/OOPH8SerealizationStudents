package net.ukr.geka3;

public class FullGroupException extends Exception {
	String error;
	public FullGroupException(String string) {
		// TODO Auto-generated constructor stub
		this.error = string;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FullGroupException [error=" + error + "]";
	}
	
	
}
