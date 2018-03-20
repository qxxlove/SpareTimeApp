package com.tjbool.httpwww.sparetimeapp.entity;

import java.io.Serializable;
import java.util.List;

/** 
 * description: 故障工单未完成实体类
 * autour: TMM
 * date: 2018/2/28 11:40 
 * update: 2018/2/28
 * version: 
*/

public class FaultUCompleteEntity extends  BaseEntity {


    /**
     * IsSuccess : true
     * Messagecode : 成功
     * JSON : [{"keyid":"2","carnumber":"CDK6850CBEV5-009","cartypenum":"6850CBEV5","cartype":"纯电动客车","Dep":"成都客车样车管理","Vehicletype":"城市公交车","faultName":"单体电池过压报警","sysCode":"","faultLevel":"3","faultType":"1","ctime":"2018/2/6 11:04:35","processStatus":"3"},{"keyid":"3","carnumber":"170095","cartypenum":"CDK6850CEHEV","cartype":"混合电动客车","Dep":"泸州市公共交通有限公司","Vehicletype":"城市公交车","faultName":"单体电池过压报警","sysCode":"","faultLevel":"1","faultType":"1","ctime":"2018/2/6 11:49:44","processStatus":"2"},{"keyid":"19","carnumber":"170158","cartypenum":"CDK6850CBEV6","cartype":"纯电动客车","Dep":"四川广运集团股份有限公司","Vehicletype":"城市公交车","faultName":"单体电池过压报警","sysCode":"","faultLevel":"1","faultType":"1","ctime":"2018/2/6 14:21:57","processStatus":"2"},{"keyid":"21","carnumber":"170101","cartypenum":"CDK6850CEHEV","cartype":"混合电动客车","Dep":"泸州市公共交通有限公司","Vehicletype":"城市公交车","faultName":"单体电池过压报警","sysCode":"","faultLevel":"2","faultType":"1","ctime":"2018/2/6 13:27:00","processStatus":"2"},{"keyid":"22","carnumber":"170093","cartypenum":"CDK6850CEHEV","cartype":"混合电动客车","Dep":"泸州市公共交通有限公司","Vehicletype":"城市公交车","faultName":"自定义故障1","sysCode":"","faultLevel":"2","faultType":"0","ctime":"2018/2/6 13:27:00","processStatus":"2"},{"keyid":"23","carnumber":"170103","cartypenum":"CDK6850CEHEV","cartype":"混合电动客车","Dep":"泸州市公共交通有限公司","Vehicletype":"城市公交车","faultName":"单体电池过压报警","sysCode":"","faultLevel":"2","faultType":"1","ctime":"2018/2/6 13:27:00","processStatus":"2"},{"keyid":"24","carnumber":"170104","cartypenum":"CDK6850CEHEV","cartype":"混合电动客车","Dep":"泸州市公共交通有限公司","Vehicletype":"城市公交车","faultName":"单体电池过压报警","sysCode":"","faultLevel":"2","faultType":"1","ctime":"2018/2/6 13:27:00","processStatus":"2"},{"keyid":"25","carnumber":"170107","cartypenum":"CDK6850CEHEV","cartype":"混合电动客车","Dep":"泸州市公共交通有限公司","Vehicletype":"城市公交车","faultName":"单体电池过压报警","sysCode":"","faultLevel":"2","faultType":"1","ctime":"2018/2/6 13:27:00","processStatus":"2"},{"keyid":"26","carnumber":"170096","cartypenum":"CDK6850CEHEV","cartype":"混合电动客车","Dep":"泸州市公共交通有限公司","Vehicletype":"城市公交车","faultName":"单体电池过压报警","sysCode":"","faultLevel":"3","faultType":"1","ctime":"2018/2/6 13:27:00","processStatus":"2"},{"keyid":"27","carnumber":"170099","cartypenum":"CDK6850CEHEV","cartype":"混合电动客车","Dep":"泸州市公共交通有限公司","Vehicletype":"城市公交车","faultName":"自定义故障1","sysCode":"","faultLevel":"1","faultType":"0","ctime":"2018/2/6 13:27:00","processStatus":"2"}]
     */

    private boolean IsSuccess;
    private String Messagecode;
    private List<JSONBean> JSON;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public String getMessagecode() {
        return Messagecode;
    }

    public void setMessagecode(String Messagecode) {
        this.Messagecode = Messagecode;
    }

    public List<JSONBean> getJSON() {
        return JSON;
    }

    public void setJSON(List<JSONBean> JSON) {
        this.JSON = JSON;
    }

    public static class JSONBean implements Serializable {
        /**
         * keyid : 2
         * carnumber : CDK6850CBEV5-009
         * cartypenum : 6850CBEV5
         * cartype : 纯电动客车
         * Dep : 成都客车样车管理
         * Vehicletype : 城市公交车
         * faultName : 单体电池过压报警
         * sysCode :
         * faultLevel : 3
         * faultType : 1
         * ctime : 2018/2/6 11:04:35
         * processStatus : 3
         */

        private String keyid;
        private String carnumber;
        private String cartypenum;
        private String cartype;
        private String Dep;
        private String Vehicletype;
        private String faultName;
        private String sysCode;
        private String faultLevel;
        private String faultType;
        private String ctime;
        private String processStatus;

        public String getKeyid() {
            return keyid;
        }

        public void setKeyid(String keyid) {
            this.keyid = keyid;
        }

        public String getCarnumber() {
            return carnumber;
        }

        public void setCarnumber(String carnumber) {
            this.carnumber = carnumber;
        }

        public String getCartypenum() {
            return cartypenum;
        }

        public void setCartypenum(String cartypenum) {
            this.cartypenum = cartypenum;
        }

        public String getCartype() {
            return cartype;
        }

        public void setCartype(String cartype) {
            this.cartype = cartype;
        }

        public String getDep() {
            return Dep;
        }

        public void setDep(String Dep) {
            this.Dep = Dep;
        }

        public String getVehicletype() {
            return Vehicletype;
        }

        public void setVehicletype(String Vehicletype) {
            this.Vehicletype = Vehicletype;
        }

        public String getFaultName() {
            return faultName;
        }

        public void setFaultName(String faultName) {
            this.faultName = faultName;
        }

        public String getSysCode() {
            return sysCode;
        }

        public void setSysCode(String sysCode) {
            this.sysCode = sysCode;
        }

        public String getFaultLevel() {
            return faultLevel;
        }

        public void setFaultLevel(String faultLevel) {
            this.faultLevel = faultLevel;
        }

        public String getFaultType() {
            return faultType;
        }

        public void setFaultType(String faultType) {
            this.faultType = faultType;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getProcessStatus() {
            return processStatus;
        }

        public void setProcessStatus(String processStatus) {
            this.processStatus = processStatus;
        }
    }
}
