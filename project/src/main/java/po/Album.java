package po;

public class Album {

	private int userid;
	private String name;
	
	public Album() {
	}
	public Album(int userid, String name){

		this.userid=userid;
		this.name=name;
	}
	public void setAlbumInfo(int userid, String name){

		this.userid=userid;
		this.name=name;
	}
	
	@Override
	public String toString() {
		 return "Album{" +
	                "userid='" + userid + '\'' +
	                ", name='" + name + '\'' +
	                '}';
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
