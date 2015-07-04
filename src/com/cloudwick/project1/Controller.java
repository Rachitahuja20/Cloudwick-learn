//package com.cloudwick.project1;
//
//import java.util.HashMap;
//
///**
// * Created by ahuja on 4/5/15.
// */
//public class Controller {
//
//    public static void main(String[] args) throws Exception {
//        //HashMap<String,WordDto> hm1= new HashMap<String, WordDto>();
//
//        ReadAndCountWord file = new ReadAndCountWord();
//
//        HashMap<String, WordDto> hm1 = file.ReadFile("/Users/ahuja/Desktop/Rachit.txt");
//
//        WriteReadXML Xm = new WriteReadXML();
//
//        Xm.Write(hm1,"dom");
//       // Xm.Write(hm1,"serialization");
//
//        Xm.ReadXML();
//
//        ReadWriteJSON Rj= new ReadWriteJSON();
//        Rj.WriteJson(hm1);
//        Rj.ReadJson();
//
//
//    }
//}
