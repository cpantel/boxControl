package model;

public class ControlModel implements Drawable{
	private String name;
    private int penalty;
	private boolean inverted;
	private boolean active;
	
	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;		
	}
	
	@Override
	public boolean isInverted() {
		return inverted;
	}

	@Override
	public boolean setInverted(boolean inverted) {
		this.inverted = inverted;
		return this.inverted;
	}

	@Override
	public void setInverted() {
		inverted = !inverted;
	}
	
	@Override
	public void setPenalty(int penalty) {
		this.penalty=penalty;
	}
	
	@Override
	public int getPenalty() {
		return penalty;
	}

	public void reset() {
		setActive(false);
		
	}
}
