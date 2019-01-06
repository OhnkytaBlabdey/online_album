package po;

public class Album {

	private String name;
	private int userid;
	
	public Album() {
	}
	public Album(int userid, String name){

		this.userid=userid;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public int getUserid() {
		return userid;
	}


	public void setAlbumInfo(int userid, String name){

		this.userid=userid;
		this.name=name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		 return "Album{" +
	                "userid='" + userid + '\'' +
	                ", name='" + name + '\'' +
	                '}';
	}

}
