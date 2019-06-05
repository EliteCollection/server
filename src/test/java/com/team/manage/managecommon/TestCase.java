package com.team.manage.managecommon;

import com.team.manage.entity.Dept;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create time 2019/6/5 9:31 AM
 * Description StudyTest
 *
 * @author tcyu
 */
public class TestCase {
    HashMap<String,String> hashMap = new HashMap<>();
    ArrayList list = new ArrayList();

    public static void main(String[] args) {
        HashMap<Dept, Dept> map = new HashMap<>();
        for (int i = 0 ; i<7 ; i++){
            map.put(new Dept(),new Dept());
        }
        System.out.println(map.toString());
    }
}
