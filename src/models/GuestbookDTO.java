package models;

public class GuestbookDTO {
	private int number;
	private String guestBookName;
	private String guestBookContent;
	private String guestBookPassword;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getGuestBookName() {
		return guestBookName;
	}
	public void setGuestBookName(String guestBookName) {
		this.guestBookName = guestBookName;
	}
	public String getGuestBookContent() {
		return guestBookContent;
	}
	public void setGuestBookContent(String guestBookContent) {
		this.guestBookContent = guestBookContent;
	}
	public String getGuestBookPassword() {
		return guestBookPassword;
	}
	public void setGuestBookPassword(String guestBookPassword) {
		this.guestBookPassword = guestBookPassword;
	}
	
}
