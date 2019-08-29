package com.example.kuldeeprautela.delhimetronavigator;


import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Metro {

    String redLine[] = {"Dilshad Garden", "Jhilmil", "Mansarovar Park", "Shahdara", "Welcome(I)", "Seelampur", "Shastri Park",
            "Kashmere Gate(I)", "Tis Hazari", "Pul Bangash", "Pratap Nagar", "Shastri Nagar", "Inderlok(I)", "Kanhiya Nagar",
            "Keshav Puram", "Netaji Subhash Place(I)", "Kohat Enclave", "Pitam Pura", "Rohini East", "Rohini West", "Rithala"};

    String yellowLine[] = {"Samaypur Badli", "Rohini Sector 18, 19", "Haiderpur Badli Mor", "Jahangirpuri", "Adarsh Nagar", "Azadpur(I)", "Model Town",
            "GTB Nagar", "Vishwa Vidyalaya", "Vidhan Sabha", "Civil Lines", "Kashmere Gate(I)", "Chandni Chowk", "Chawri Bazar",
            "New Delhi(I)", "Rajiv Chowk(I)", "Patel Chowk", "Central Sectt(I)", "Udyog Bhawan", "Race Course",
            "Jor Bagh", "INA(I)", "AIIMS", "Green Park", "Hauz Khas(I)", "Malviya Nagar", "Saket", "Qutub Minar", "Chhatarpur", "Sultanpur", "Ghitorni",
            "Arjan Garh", "Guru Dronacharya", "Sikandarpur", "MG Road", "IFFCO Chowk", "Huda City Centre"};

    String blueLine[] = {"Noida City Centre", "Golf course", "Botanical garden(I)", "Noida Sector 18", "Noida Sector 16", "Noida Sector 15",
            "New Ashok Nagar", "Mayur Vihar - I(I)", "Akshardham", "Yamuna Bank(I)", "Indraprastha", "Pragati Maidan", "Mandi House(I)",
            "Barakhamba Road", "Rajiv Chowk(I)", "R.K. Ashram Marg", "Jhandewalan", "Karol Bagh", "Rajendra Place", "Patel Nagar", "Shadipur", "Kirti Nagar(I)",
            "Moti Nagar", "Ramesh Nagar", "Rajauri Garden(I)", "Tagore Garden", "Subhash Nagar", "Tilak Nagar", "Janakpuri East", "Janakpuri West(I)",
            "Uttam Nagar East", "Uttam Nagar West", "Nawada", "Dwarka Morh", "Dwarka", "Dwarka Sec-14", "Dwarka Sec-13", "Dwarka Sec-12", "Dwarka Sec-11",
            "Dwarka Sec-10", "Dwarka Sec-9","Dwarka Sec-8","Dwarka sector 21(I)"};

    String[] airportExpress = {"New Delhi(I)", "Shivaji Stadium", "Dhaula Kuan", "Delhi Aerocity", "IGI Airport (T-3) ", "Dwarka sector 21(I)"};

    String[] greenLine = {"Mundka", "Rajdhani Park", "Nangloai Rly. Station", "Nangloai", "Surajmal Stadium", "Udyog Nagar",
            "Peera Garhi", "Paschim Vihar (West)", "Paschim Vihar (East)", "Madi Pur", "Shivaji Park", "Punjabi Bagh", "Ashok Park Main",
            "Satguru Ram Singh Marg", "Kirti Nagar(I)"};

    String[] magentaLine = {"Janakpuri West(I)", "Dabri Mor", "Dashrath Puri", "Palam", "Sadaar Bazaar Cantonment", "Terminal 1 IGI Airport", "Shankar Vihar", "Vasant Vihar",
            "Munirka", "R.K Puram", "IIT Delhi", "Hauz Khas(I)", "Panchsheel Park", "Chirag Delhi", "Greater Kailash", "Nehru Enclave", "Kalkaji Mandir(I)", "Okhla NSIC",
            "Sukhdev Vihar", "Jamia Millia Islamia", "Okhla Vihar", "Jasola Vihar Shaheen Bagh", "Kalindi Kunj", "Okhla Bird Sanctuary", "Botanical garden(I)"};
    String[] pinkLine = {"Majlis Park", "Azadpur(I)", "Shalimar Bagh", "Netaji Subhash Place(I)", "Shakurpur", "Punjabi Bagh West", "ESI Hospital",
            "Rajauri Garden(I)", "Maya Puri", "Nariana Vihar", "Delhi Cantt", "Durgabai Deshmukh South Campus", "Sir Vishweshwaraiah Moti Bagh",
            "Bhikaji Cama Place", "Sarojini Nagar", "INA(I)", "South Extension", "Lajpat Nagar(I)", "Vinobapuri", "Ashram", "Hazrat Nizamuddin", "Mayur Vihar - I(I)", "Mayur Vihar Pocket 1",
            "Trilok Puri Sanjay Lake", "Vinod Nagar East", "Vinod Nagar", "IP Extension", "Anand Vihar(I)", "Karkardooma(I)", "Karkarduma Court", "Krishna Nagar", "East Azad Nagar",
            "Welcome(I)", "Jaffrabad", "Maujpur", "Gokul Puri", "Johri Enclave", "Shiv Vihar"};

    String[] blueLine2 = {"Yamuna Bank(I)", "Laxmi Nagar", "Nirman Vihar", "Preet Vihar", "Karkardooma(I)", "Anand Vihar(I)", "Kausambi", "Vaishali"};

    String[] voiletLine = {"Kashmere Gate(I)", "Lal Quila", "Jama Masjid", "Delhi Gate", "ITO", "Mandi House(I)", "Janpath", "Central Sectt(I)", "Khan Market", "Jawaharlal Nehru Stadium",
            "Jangpura", "Lajpat Nagar(I)", "Moolchand", "Kailash Colony", "Nehru Place", "Kalkaji Mandir(I)", "Govind Puri", "Okhla", "Jasola", "Sarita Vihar", "Mohan Estate", "Tughlakabad",
            "Badarpur", "Sarai", "N.H.P.C. Chowk", "Mewala Maharajpur", "Sector 28 Faridabad", "Badkal Mor", "Old Faridabad", "Neelam Chowk Ajronda", "Bata Chowk", "Escorts Mujesar",
            "Sant Surdas - Sihi", "Raja Nahar Singh"};

    String[] connectingLines = {"ryv", "Kashmere Gate(I)", "rp", "Netaji Subhash Place(I)", "rp", "Welcome(I)", "rg", "Inderlok(I)",
            "yp", "Azadpur(I)", "yp", "INA(I)", "yb", "Rajiv Chowk(I)", "ym", "Hauz Khas(I)", "pv", "Lajpat Nagar(I)", "pb", "Rajauri Garden(I)",
            "pb", "Mayur Vihar - I(I)", "px", "Karkardooma(I)", "px", "Anand Vihar(I)", "bg", "Kirti Nagar(I)", "bv", "Mandi House(I)", "bm", "Janakpuri West(I)",
            "bm", "Botanical garden(I)","ya","New Delhi(I)",
            "bx", "Yamuna Bank(I)", "ba", "Dwarka sector 21(I)", "mv", "Kalkaji Mandir(I)", "vy", "Central Sectt(I)"};

   static String allStations[] = {"Dilshad Garden ","Jhilmil ","Mansarovar Park ","Shahdara ","Welcome(I) ","Seelampur ","Shastri Park ","Kashmere Gate(I) ","Tis Hazari ","Pul Bangash ","Pratap Nagar ","Shastri Nagar ","Inderlok(I) ","Kanhiya Nagar ","Keshav Puram ","Netaji Subhash Place(I) ","Kohat Enclave ","Pitam Pura ","Rohini East ","Rohini West ","Rithala ",
            "Samaypur Badli  ","Rohini Sector 18, 19  ","Haiderpur Badli Mor  ","Jahangirpuri  ","Adarsh Nagar  ","Azadpur(I)  ","Model Town  ","GTB Nagar  ","Vishwa Vidyalaya  ","Vidhan Sabha  ","Civil Lines  ","Kashmere Gate(I)  ","Chandni Chowk  ","Chawri Bazar  ","New Delhi(I)  ","Rajiv Chowk(I)  ","Patel Chowk  ","Central Sectt(I)  ","Udyog Bhawan  ","Race Course  ","Jor Bagh  ","INA(I)  ","AIIMS  ","Green Park  ","Hauz Khas(I)  ","Malviya Nagar  ","Saket  ","Qutub Minar  ","Chhatarpur  ","Sultanpur  ","Ghitorni  ","Arjan Garh  ","Guru Dronacharya  ","Sikandarpur  ","MG Road  ","IFFCO Chowk  ","Huda City Centre  ",
            "Noida City Centre   ","Golf course   ","Botanical garden(I)   ","Noida Sector 18   ","Noida Sector 16   ","Noida Sector 15   ","New Ashok Nagar   ","Mayur Vihar - I(I)   ","Akshardham   ","Yamuna Bank(I)   ","Indraprastha   ","Pragati Maidan   ","Mandi House(I)   ","Barakhamba Road   ","Rajiv Chowk(I)   ","R.K. Ashram Marg   ","Jhandewalan   ","Karol Bagh   ","Rajendra Place   ","Patel Nagar   ","Shadipur   ","Kirti Nagar(I)   ","Moti Nagar   ","Ramesh Nagar   ","Rajauri Garden(I)   ","Tagore Garden   ","Subhash Nagar   ","Tilak Nagar   ","Janakpuri East   ","Janakpuri West(I)   ","Uttam Nagar East   ","Uttam Nagar West   ","Nawada   ","Dwarka Morh   ","Dwarka   ","Dwarka Sec-14   ","Dwarka Sec-13   ","Dwarka Sec-12   ","Dwarka Sec-11   ","Dwarka Sec-10   ","Dwarka Sec-9   ","Dwarka Sec-8   ","Dwarka sector 21(I)   ",
            "New Delhi(I)    ","Shivaji Stadium    ","Dhaula Kuan    ","Delhi Aerocity    ","IGI Airport (T-3)     ","Dwarka sector 21(I)    ",
            "Mundka     ","Rajdhani Park     ","Nangloai Rly. Station     ","Nangloai     ","Surajmal Stadium     ","Udyog Nagar     ","Peera Garhi     ","Paschim Vihar (West)     ","Paschim Vihar (East)     ","Madi Pur     ","Shivaji Park     ","Punjabi Bagh     ","Ashok Park Main     ","Satguru Ram Singh Marg     ","Kirti Nagar(I)     ",
            "Janakpuri West(I)      ","Dabri Mor      ","Dashrath Puri      ","Palam      ","Sadaar Bazaar Cantonment      ","Terminal 1 IGI Airport      ","Shankar Vihar      ","Vasant Vihar      ","Munirka      ","R.K Puram      ","IIT Delhi      ","Hauz Khas(I)      ","Panchsheel Park      ","Chirag Delhi      ","Greater Kailash      ","Nehru Enclave      ","Kalkaji Mandir(I)      ","Okhla NSIC      ","Sukhdev Vihar      ","Jamia Millia Islamia      ","Okhla Vihar      ","Jasola Vihar Shaheen Bagh      ","Kalindi Kunj      ","Okhla Bird Sanctuary      ","Botanical garden(I)      ",
            "Majlis Park       ","Azadpur(I)       ","Shalimar Bagh       ","Netaji Subhash Place(I)       ","Shakurpur       ","Punjabi Bagh West       ","ESI Hospital       ","Rajauri Garden(I)       ","Maya Puri       ","Nariana Vihar       ","Delhi Cantt       ","Durgabai Deshmukh South Campus       ","Sir Vishweshwaraiah Moti Bagh       ","Bhikaji Cama Place       ","Sarojini Nagar       ","INA(I)       ","South Extension       ","Lajpat Nagar(I)       ","Vinobapuri       ","Ashram       ","Hazrat Nizamuddin       ","Mayur Vihar - I(I)       ","Mayur Vihar Pocket 1       ","Trilok Puri Sanjay Lake       ","Vinod Nagar East       ","Vinod Nagar       ","IP Extension       ","Anand Vihar(I)       ","Karkardooma(I)       ","Karkarduma Court       ","Krishna Nagar       ","East Azad Nagar       ","Welcome(I)       ","Jaffrabad       ","Maujpur       ","Gokul Puri       ","Johri Enclave       ","Shiv Vihar       ",
            "Yamuna Bank(I)        ","Laxmi Nagar        ","Nirman Vihar        ","Preet Vihar        ","Karkardooma(I)        ","Anand Vihar(I)        ","Kausambi        ","Vaishali        ",
            "Kashmere Gate(I)         ","Lal Quila         ","Jama Masjid         ","Delhi Gate         ","ITO         ","Mandi House(I)         ","Janpath         ","Central Sectt(I)         ","Khan Market         ","Jawaharlal Nehru Stadium         ","Jangpura         ","Lajpat Nagar(I)         ","Moolchand         ","Kailash Colony         ","Nehru Place         ","Kalkaji Mandir(I)         ","Govind Puri         ","Okhla         ","Jasola         ","Sarita Vihar         ","Mohan Estate         ","Tughlakabad         ","Badarpur         ","Sarai         ","N.H.P.C. Chowk         ","Mewala Maharajpur         ","Sector 28 Faridabad         ","Badkal Mor         ","Old Faridabad         ","Neelam Chowk Ajronda         ","Bata Chowk         ","Escorts Mujesar         ","Sant Surdas - Sihi         ","Raja Nahar Singh         "
    };


    String s1, s2;
    String real=""
            ;
    char first ,second;
    String Dline[]=new String[100];

    int total=0;
    public  ArrayList<String> metro(String s1,String s2) {
        int i1,j=0;
        this.s1=s1;
        this.s2=s2;
        for(i1=s2.length()-1;i1>=0;i1--){
            if(s2.charAt(i1)!=' ') {
                  this.s2=s2.substring(0,i1+1);
                break;
            }          j++;
        }
        Log.i(" value of s2",this.s2);
        switch (j){
            case 1: second='r';
                    Dline=redLine;
                break;
            case 2: second='y';
                   Dline=yellowLine;
                break;
            case 3: second='b';
            Dline=blueLine;
                break;
            case 4: second='a';
            Dline=airportExpress;
                break;
            case 5: second='g';
            Dline=greenLine;
                break;
            case 6: second='m';
            Dline=magentaLine;
                break;
            case 7: second='p';
            Dline=pinkLine;
                break;
            case 8: second='x';
            Dline=blueLine2;
                break;
            case 9: second='v';
            Dline=voiletLine;
                break;
        }

        j=0;
        for(i1=s1.length()-1;i1>=0;i1--){
            if(s1.charAt(i1)!=' '){
                this.s1=s1.substring(0,i1+1);
                break;}
            j++;
        }

        switch (j){
            case 1: first='r';
                    first(first,redLine);
                    break;
            case 2: first='y';
                first(first,yellowLine);
                break;
            case 3: first='b';
                first(first,blueLine);
                break;
            case 4: first='a';
                first(first,airportExpress);
                break;
            case 5: first='g';
                first(first,greenLine);
                break;
            case 6: first='m';
                first(first,magentaLine);
                break;
            case 7: first='p';
                first(first,pinkLine);
                break;
            case 8: first='x';
                first(first,blueLine2);
                break;
            case 9: first='v';
                first(first,voiletLine);
                break;
        }

        Dline =real.split("  ");
        ArrayList<String > dline= new ArrayList<>();
        for(int i=0;i<Dline.length;i++)
             dline.add(Dline[i]);
        String s="";
        for(int i=1;i< dline.size();i++){
           if(dline.get(i-1).equals(dline.get(i))) {
               dline.remove(i);
               continue;
           }
        }
        return dline;
    }
     public  void first(char c,String []line){
        if(first==second){
            int k1=0,k2=0;
            for(int i=0;i<line.length;i++){
                if(line[i].equals(s1)){
                    for(int j=i;j<line.length;j++){
                        real+=line[j]+"  ";
                        if(line[j].equals(s2))
                            return;
                    }

                }
                if(line[i].equals(s2)){
                    for(int j=i;j<line.length;j++){
                        if(line[j].equals(s1))
                        {
                            for(int k=j;k>=i;k--)
                                real+=line[k]+"  ";
                            return;
                        }
                    }
                }

            }
        }

        String temp="";
         String stations = "", lines = "";
         for (int i = 0; i < line.length; i++) {
             if (line[i].contains("(I)")) {
                 stations +=line[i] + " ";
                 lines += c;
                 String temp2=temp;
                 temp = add(line, s1, i, temp);
                 if (temp == "") {
                     return;
                 }
                 Log.i("interchange ",line[i]+"\n\n");
                 search(line[i], stations, lines, temp);
                 temp=temp2;
             }
         }
     }

    public void search(String check, String stations, String lines, String temp) {
        String check2 = "";
        int i;

        for (i = 0; i < connectingLines.length; i++) {
            if (check.equals(connectingLines[i])) {
                check2 = connectingLines[i - 1];
                break;
            }
        }
        if (check2.contains(second+"")) {
            lines += second;
            int ii;
            for (ii = 0; ii < Dline.length; ii++) {
                if (Dline[ii].equals(s2)) {
                    break;
                }
            }
            temp = add(Dline, check, ii, temp);
            if (temp == null) {
                return;
            }
            if(real.length()==0 || real.length()>temp.length())
                real = temp;

            return;
        } else {
            char c = lines.charAt(lines.length() - 1);
            String temp2 = "";
            for (int k = 0; k < check2.length(); k++) {
                if (c == check2.charAt(k)) {
                    continue;
                } else {
                    temp2 += check2.charAt(k);
                }
            }
            check2 = temp2;
            for (i = 0; i < check2.length(); i++) {
                switch (check2.charAt(i)) {
                    case 'r':
                        add2(redLine, stations, lines, temp, check, 'r');
                        break;
                    case 'y':
                        add2(yellowLine, stations, lines, temp, check, 'y');
                        break;
                    case 'b':
                        add2(blueLine, stations, lines, temp, check, 'b');
                        break;
                    case 'g':
                        add2(greenLine, stations, lines, temp, check, 'g');
                        break;
                    case 'p':
                        add2(pinkLine, stations, lines, temp, check, 'p');
                        break;
                    case 'm':
                        add2(magentaLine, stations, lines, temp, check, 'm');
                        break;
                    case 'v':
                        add2(voiletLine, stations, lines, temp, check, 'v');
                        break;

                    case 'x':
                        add2(blueLine2, stations, lines, temp, check, 'x');
                        break;

                }
            }
        }

    }

    public String[] caseSearch(char c) {
        switch (c) {
            case 'r':
                return redLine;
            case 'y':
                return yellowLine;
            case 'b':
                return blueLine;
            case 'g':
                return greenLine;
            case 'p':
                return pinkLine;
            case 'm':
                return magentaLine;
            case 'v':
                return voiletLine;

            case 'x':
                return blueLine2;
        }
        return null;
    }

    public String add(String[] line, String s1, int i, String temp) {
        int len = 0;

        for (int j = 0; j < line.length; j++) {
            if (line[j].equals(s1)) {
                len = j;
                break;
            }
        }
        if (len > i) {
            for (int j = len; j>=i; j--) {
                temp+=line[j]+"  ";
            }
        } else {
            for (int j = len; j <=i; j++) {
                temp+=line[j]+"  ";
            }
        }

        return temp;
    }

    public void add2(String[] line, String stations, String lines, String temp, String check, char c) {

        for (int j = 0; j < line.length; j++) {
            if (line[j].contains("(I)")) {
                if (stations.contains(line[j])) {
                    continue;
                }
                stations += line[j] + " ";
                lines += c;
                String temp2=temp;
                temp = add(line, check, j, temp);
                if(temp=="")
                    return;
                search(line[j], stations, lines, temp);
                temp=temp2;
            }
        }
    }
}

