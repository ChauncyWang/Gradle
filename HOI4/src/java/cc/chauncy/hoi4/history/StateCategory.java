package cc.chauncy.hoi4.history;

/**
 * 地区类型 可以增加最大建筑槽
 */
public enum StateCategory {
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