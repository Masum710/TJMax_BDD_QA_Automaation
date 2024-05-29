package stepDefinition;

public class DeleteItem {

	private String item;

	public DeleteItem(String item) {
		super();
		this.item = item;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "DeleteItem [item=" + item + "]";
	}
	
	
}
