package csb.appdevt.midtermexam;

import java.util.*;
public class sample {
    static void method_Welcome(){
        System.out.println("\t\t\t\t\t\t\tWelcome to TECHFIXED!"); 
    }
    static void method_Lines(){
        System.out.println("________________________________________________________________________________________________________________");
    }   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      
        //AMD PROCESSOR ARRAY
        int [] cpuItemno_Ryzen = {1,2,3,4,5,6,7,8,9,10};
        String [] cpuName_Ryzen = {"Ryzen 3 3200G", "Ryzen 3 3100", "Ryzen 3 3300X", "Ryzen 5 3400G", "Ryzen 5 3600", 
        "Ryzen 5 3600X", "Ryzen 5 3600XT", "Ryzen 7 3700X", "Ryzen 7 3800X", "Ryzen 7 3800XT"};
        String [] cpuCorecount_Ryzen = {"4", "\t4", "4", "4", "\t6", "6", "6", "8", "8", "8"};
        String [] cpuCoreclock_Ryzen = {"3.6GHz", "3.6GHz", "3.8GHz", "3.7GHz", "3.6GHz", "3.8GHz", 
        "3.8GHz", "3.6GHz", "3.9GHz", "3.9GHz"};
        String [] cpuBoostclock_Ryzen = {"4GHz", "3.9GHz", "4.3GHz", "4.2GHz", "4.2GHz", "4.4GHz", 
        "4.5GHz", "4.4GHz", "4.5GHz", "4.7GHz"};
        String [] cpuTdp_Ryzen = {"65W", "65W", "65W", "65W", "65W", "95W", "95W", "105W", "105W", "105W"};
        String [] cpuIntegratedgraphics_Ryzen = {"Radeon Vega 8", "None\t", "None\t", "Radeon Vega 11", "None\t", 
        "None\t", "None\t", "None\t", "None\t", "None\t"};
        int [] cpuPrice_Ryzen = {9100, 5900, 6400, 11000, 9700, 10000, 11600, 14300, 16500, 18300};
        //AMD PROCESSOR ARRAY
        //INTEL PROCESSOR ARRAY
        int [] cpuItemno_Intel = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};        
        String [] cpuName_Intel = {"Intel Core I3-10100", "Intel Core I3-10100F", "Intel Core I3-10300", "Intel Core I3-10320", "Intel Core I5-10400", 
        "Intel Core I5-10400F", "Intel Core I5-10500", "Intel Core I5-10600", "Intel Core I5-10600K", "Intel Core I5-10600KF", "Intel Core I5-10600KF", 
        "Intel Core I7-10700F", "Intel Core I7-10700K", "Intel Core I7-10700KF"};
        String [] cpuCorecount_Intel = {"\t4", "\t4", "\t4", "\t4", "\t6", "\t6", "\t6", "\t6", "\t6", "6", "8", "8", "8", "8",};
        String [] cpuCoreclock_Intel = {"3.6GHz", "3.6GHz", "3.7GHz", "3.8GHz", "2.9GHz", "2.9GHz", 
        "3.1GHz", "3.3GHz", "4.1GHz", "2.9GHz", "2.9GHz", "2.9GHz", "3.8GHz", "3.8GHz"};
        String [] cpuBoostclock_Intel = {"4.3GHz", "4.3GHz", "4.4GHz", "4.6GHz", "4.3GHz", "4.3GHz", 
        "4.5GHz", "4.8GHz", "4.8GHz", "4.9GHz", "4.8GHz", "4.8GHz", "5.1GHz", "5.1GHz"};
        String [] cpuTdp_Intel = {"65W", "65W", "65W", "65W", "65W", "65W", "65W", "65W", "125W", "125W", "65W", "65W", "125W", "125W"};
        String [] cpuIntegratedgraphics_Intel = {"Intel UHD Graphics 630", "None\t\t", "Intel UHD Graphics 630", "Intel UHD Graphics 630", "Intel UHD Graphics 630", 
        "None\t\t", "Intel UHD Graphics 630", "Intel UHD Graphics 630", "Intel UHD Graphics 630", "None\t\t", "Intel UHD Graphics 630", "None\t\t", 
        "Intel UHD Graphics 630", "None\t\t"};
        int [] cpuPrice_Intel = {5600, 5600, 8600, 9200, 8700, 9500, 8600, 12700, 13300, 13500, 15500, 21000, 18320, 25000};

        boolean valid = true;
        int choice_menu = 0;
        while(valid){
            //Choices
            System.out.println("                        1. PC by Parts");
            System.out.println("                        2. PC by Prebuilt");
            System.out.println("                        3. Laptop");
            System.out.println("                        4. Services");
            System.out.println("                        5. Exit");
            System.out.println();
            //Choice
            System.out.print("Enter choice [1-5]      : "); 
            choice_menu = input.nextInt();  
            if(0 < choice_menu && choice_menu < 6){
                valid = true;
                method_Lines();
                System.out.println();
                break;
            }
            else{
                System.out.println("Invalid input...");
                method_Lines();
                System.out.println();
            }
        }
        //PC by Parts
        int choiceProcessor = 0;
        switch(choice_menu){
            case 1:
            //displayProcessors displayCPU = new displayProcessors();
            System.out.println("PC by Parts:");
            System.out.println();
            System.out.println("I. Processor");
            System.out.println("II. Motherboard");
            System.out.println("III. RAM");
            System.out.println("IV. Graphics Card");
            System.out.println("V. Storage");
            System.out.println("VI. Power Supply");
            System.out.println("VII. Case");
            System.out.println();
            //Processor
            int choiceProcessormanufacturer = 0;   
            while(valid){
                System.out.println("I. Choose Processor manufacturer:");
                //Choices               
                System.out.println("1. AMD");
                System.out.println("2. Intel");
                System.out.println(); 
                //Choice
                System.out.print("Enter choice [1-2]: "); 
                choiceProcessormanufacturer = input.nextInt();  
                if(0 < choiceProcessormanufacturer && choiceProcessormanufacturer < 3){
                    valid = true;
                    method_Lines();
                    System.out.println();
                    break;
                }
                else{
                    System.out.println("Invalid input...");
                    method_Lines();
                    System.out.println();
                }
            }    
            switch(choiceProcessormanufacturer){
                case 1:
                    while(valid){
                        System.out.println("AMD Processors:");
                        System.out.println("Name\t\t\t\tCore Count\tCore Clock\tBoost Clock\tTDP\tIntegrated Graphics\tPrice");
                        for (int i=0; i<cpuName_Ryzen.length; i++){
                            System.out.println(cpuItemno_Ryzen[i]+". "+cpuName_Ryzen[i]+"\t\t"+cpuCorecount_Ryzen[i]+"\t\t"
                                +cpuCoreclock_Ryzen[i]+"\t\t"+cpuBoostclock_Ryzen[i]+"\t\t"+cpuTdp_Ryzen[i]+"\t"
                                +cpuIntegratedgraphics_Ryzen[i]+"\t\t"+"Php "+cpuPrice_Ryzen[i]);
                        }
                        System.out.println();
                        System.out.print("Choose an AMD Processor: ");
                        choiceProcessor = input.nextInt();
                        System.out.println();
                        for (int i=0; i<cpuItemno_Ryzen.length; i++){      
                            if(choiceProcessor == cpuItemno_Ryzen[i]){
                              System.out.println("Name\t\t\t\tCore Count\tCore Clock\tBoost Clock\tTDP\tIntegrated Graphics\tPrice");
                                System.out.println(cpuName_Ryzen[i]+"\t\t\t"+cpuCorecount_Ryzen[i]+"\t\t"+cpuCoreclock_Ryzen[i]+"\t\t"
                                    +cpuBoostclock_Ryzen[i]+"\t\t"+cpuTdp_Ryzen[i]+"\t"+cpuIntegratedgraphics_Ryzen[i]
                                    +"\t\t"+"Php "+cpuPrice_Ryzen[i]);
                            }
                        }    
                        if(0 < choiceProcessor && choiceProcessor < 11){
                            valid = true;
                            method_Lines();
                            System.out.println();
                            break;
                        }
                        else{
                            System.out.println("Invalid input...");
                            method_Lines();
                            System.out.println();
                        }
                    }                        
                    break;
                case 2:
                    while(valid){
                        System.out.println("Intel Processors:");
                        System.out.println("Name\t\t\t\t\tCore Count\tCore Clock\tBoost Clock\tTDP\tIntegrated Graphics\t\tPrice");
                        for (int i=0; i<cpuName_Intel.length; i++){
                            System.out.println(cpuItemno_Intel[i]+". "+cpuName_Intel[i]+"\t\t"+cpuCorecount_Intel[i]+"\t\t"
                                +cpuCoreclock_Intel[i]+"\t\t"+cpuBoostclock_Intel[i]+"\t\t"+cpuTdp_Intel[i]+"\t"
                                +cpuIntegratedgraphics_Intel[i]+"\t\t"+"Php "+cpuPrice_Intel[i]);
                        }
                        System.out.println();
                        System.out.print("Choose an Intel Processor: ");
                        choiceProcessor = input.nextInt();
                        System.out.println();
                        for (int i=0; i<cpuItemno_Intel.length; i++){      
                            if(choiceProcessor == cpuItemno_Intel[i]){
                              System.out.println("Name\t\t\t\t\tCore Count\tCore Clock\tBoost Clock\tTDP\tIntegrated Graphics\t\tPrice");
                                System.out.println(cpuName_Intel[i]+"\t\t"+cpuCorecount_Intel[i]+"\t\t"+cpuCoreclock_Intel[i]+"\t\t"
                                    +cpuBoostclock_Intel[i]+"\t\t"+cpuTdp_Intel[i]+"\t"+cpuIntegratedgraphics_Intel[i]
                                    +"\t\t"+"Php "+cpuPrice_Intel[i]);
                            }
                        }    
                        if(0 < choiceProcessor && choiceProcessor < 15){
                            valid = true;
                            method_Lines();
                            System.out.println();
                            break;
                        }
                        else{
                            System.out.println("Invalid input...");
                            method_Lines();
                            System.out.println();
                        }
                    }
                    break;
            }
            int choice_motherboard = 0;
            //Motherboard
                break;
        }

          
        }
    }
