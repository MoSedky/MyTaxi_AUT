package com.mytaxi.android_demo.activities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetCredentials {
    private String generated_username=null;
    private String generated_password=null;
    public String[] credentials;

    public Boolean ReadCredentials() throws Exception {
        URL url = new URL("https://randomuser.me/api/?seed=a1f30d446f820665");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        int status = con.getResponseCode();
        if (status != 200) {
            return false;
        } else {
            generated_username= null;
            generated_password= null;
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            Pattern pattern_username = Pattern.compile("\"username\"?:\"(.*?)\"");
            Pattern pattern_password = Pattern.compile("\"password\"?:\"(.*?)\"");
            Matcher matcher_username = pattern_username.matcher(content);
            Matcher matcher_password = pattern_password.matcher(content);

            if(matcher_username.find()&& matcher_password.find())
            {
                generated_username=matcher_username.group(1);
                generated_password=matcher_password.group(1);
            }

            System.out.println(generated_username);
            System.out.println(generated_password);

//           // in.close();
            return true;
        }



    }
    public String[] passCredentials()
    {
        credentials[0]=generated_username;
        credentials[1]=generated_password;
        return credentials;
    }
}

