package cc.chauncy.hoi4.common;

/**
 * 小区块建筑，每个小区块里的建筑
 * Created by Chauncy on 2017/5/7.
 */
public class ProvinceBuilding {
	private int state_id;
	private int naval_base;//海军基地
	private int bunker;//陆上要塞
	private int coastal_bunker;//海岸要塞

	public ProvinceBuilding(int state_id) {
		this.state_id = state_id;
	}

	@Override
	public String toString() {
		return state_id + " = {\n" +
				"naval_base = " + naval_base + "\n" +
				"bunker = " + bunker + "\n" +
				"coastal_bunker = " + coastal_bunker + "\n" +
				"}\n";
	}

	public int getNaval_base() {
		return naval_base;
	}

	public void setNaval_base(int naval_base) {
		this.naval_base = naval_base;
	}

	public int getBunker() {
		return bunker;
	}

	public void setBunker(int bunker) {
		this.bunker = bunker;
	}

	public int getCoastal_bunker() {
		return coastal_bunker;
	}

	public void setCoastal_bunker(int coastal_bunker) {
		this.coastal_bunker = coastal_bunker;
	}
}
