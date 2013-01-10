
public class MutablePosition extends Position {
	
	public MutablePosition(int x, int y) {
		super(x,y);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}