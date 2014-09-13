
	package com.lives.utils;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.lives.model.Prediction;

	public class DBPredictionAPI {

		private static String tablename= "Prediction";
		private static ResultSet  resultSet;
		private static PreparedStatement prepareState;
		private static SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
	
		
		static public int insertPrediction(int actionId,String heading,String content,String thumbnail,Date sendtime) throws SQLException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doInsert = "replace into " +tablename+ " (actionId,heading,content,thumbnail,sendtime)"
						+ " values ('" +actionId+ 
						  "','"        +heading+
						  "','"        +content+
						  "','"        +thumbnail+
						  "','"        +sdf.format(sendtime)+
						  "')";
				prepareState = connection.prepareStatement(doInsert);
				return prepareState.executeUpdate();
			}finally{
				connection.close();
			}
		}
		
		static public int  deletePrediction(int predictionId) throws SQLException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doDelete = "delete from " +tablename+ " where id=" +predictionId;
				prepareState = connection.prepareStatement(doDelete);
				return prepareState.executeUpdate();
//				return prepareState.execute();
			}finally{
				connection.close();
			}
		}
		
		
		static public int updatePrediction(int predictionId,int actionId,String heading,String content,String thumbnail,Date sendtime) throws SQLException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doCheck = "update " +tablename+ 
						" set id=" +predictionId+
						", actionId=" +actionId+
						", heading='" +heading+
						"', content='" +content+
						"', thumbnail='" +thumbnail+
						"', sendtime='" +heading+
						" where predictionId=" +sdf.format(sendtime);
				prepareState = connection.prepareStatement(doCheck);
				return prepareState.executeUpdate();
			}finally{
				connection.close();
			}
		}
		
		static public Prediction getPredictionById(int predictionId) throws SQLException, ParseException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doCheck = "select * from " +tablename+ " where id=" +predictionId;
				prepareState = connection.prepareStatement(doCheck);
				resultSet = prepareState.executeQuery();
				if(!resultSet.next())
					return new Prediction();
				return new Prediction(resultSet.getInt(1),resultSet.getInt(2),
						resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),sdf.parse(resultSet.getString(6)));
			}finally{
				connection.close();
			}
		}
		

		static public Prediction getPredictionByActionId(int actionId) throws SQLException, ParseException{
			Connection connection = DBPool.getInstance().getConnection();
			try{
				String doCheck = "select * from " +tablename+ " where actionId=" +actionId;
				prepareState = connection.prepareStatement(doCheck);
				resultSet = prepareState.executeQuery();
				if(!resultSet.next())
					return new Prediction();
				return new Prediction(resultSet.getInt(1),resultSet.getInt(2),
						resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),sdf.parse(resultSet.getString(6)));
			}finally{
				connection.close();
			}
		}
	}
