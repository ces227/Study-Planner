package vo;

public class StudentVO {
	private int seq;			//���̺� ���� ���� primarykey
	private String id;			//����� id
	private String password;	//����� ��й�ȣ
	private String name;		//����� �̸�
	private String lev;			//����� ���� ��ġ(�߰��,���л�,���û�)
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	@Override
	public String toString() {
		return "StudentVO [seq=" + seq + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", lev=" + lev + "]";
	}
}
