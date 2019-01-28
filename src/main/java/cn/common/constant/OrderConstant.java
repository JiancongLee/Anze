package cn.common.constant;

/**
 * 数据库排序
 *
 * @author jianconglee
 */
public enum OrderConstant {

    ASC("asc"), DESC("desc");

    private String des;

    OrderConstant(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
