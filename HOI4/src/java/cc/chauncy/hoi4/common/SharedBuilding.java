package cc.chauncy.hoi4.common;

/**
 * 共享建筑，这些建筑的数量总和有限制
 * Created by Chauncy on 2017/5/7.
 */
public class SharedBuilding {
	private int industrial_complex;//民用工厂
	private int arms_factory;//军用工厂
	private int dockyard;//海军船坞
	private int synthetic_refinery;//合成炼油厂
	private int rocket_site;//火箭基地
	private int nuclear_reactor;//核反应堆

	public SharedBuilding() {
	}

	@Override
	public String toString() {
		return "industrial_complex = " + industrial_complex + "\n" +
				"arms_factory = " + arms_factory + "\n" +
				"dockyard = " + dockyard + "\n" +
				"synthetic_refinery = " + synthetic_refinery + "\n" +
				"rocket_site = " + rocket_site + "\n" +
				"nuclear_reactor = " + nuclear_reactor + "\n";
	}

	public int getIndustrial_complex() {
		return industrial_complex;
	}

	public void setIndustrial_complex(int industrial_complex) {
		this.industrial_complex = industrial_complex;
	}

	public int getArms_factory() {
		return arms_factory;
	}

	public void setArms_factory(int arms_factory) {
		this.arms_factory = arms_factory;
	}

	public int getDockyard() {
		return dockyard;
	}

	public void setDockyard(int dockyard) {
		this.dockyard = dockyard;
	}

	public int getSynthetic_refinery() {
		return synthetic_refinery;
	}

	public void setSynthetic_refinery(int synthetic_refinery) {
		this.synthetic_refinery = synthetic_refinery;
	}

	public int getRocket_site() {
		return rocket_site;
	}

	public void setRocket_site(int rocket_site) {
		this.rocket_site = rocket_site;
	}

	public int getNuclear_reactor() {
		return nuclear_reactor;
	}

	public void setNuclear_reactor(int nuclear_reactor) {
		this.nuclear_reactor = nuclear_reactor;
	}
}
