package com.example.sampleloginapp.common;

import com.example.sampleloginapp.retrofit.Post;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utils {
    public static void orderList (List<Post> list){
        Collections.sort(list, compareById.reversed());
    }

    static Comparator<Post> compareById = new Comparator<Post>() {
        @Override
        public int compare(Post p1, Post p2) {
            return p1.getId().compareTo(p2.getId());
        }
    };

}
