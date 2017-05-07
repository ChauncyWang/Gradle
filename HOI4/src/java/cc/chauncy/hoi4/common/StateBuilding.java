package cc.chauncy.hoi4.common;

/**
 * state建筑,每种建筑有自己独立的数量限制
 * Created by Chauncy on 2017/5/7.
 */
public class StateBuilding {
	private int infrastructure;//基础设施
	private int air_base;//空军基地
	private int anti_air_building;//防空火炮
	private int radar_station;//雷达站

	public StateBuilding() {
	}

	@Override
	public String toString() {
		return "infrastructure = " + infrastructure + "\n" +
				"air_base = " + air_base + "\n" +
				"anti_air_building = " + anti_air_building + "\n" +
				"radar_station = " + radar_station + "\n";
	}

	public int getInfrastructure() {
		return infrastructure;
	}

	public void setInfrastructure(int infrastructure) {
		this.infrastructure = infrastructure;
	}

	public int getAir_base() {
		return air_base;
	}

	public void setAir_base(int air_base) {
		this.air_base = air_base;
	}

	public int getAnti_air_building() {
		return anti_air_building;
	}

	public void setAnti_air_building(int anti_air_building) {
		this.anti_air_building = anti_air_building;
	}

	public int getRadar_station() {
		return radar_station;
	}

	public void setRadar_station(int radar_station) {
		this.radar_station = radar_station;
	}
}
