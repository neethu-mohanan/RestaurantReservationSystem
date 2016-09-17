package assignment;

/**
 * Contains the details of menu item which has been ordered, namely name, description, 
 * price and exist (a variable which tells whether the particular item exists in the menu or not). 
 * Derived from the interface MenuItem.
 * @author diveshbiyani
 *
 */
public class OrderItem implements MenuItem
{
	private String name;
	private boolean exist;
	private float price;
	private String description;
	public OrderItem()
	{
		name="";
		exist=false;
		price=0;
		description="";
	}
	public OrderItem(String name, String description, boolean exist, float price)
	{
		this.name=name;
		this.description=description;
		this.exist=exist;
		this.price=price;
	}
	public String getName() 
	{
		return name;
	}
	public String getDescription() 
	{
		return description;
	}	
	public boolean ifExists() 
	{
		return exist;
	}
	public float getPrice() 
	{
		return price;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public void setExists(boolean e)
	{
		exist=e;
	}
	public void setPrice(float price)
	{
		this.price=price;
	}
}
