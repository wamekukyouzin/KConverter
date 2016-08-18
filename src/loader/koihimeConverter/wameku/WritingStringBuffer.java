package loader.koihimeConverter.wameku;

class WritingStringBuffer {
	String sep = System.getProperty("line.separator");
	StringBuffer sb = new StringBuffer();
	WritingStringBuffer() {

	}
	public void append(String str) {
		sb.append(str);
		sb.append(sep);
	}
	public String toString() {
		return sb.toString();
	}
}
