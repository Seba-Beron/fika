package com.mycompany.fika;

import org.sql2o.Sql2o;

public class Sql2oDAO {     // singelton

    static Sql2o sql2o;

    public static Sql2o getSql2o(){
        if(sql2o == null){
            sql2o = new Sql2o("jdbc:mysql://localhost:3306/fika?serverTimezone=UTC", "root", "");
        }
        return sql2o;
    }
}
