package po;

public class Comment {
    private int albumId;
    private String comment;
    private String userName;

    public Comment(int albumId, String comment, String userName) {
        this.albumId = albumId;
        this.comment = comment;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Comment(){

    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "albumId=" + albumId +
                ", comment='" + comment + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
