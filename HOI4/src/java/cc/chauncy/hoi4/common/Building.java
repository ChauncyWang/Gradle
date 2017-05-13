package cc.chauncy.hoi4.common;

import java.util.Vector;

/**
 * 地区建筑
 * Created by Chauncy on 2017/5/7.
 */
public class Building {
	private StateBuilding stateBuilding = new StateBuilding();//地区建筑
	private SharedBuilding sharedBuilding = new SharedBuilding();//共享的建筑
	private Vector<ProvinceBuilding> provinceBuilds = new Vector<>();//特殊区块建筑

	public Building() {
	}

	@Override
	public String toString() {
		String str = "building = {\n" +
				stateBuilding + "\n" +
				sharedBuilding + "\n";
		for(ProvinceBuilding provinceBuild:provinceBuilds){
			str += provinceBuild;
		}

		str += "}\n";
		return str;
	}

	public void addProvinceBuilding(ProvinceBuilding provinceBuild) {
		provinceBuilds.add(provinceBuild);
	}

	public StateBuilding getStateBuilding() {
		return stateBuilding;
	}

	public void setStateBuilding(StateBuilding stateBuilding) {
		this.stateBuilding = stateBuilding;
	}

	public SharedBuilding getSharedBuilding() {
		return sharedBuilding;
	}

	public void setSharedBuilding(SharedBuilding sharedBuilding) {
		this.sharedBuilding = sharedBuilding;
	}
}
