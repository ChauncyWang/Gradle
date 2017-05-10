package cc.chauncy.hoi4.history;

import cc.chauncy.hoi4.common.Building;
import cc.chauncy.hoi4.common.Resources;

import java.util.Map;

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
	private Map<Integer,Integer> victory_points;//地区的胜利点数
	private String owner;//地区归属
	private String[] add_core_of;//对该地宣称为核心
	private Building buildings;//地区建筑
	private int[] provinces;//小区块id

	public States(int id) {
		this.id = id;
		resources = new Resources();
		state_category = StateCategory.city;
	}

	@Override
	public String toString() {
		String str = "states = {\n" +
				"id = " + id + " \n" +
				"name = " + name + " \n" +
				"manpower = " + manpower + " \n" +
				"resources = " + resources + " \n" +
				"state_category = " + state_category + " \n" +
				"victory_points = " + victory_points + " \n" +
				"owner = " + owner + " \n" +
				"add_core_of = " + add_core_of + " \n" +
				"buildings = " + buildings + " \n" +
				"provinces = {\n";
		for (int i:provinces) {
			str +=" " + i + " ";
		}
		str += "}\n}\n";
		return str;
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

	public StateCategory getState_category() {
		return state_category;
	}

	public void setState_category(StateCategory state_category) {
		this.state_category = state_category;
	}

	public Map<Integer, Integer> getVictory_points() {
		return victory_points;
	}

	public void setVictory_points(Map<Integer, Integer> victory_points) {
		this.victory_points = victory_points;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String[] getAdd_core_of() {
		return add_core_of;
	}

	public void setAdd_core_of(String[] add_core_of) {
		this.add_core_of = add_core_of;
	}

	public Building getBuildings() {
		return buildings;
	}

	public void setBuildings(Building buildings) {
		this.buildings = buildings;
	}

	public int[] getProvinces() {
		return provinces;
	}

	public void setProvinces(int[] provinces) {
		this.provinces = provinces;
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