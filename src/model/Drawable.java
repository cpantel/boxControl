package model;

public interface Drawable {
	public void setName(String name);
    public String getName();
    public void setPenalty(int penalty);
    public int getPenalty();
    public boolean isInverted();
    public boolean setInverted(boolean inverted);
    public void setInverted();
    public boolean isActive();
    public void setActive(boolean active);

}
