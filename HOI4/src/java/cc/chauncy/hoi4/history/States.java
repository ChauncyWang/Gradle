package cc.chauncy.hoi4.history;

import cc.chauncy.hoi4.common.Building;
import cc.chauncy.hoi4.common.Resources;

import java.util.HashMap;
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
    private Map<Integer, Float> victory_points;//地区的胜利点数
    private String owner;//地区归属
    private String[] add_core_of;//对该地宣称为核心
    private Building buildings;//地区建筑
    private int[] provinces;//小区块id

    public States(int id) {
        this.id = id;
        victory_points = new HashMap<>();
        add_core_of = new String[0];
    }

    @Override
    public String toString() {
        String str = "states = {\n" +
                "id = " + id + " \n";
        if (name != null) {
            str += "name = " + name + " \n";
        }
        str += "manpower = " + manpower + " \n";
        if (resources != null) {
            str += "resources = " + resources + " \n";
        }
        if (state_category != null) {
            str += "state_category = " + state_category + " \n";
        }
        for (Map.Entry<Integer, Float> entry : victory_points.entrySet()) {
            str += "victory_points = {" + entry.getKey() + " " + entry.getValue() + " }\n";
        }
        if (owner != null) {
            str += "owner = " + owner + " \n";
        }
        for (String s : add_core_of) {
            str += "add_core_of = " + s + " \n";
        }
        if (buildings != null) {
            str += "buildings = " + buildings + " \n";
        }
        str += "provinces = {\n";
        for (int i : provinces) {
            str += " " + i + " ";
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

    public Map<Integer, Float> getVictory_points() {
        return victory_points;
    }

    public void setVictory_points(Map<Integer, Float> victory_points) {
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

