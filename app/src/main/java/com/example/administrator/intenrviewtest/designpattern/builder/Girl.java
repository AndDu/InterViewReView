package com.example.administrator.intenrviewtest.designpattern.builder;

public class Girl {

    private String cloth;
    private String hair;
    private String brow;
    private String face;
    private String eye;
    private String leg;

    public Girl(Builder builder) {
        cloth = builder.cloth==null?"":builder.cloth;
        hair = builder.hair;
        brow = builder.brow;
        face = builder.face;
        eye = builder.eye;
        leg = builder.leg;
    }

    public String getCloth() {
        return cloth;
    }

    public void setCloth(String cloth) {
        this.cloth = cloth;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getBrow() {
        return brow;
    }

    public void setBrow(String brow) {
        this.brow = brow;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }


   public static class Builder {

        private String cloth;
        private String hair;
        private String brow;
        private String face;
        private String eye;
        private String leg;


        public Builder setCloth(String cloth) {
            this.cloth = cloth;
            return this;
        }

        public Builder setHair(String hair) {
            this.hair = hair;
            return this;
        }

        public Builder setBrow(String brow) {
            this.brow = brow;
            return this;
        }

        public Builder setFace(String face) {
            this.face = face;
            return this;
        }

        public Builder setEye(String eye) {
            this.eye = eye;
            return this;
        }

        public Builder setLeg(String leg) {
            this.leg = leg;
            return this;
        }

        public Girl build() {
            return new Girl(this);
        }
    }


    public static void main(){
        Girl girl = new Girl. Builder()
                .setBrow("C")
                .setCloth("")
                .setEye("")
                .setFace("脸长腿长腿比脸长")
                .setHair("")
                .setLeg("脸长腿长腿比脸长")
                .build();

    }

}
