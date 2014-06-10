package bean;

public class userBean {
	private String userName;
	private String passWord;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public boolean login(String login, String passwd) {
		if(userName.equals(login) && passWord.equals(passwd) ){
			return true;
		}
		else
			return false;
	}
}
