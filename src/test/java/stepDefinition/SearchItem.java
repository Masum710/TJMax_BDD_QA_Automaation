package stepDefinition;

public class SearchItem {

	private String item;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public SearchItem(String item) {
		super();
		this.item = item;
	}

	@Override
	public String toString() {
		return "SearchItem [item=" + item + "]";
	}
	
	
}
