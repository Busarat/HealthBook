package app.android.healthbook3.entry;

public class UserDBEntry {

	private int uid;
	private String name, surname, gender, bd, Btype, height, addr, hometel, relativetel;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBd() {
		return bd;
	}
	public void setBd(String bd) {
		this.bd = bd;
	}
	public String getBtype() {
		return Btype;
	}
	public void setBtype(String btype) {
		Btype = btype;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getHometel() {
		return hometel;
	}
	public void setHometel(String hometel) {
		this.hometel = hometel;
	}
	public String getRelativetel() {
		return relativetel;
	}
	public void setRelativetel(String relativetel) {
		this.relativetel = relativetel;
	}
	
}
