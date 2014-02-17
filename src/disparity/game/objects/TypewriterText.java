package disparity.game.objects;

public class TypewriterText {

	private final String text;
	private final TypewriterTextType type;

	
	public TypewriterText(String str, TypewriterTextType textType) {
		this.text = str;
		this.type = textType;
	}
	
	public String getText() {
		return text;
	}
	
	public char[] getTextToCharArray() {
		return text.toCharArray();
	}
	
	protected TypewriterTextType getType() {
		return type;
	}

}