package disparity.game.objects;

public class TypewriterText {

	private String text;
	private TypewriterTextType type;
	
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

}