public class CeilingHazard extends Block {
	public CeilingHazard(double x, double y) {
		super(x,y, "Assets/tile-spikes-ceiling.png");
	}

	public boolean isTouching(GameObject player) {
	//	return super.isTouchingX(player, 0.75) && this.isTouchingY(player);
		return super.isTouchingX(player, 0.75) && super.isTouchingY(player, 0.5);
	}

	//public boolean isTouchingY (GameObject player) {
	//	return this.getY() <= player.getY() + player.getHeight() && player.getY() <= this.getHeight()/2;
	//}
}