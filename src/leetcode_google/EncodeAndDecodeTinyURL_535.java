package leetcode_google;

import java.util.HashMap;
import java.util.*;

public class EncodeAndDecodeTinyURL_535 {
    HashMap<String,Integer> dict = new HashMap<String,Integer>();
    List<String> decode = new ArrayList<String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(dict.containsKey(longUrl)){
            return dict.get(longUrl).toString();
        }else{
            dict.put(longUrl, decode.size());
            decode.add(longUrl);
            return dict.get(longUrl).toString();
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int i = Integer.parseInt(shortUrl);
        if(i<decode.size()){
            return decode.get(i).toString();
        }else{
            return null;
        }
    }
}
