package com.lives.utils;

import java.sql.SQLException;
import java.text.ParseException;

public class Test {

	public static void main(String[] args) throws NumberFormatException, SQLException, ParseException 
	{
		System.out.println(DBStreamStatusAPI.Change_User_Status("carlos",1));

	}

}
