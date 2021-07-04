package dahua;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {

    class ShootCar{
        private int adrId;
        private String carNum;
        private Date shootTime;

        public int getAdrId() {
            return adrId;
        }

        public void setAdrId(int adrId) {
            this.adrId = adrId;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public Date getShootTime() {
            return shootTime;
        }

        public void setShootTime(Date shootTime) {
            this.shootTime = shootTime;
        }
    }
    public float getAvgTravel(int beginAddress, int endAddress, List<ShootCar> shootCars){
        // key:carNum  value:timestamp
        Map<String,Long> beginMap = new HashMap<>();
        Map<String,Long> endMap = new HashMap<>();
        // 构建map
        for(ShootCar shootCar : shootCars){
            if(shootCar.getAdrId() == beginAddress){
                beginMap.put(shootCar.getCarNum() , shootCar.getShootTime().getTime());
            }else if(shootCar.getAdrId() == endAddress){
                endMap.put(shootCar.getCarNum() , shootCar.getShootTime().getTime());
            }
        }
        int carSum = 0;
        float totalTime = 0;
        for(String carNum : beginMap.keySet()){
            Long beginTime = beginMap.get(carNum);
            Long endTime = endMap.get(carNum);
            if(beginTime != null & endTime != null){
                carSum++;
                totalTime += (float)(endTime - beginTime) / 60000;
            }
        }
        return totalTime / carSum;
    }

}
