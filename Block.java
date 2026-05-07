public class Block extends GameObject {
	public static final int SIZE = 32;

	public Block (double x, double y) {
		super( x*SIZE, y*SIZE, SIZE, SIZE, "Assets/tile-brick.png");
	}

	public boolean isTouchingX(GameObject gameObject, double ratio) {
		double overlap = this.getWidth() * ratio;
		return (Math.abs( this.getX()-gameObject.getX() ) < overlap);
	}

	public boolean isTouchingY(GameObject gameObject, double ratio) {
		double overlap = this.getHeight() * ratio;
		return (Math.abs( this.getY()-gameObject.getY() ) < overlap);
	}

	public boolean isTouchingY (GameObject player) {
		return this.getY() <= player.getY() + player.getHeight() && player.getY() <= this.getY() + this.getHeight()/2;
	}

	public boolean isTouching(GameObject gameObject) {
		return isTouchingY(gameObject) && isTouchingX(gameObject, 0.75);
	}

	public Block(double x, double y, String image) {
		super( x*SIZE, y*SIZE, SIZE, SIZE, image);
	}
}