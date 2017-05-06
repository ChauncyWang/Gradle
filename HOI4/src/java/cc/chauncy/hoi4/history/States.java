package cc.chauncy.hoi4.history;

/**
 * 地区
 * Created by Chauncy on 2017/5/5.
 */
public class States {
	private int id;//地区代码
	private String name;//地区名称
	private int manpower;//地区的人口
	private Resources resources;//地区的资源
	private StateCategory state_category;//地区类型
	private String victory_points;//地区的胜利点数

	public States(int id) {
		this.id = id;
		resources = new Resources();
		state_category = StateCategory.city;
	}

	@Override
	public String toString() {
		return "States".toLowerCase() + " = {\n" +
				"id = " + id + "\n" +
				"name = " + name + "\n" +
				"manpower = " + manpower + "\n" +
				"resources = " + resources + "\n" +
				"state_category = " + state_category + "\n" +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManpower() {
		return manpower;
	}

	public void setManpower(int manpower) {
		this.manpower = manpower;
	}

	public Resources getResources() {
		return resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}
}

/**
 * 地区类型 可以增加最大建筑槽
 */
enum StateCategory {
	city("city"),//城市 6个
	large_city("large_city"),//大城市 8个
	large_town("large_town"),//大城镇 5个
	megalopolis("megalopolis"),//巨大都市 12个
	metropolis("metropolis"),//大都市 10个
	pastoral("pastoral"),//乡村 1个
	rural("rural"),//农村 2个
	small_island("small_island"),//小岛 1个
	town("town"),//城镇 0个
	wasteland("wasteland"),//荒漠 4个
	enclave("enclave");//飞地 0个
	private String state;

	StateCategory(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return state;
	}
}