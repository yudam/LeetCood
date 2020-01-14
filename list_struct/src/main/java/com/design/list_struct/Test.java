package com.design.list_struct;

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: maodayu
 * Date: 2019/10/11
 * Time: 18:23
 */
public class Test {


    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(2019,Calendar.DECEMBER,30);

        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("2019-12-31    "+dateFormat.format(calendar.getTime()));



    }


}
