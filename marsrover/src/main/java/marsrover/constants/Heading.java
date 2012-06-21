package marsrover.constants;

public enum Heading {
	N("NORTH"), S("SOUTH"), E("EAST"), W("WEST");
	private String value;

	public String getValue() {
		return value;
	}

	private Heading(String value) {
		this.value = value;
	}
}
