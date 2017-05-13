package cc.chauncy.hoi4

import cc.chauncy.hoi4.common.Building
import cc.chauncy.hoi4.common.Resources
import cc.chauncy.hoi4.history.StateCategory
import cc.chauncy.hoi4.history.States

/**
 * 对HOI4的配置文件进行解析
 * Created by 13969 on 2017/5/8.
 */
class HOI4Parse {

    /**
     * 从字符串中解析出States
     * @param str 要解析的字符串
     * @return 解析出的States对象
     */
    static def parseState(str) {
        // id
        def id = ~/id\W*=\W*(\w*)/
        id = (str =~ id)[0][1]
        // new
        def state
        state = new States(id as int)
        // name
        def name = str=~/name\W*=\W*(\w*)/
        name = name?name[0][1]:null
        // manpower
        def manpower = str=~/manpower\W*=\W*(\w*)/
        manpower = manpower?manpower[0][1] as int:0
        // resources
        def resources = ~/resources\W*=\W*\{\W*(.*?)\W*}/
        resources = (str =~ resources)
        resources = parseResources(resources?resources[0][1]:null)
        // state category
        def state_category = str =~/state_category\W*=\W*(\w*)/
        state_category = state_category?state_category[0][1]:StateCategory.city
        // victory_points
        def victory_points = str=~/victory_points\W*=\W*\{\W*(.*?)\W*}/
        victory_points = parseVictoryPoints(victory_points)
        // owner
        def owner = str =~/owner\W*=\W*(\w*)/
        owner = owner[0][1]
        // add_core_of
        def add_core_of = str =~/add_core_of\W*=\W*(\w*)/

        // province
        def provinces = ~/provinces\W*=\W*\{\W*(.*?)\W*}/
        provinces = (str =~ provinces)[0][1]
        provinces = parseProvinces(provinces)
        // set state properties
        state.setName(name)
        state.setManpower(manpower)
        state.setResources(resources)
        state.setState_category(state_category as StateCategory)
        state.setVictory_points(victory_points)
        state.setOwner(owner)
        state.setProvinces(provinces as int[])
        println(state)
        parseBuildings(str)
    }
    /** 解析buildings
     *
     * @param str
     */
    static def parseBuildings(str) {
        def buildings = new Building()
        println(buildings)
    }
    static def parseProvinceBuilding(str) {

    }
    static def parseSharedBuilding(str) {

    }
    static def parseStateBuilding(str) {

    }

    /**
     * 从match数组中解析出victory_points
     * @param victory_points 胜利点数的match数组
     * @return 胜利点数map
     */
    static def parseVictoryPoints(victory_points) {
        def points = [:]
        victory_points.each {
            def list = it[1].split(" ")
            points.put(list[0] as int ,list[1] as float)
        }
        return points
    }

    /**
     * 从字符串中解析出Resources
     * @param str 要解析的字符串
     * @return 解析出的Resources对象
     */
    static def parseResources(str) {
        //解析资源
        def oil = ~/oil\W*=\W*(\w*)/
        oil = (str =~ oil)
        oil = oil ? oil[0][1] as int : 0
        def steel = ~/steel\W*=\W*(\w*)/
        steel = (str =~ steel)
        steel = steel ? steel[0][1] as int : 0
        def aluminum = ~/aluminum\W*=\W*(\w*)/
        aluminum = (str =~ aluminum)
        aluminum = aluminum ? aluminum[0][1] as int : 0
        def tungsten = ~/tungsten\W*=\W*(\w*)/
        tungsten = (str =~ tungsten)
        tungsten = tungsten ? tungsten[0][1] as int : 0
        def chromium = ~/chromium\W*=\W*(\w*)/
        chromium = (str =~ chromium)
        chromium = chromium ? chromium[0][1] as int : 0
        def rubber = ~/rubber\W*=\W*(\w*)/
        rubber = (str =~ rubber)
        rubber = rubber ? rubber[0][1] as int : 0
        //设置资源参数
        def resources = new Resources()
        resources.setOil(oil)
        resources.setAluminum(aluminum)
        resources.setChromium(chromium)
        resources.setRubber(rubber)
        resources.setSteel(steel)
        resources.setTungsten(tungsten)

        return resources
    }
    /**
     * 从字符串中解析出Provinces
     * @param str 要解析的字符串
     * @return 解析出的Provinces对象
     */
    static def parseProvinces(str) {
        def strs = str.split(" ")
        def size = strs.size()
        def ints = new int[size]
        for (i in 0..size - 1) {
            ints[i] = Integer.valueOf(strs[i])
        }
        return ints
    }
}
