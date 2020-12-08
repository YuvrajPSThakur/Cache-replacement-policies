/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Yuvraj
 */
public class CacheEmulation15116076 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
     Scanner ss = new Scanner(System.in); 
     System.out.println("Enter file name in the format of name_POLICY_cachesize Note policy should be in CAPS ");
     String filename = ss.nextLine();
     String[] naming = filename.split("_",3);
        File file = new File(filename + ".txt");
     Scanner scan = new Scanner(file);            
     String trail = "";
      
    
    ArrayList memory = new ArrayList();
    
    
    
    ArrayList  cache =  new ArrayList<>();
    int hit = 0;    
    int miss = 0;
    int complmiss = 0;
    boolean flag = true;
    int capacity = 0;
//    System.out.println(cache);
//    int a [] = new int [40000]; 
    while (scan.hasNext()){
      memory.add(scan.next());
      
    }
//    System.out.println("Add the cache size : ");
    
    int cachesize = Integer.parseInt(naming[2]);
    
    
    
    if("LRU".equals(naming[1])){
    for (int j =0;j<memory.size();j++){
         for(int c=0;c<j;c++){
    if(memory.get(c).toString() == null ? memory.get(j).toString() == null : memory.get(c).toString().equals(memory.get(j).toString())){
       flag = false;
    }
    
        
    }
         //System.out.println(flag);
    
    if(flag){complmiss++;
    
    }
     
    if (cache.contains(memory.get(j))){
     
     hit ++ ;
     //System.out.println("HIT");
     trail = trail + "\n" + "HIT" ;
     
     int currentsize = cache.size();
     for (int i =0;i<currentsize;i++){
         
         if(cache.get(i).toString() == null ? memory.get(j).toString() == null : cache.get(i).toString().equals(memory.get(j).toString())){
                       
             cache.remove(i);
         break;
         }
         
        
        
    }
     cache.add(memory.get(j));
     //System.out.println(cache);
    }
    else {
    
    miss ++;
 
  
    
    if (cache.size()>=cachesize){
    cache.remove(0);
//    capacitymiss ++ ;
    }
    cache.add(memory.get(j));
    //System.out.println("MISS");
    trail = trail + "\n" + "MISS" ;
//    System.out.println(cache);
    }
    
     flag = true;
    }
     capacity = miss - complmiss;
      
    
        try (FileWriter Lru = new FileWriter("15116076_" + naming[1] +"_" +  naming[0] + "_" + naming[2] + ".txt")) {
            String lru= "TOTAL_ACCESSES  = " + Integer.toString(memory.size()) + "\n" +
                    "TOTAL_HIT  = " + Integer.toString(hit) + "\n" + "TOTAL_MISS = " + Integer.toString(miss)
                    + "\n" + "CAPACITY_MISS  = " + Integer.toString(capacity) + "\n" + "COMPULSORY_MISS  = " + Integer.toString(complmiss)+ trail
                    ;
            Lru.write(
                    lru
            );  }
    }
    
    //FIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFI
    //FIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFO
    //FIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFOFIFO
    if("FIFO".equals(naming[1])){
    for (int j =0;j<memory.size();j++){
         for(int c=0;c<j;c++){
    if(memory.get(c).toString() == null ? memory.get(j).toString() == null : memory.get(c).toString().equals(memory.get(j).toString())){
       flag = false;
    }
    
        
    }
//         System.out.println(flag);
    
    if(flag){complmiss++;
    
    }
     
    if (cache.contains(memory.get(j))){
     
     hit ++ ;
     System.out.println("HIT");
     trail = trail + "\n" + "HIT" ;
     

    }
    else {
    
    miss ++;
    
    
 
  
    
    if (cache.size()>=cachesize){
    cache.remove(0);
//    capacitymiss ++ ;
    }
    cache.add(memory.get(j));
    System.out.println("MISS");
    trail = trail + "\n" + "MISS" ;
//    System.out.println(cache);
    }
    
     flag = true;
    }
     capacity = miss - complmiss;
    
    //System.out.println("TOTAL_ACCESSES  = " + memory.size());
    //System.out.println("TOTAL_HIT  = " + hit);
    //System.out.println("TOTAL_MISS  = " +miss);
    //System.out.println("COMPULSORY_MISS  = " + complmiss);
    //System.out.println("CAPCITY_MISS  = " + capacity);
    
        try (FileWriter Lru = new FileWriter("15116076_" + naming[1] +"_" +  naming[0] + "_" + naming[2] + ".txt")) {
            String lru= "TOTAL_ACCESSES  = " + Integer.toString(memory.size()) + "\n" +
                    "TOTAL_HIT  = " + Integer.toString(hit) + "\n" + "TOTAL_MISS = " + Integer.toString(miss)
                    + "\n" + "CAPACITY_MISS  = " + Integer.toString(capacity) + "\n" + "COMPULSORY_MISS  = " + Integer.toString(complmiss)+ trail
                    ;
            Lru.write(
                    lru
            );  }
    }
    
    //OPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMAL
    //OPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMALOPTIMAL
    if("OPTIMAL".equals(naming[1])){
    for (int j =0;j<memory.size();j++){
          for(int c=0;c<j;c++){
    if(memory.get(c).toString() == null ? memory.get(j).toString() == null : memory.get(c).toString().equals(memory.get(j).toString())){
       flag = false;
    }
    
        
    }
//         System.out.println(flag);
    
    if(flag){complmiss++;
    
    }
     
    if (cache.contains(memory.get(j))){
     
     hit ++ ;
//     System.out.println("HIT");
     trail = trail + "\n" + "HIT" ;    
   
//     System.out.println(cache);
    }
    else {
    trail = trail + "\n" + "MISS" ;
    miss ++;
    if(cache.size()>=cachesize){
        int trash = 0;
        int farthest = 0;
        boolean indicator = true;
        for(int c =0;c<cache.size();c++){
        for(int g=j;g<memory.size();g++){
            if(cache.get(c).toString() == null ? memory.get(g).toString() == null : cache.get(c).toString().equals(memory.get(g).toString())){
            indicator = false;
            if(g>farthest){
            farthest = g;
            trash = c;
            }
            break;
            }
        }
        if(indicator){
        trash = c;
        farthest = memory.size();
                
                }
        indicator = true;
        
        }
        cache.remove(trash);
    }
    cache.add(memory.get(j));
//    System.out.println(cache);
    }
  
    
     flag = true;
    }
     capacity = miss - complmiss;
      
    
        try (FileWriter Lru = new FileWriter("15116076_" + naming[1] +"_" +  naming[0] + "_" + naming[2] + ".txt")) {
            String lru= "TOTAL_ACCESSES  = " + Integer.toString(memory.size()) + "\n" +
                    "TOTAL_HIT  = " + Integer.toString(hit) + "\n" + "TOTAL_MISS = " + Integer.toString(miss)
                    + "\n" + "CAPACITY_MISS  = " + Integer.toString(capacity) + "\n" + "COMPULSORY_MISS  = " + Integer.toString(complmiss)+ trail
                    ;
            Lru.write(
                    lru
            );  }
    }
     
    
  
    
    }
    
 
    
}
