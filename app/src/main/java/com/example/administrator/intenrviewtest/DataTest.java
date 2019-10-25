package com.example.administrator.intenrviewtest;



public class DataTest {

    /**
     * data_transform_0=0C89A5D5FF110100
     * data_transform_1=00010039ABCDEF12
     * data_transform_2=0BFC000800080008
     * data_transform_3=0BFC000800080008
     * data_transform_4=0BFC000800080008
     * data_transform_5=0BFC000800080008
     * data_transform_6=0BFC000800080008
     * data_transform_7=0BFC000800080008
     * data_transform_8=0BFC000800080008
     * data_transform_9=0BFC000800080008
     *
     * @param args
     */
    public static void main(String[] args) {

        //十六进制字符串转十进制
//        while (true){
//            Scanner in = new Scanner(System.in);
//            String hexString = in.nextLine();
//            long decvalue = Long.parseLong(hexString,16);
//            System.out.println(decvalue);
//        }

        String datas = "0C89A5D5FF11010000010039ABCDEF120BFC0008000800080BFC0008000800080BFC0008000800080BFC0008000800080BFC0008000800080BFC0008000800080BFC0008000800080BFC000800080008";

        try {
//            if(datas.startsWith("0C89A5D5FF110100")){
//                System.out.println("硬件识别码：" + datas.substring(0,16) +","+ hexStringtoByteArray(datas.substring(0,16)));
//                System.out.println("时间戳：" + datas.substring(16,32));
//                System.out.println("通道1：" + datas.substring(32,48));
//                System.out.println("通道2：" + datas.substring(48,64));
//                System.out.println("通道3：" + datas.substring(64,80));
//                System.out.println("通道4：" + datas.substring(80,96));
//                System.out.println("通道5：" + datas.substring(96,112));
//                System.out.println("通道6：" + datas.substring(112,128));
//                System.out.println("通道7：" + datas.substring(128,144));
//                System.out.println("通道8：" + datas.substring(144,160));
//            }else{
//                System.out.println("获取错误信息~");
//            }
            System.out.println("****************");

            String str1 = "0BFC000800090010";
//            System.out.println(str1);
//
//            int count = str1.length();
//            int sublength = count / 4;      //3
////            //1*4
//            System.out.println(str1.substring(sublength*0, sublength * 1));
//            //2*4
//            System.out.println(str1.substring(sublength*1, sublength * 2));
//            //3*4
//            System.out.println(str1.substring(sublength * 2,sublength * 3));
//            //4*4
//            System.out.println(str1.substring(sublength * 3,sublength * 4));

//            for (int i = 0;i <= sublength;i++){
//                System.out.println(str1.substring(sublength * i,sublength * i+1));
//            }

//


            int[] bytes = ConvertUtils.hexStringToByte4(str1);

            System.out.println(bytes);
            //
            for (int i = 0; i < bytes.length    ; i++) {
                System.out.println(bytes[i]);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static byte[] hexStringtoByteArray1(String hexString) {
        int len = (hexString.length() / 4);
        byte[] byteArray = new byte[len];
        char[] achar = hexString.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            byteArray[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return byteArray;
    }


    /**
     * 16进制的字符串表示转成字节数组
     *
     * @param hexString 16进制格式的字符串
     * @return 转换后的字节数组
     **/
    public static byte[] hexStringtoByteArray(String hexString) {

        int len = (hexString.length() / 2);
        byte[] byteArray = new byte[len];
        char[] achar = hexString.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            byteArray[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return byteArray;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }


}
