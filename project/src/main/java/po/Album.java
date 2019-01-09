package po;

import java.util.ArrayList;

public class Album {


	private int userid;
	private int id;
	private String name;
	private String userName;

	ArrayList<Photo> photos = new ArrayList<Photo>();

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "Album{" +
				"userid=" + userid +
				", id=" + id +
				", name='" + name + '\'' +
				", photos=" + photos +
				", userName='" + userName + '\'' +
				'}';
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Album() {
	}
	public Album(int id,int userid, String name){
		this.id = id;
		this.userid=userid;
		this.name=name;
	}
	public Album(int userid, String name){
		this.userid=userid;
		this.name=name;
	}

	public void setAlbumInfo(int userid, String name){
		this.userid=userid;
		this.name=name;
	}

	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Photo> photos) {
		this.photos = photos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		// TODO Auto-generated method stub
		return userid;
	}

}
