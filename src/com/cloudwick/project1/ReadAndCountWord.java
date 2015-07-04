package com.cloudwick.project1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ahuja on 4/5/15.
 */
public class ReadAndCountWord {

    public HashMap ReadFile(String path) {
        String ReadWord;
        String stopWord;
        int count = 0;
        int InitValue = 1;
        ArrayList<String> stopList = new ArrayList<String>();

        Connection connection = null;

        try {


            Scanner sci = new Scanner(new FileInputStream("/Users/ahuja/Desktop/stop.txt"));

            //Adding the stop words to a list
            while (sci.hasNextLine()) {
                stopWord = sci.nextLine();
                stopList.add(stopWord);
            }
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        HashMap<String, WordDto> hm = new HashMap<String, WordDto>();

        try {
            Scanner sc = new Scanner(new FileInputStream(path));
            //Scanner sc1 = new Scanner(new FileInputStream("/Users/ahuja/Desktop/json.txt"));


            while (sc.hasNext()) {
                // Removing "," , "'" , "." and converting it to lowercase

                ReadWord = sc.next();
                // StringBuilder sb = new StringBuilder(ReadWord);
                // http://stackoverflow.com/questions/3472663/replace-all-occurences-of-a-string-using-stringbuilder

                ReadWord = ReadWord.replaceAll(",", "");
                ReadWord = ReadWord.replaceAll("'", "");
                ReadWord = ReadWord.replace(".", "");
                ReadWord = ReadWord.replace("-", "");
                ReadWord = ReadWord.replace("(", "");
                ReadWord = ReadWord.replace(")", "");
                ReadWord = ReadWord.toLowerCase();

                if (!stopList.contains(ReadWord)) {
                    // If the word is not there in the stopList then we will add it into the hashmap
                    count++;
                    WordDto word1 = new WordDto(ReadWord);

                    if (hm.containsKey(ReadWord)) {
                        InitValue = hm.get(ReadWord).getCount();
                        InitValue++;
                        word1.setCount(InitValue);
                        hm.replace(word1.getWord(), word1);

                    } else {
                        word1.setCount(1);
                        hm.put(word1.getWord(), word1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage() + count);
        }
        System.out.print(count);

        return hm;
    }

    public static void main(String[] args) {

        ReadAndCountWord file = new ReadAndCountWord();
        file.ReadFile("/Users/ahuja/Desktop/Rachit.txt");
    }


}