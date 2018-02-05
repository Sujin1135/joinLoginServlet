package spms.vo;

import java.util.Date;

public class Member {
	private String email;
	private String name;
	private String password;
	private String passwordCheck;
	private Date createDate;

	public String getEmail() {
		return email;
	}

	public Member setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getName() {
		return name;
	}

	public Member setName(String name) {
		this.name = name;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Member setPassword(String password) {
		this.password = password;
		return this;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Member setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public Member setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
		return this;
	}
	
	public int passwordCheck () { // 비밀번호와 비밀번호 확인이 같은지 체크한다.
		return this.password == this.passwordCheck ? 0 : 1;
	}
}
