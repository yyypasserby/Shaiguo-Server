
	package com.lives.utils;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import com.lives.model.Prediction;

	public class DBPredictionAPI {

		private static String tablename= "Prediction";
	
		
		static public int insertPrediction(int actionId,String heading,String content
				,String thumbnail,String sendtime,String casttime) throws SQLException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doInsert = "replace into " +tablename+ " (actionId,heading,content,thumbnail,sendtime)"
						+ " values ('" +actionId+ 
						  "','"        +heading+
						  "','"        +content+
						  "','"        +thumbnail+
						  "','"        +sendtime+
						  "','"		   +casttime+
						  "')";
				PreparedStatement prepareState = connection.prepareStatement(doInsert);
				return prepareState.executeUpdate();
			}finally{
				connection.close();
			}
		}
		
		static public int  deletePrediction(int predictionId) throws SQLException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doDelete = "delete from " +tablename+ " where id=" +predictionId;
				PreparedStatement prepareState = connection.prepareStatement(doDelete);
				return prepareState.executeUpdate();
//				return prepareState.execute();
			}finally{
				connection.close();
			}
		}
		
		
		static public int updatePrediction(int predictionId,int actionId,String heading,String content,
				String thumbnail,String sendtime,String casttime) throws SQLException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doCheck = "update " +tablename+ 
						"set actionId=" +actionId+
						" , heading='" +heading+
						"', content='" +content+
						"', thumbnail='" +thumbnail+
						"', sendtime='" +heading+
						"', casttime='" +casttime+
						"' where id=" +predictionId;
				PreparedStatement prepareState = connection.prepareStatement(doCheck);
				return prepareState.executeUpdate();
			}finally{
				connection.close();
			}
		}
		
		static public Prediction getPredictionById(int predictionId) throws SQLException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doCheck = "select * from " +tablename+ " where id=" +predictionId;
				PreparedStatement prepareState = connection.prepareStatement(doCheck);
				ResultSet resultSet = prepareState.executeQuery();
				if(!resultSet.next())
					return new Prediction();
				return new Prediction(resultSet.getInt(1),resultSet.getInt(2),
						resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
			}finally{
				connection.close();
			}
		}
		

		static public Prediction getPredictionByActionId(int actionId) throws SQLException, ParseException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doCheck = "select * from " +tablename+ " where actionId=" +actionId;
				PreparedStatement prepareState = connection.prepareStatement(doCheck);
				ResultSet resultSet = prepareState.executeQuery();
				if(!resultSet.next())
					return new Prediction();
				return new Prediction(resultSet.getInt(1),resultSet.getInt(2),
						resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
			}finally{
				connection.close();
			}
		}
	}
