package web.login.entity;

public enum PassType {
	RED(5,30, 1), GREEN(3, 30,2);
	// 成员变量
	private int count;
	private int time;
	private int type;

	/**
	 * 获取最大错误次数
	 * @return
	 * @author gbq
	 * 2016年4月24日
	 */
	public static int getCount(int type) {
		for (PassType passType : PassType.values()) {
			if (passType.getType() == type) {
				return passType.count;
			}
		}
		return 0;
	}

	/**
	 * 获取失效间隔
	 * @return
	 * @author gbq
	 * 2016年4月24日
	 */
	public static Long getTime(int type) {
		for (PassType passType : PassType.values()) {
			if (passType.getType() == type) {
				Long time = new Long(passType.time);
				return time;
			}
		}
		return 0L;
	}

	private PassType(int count,int time,int index) {
		this.type = index;
		this.count = count;
		this.time = time;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
