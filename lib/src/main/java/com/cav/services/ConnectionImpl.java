package com.cav.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;







public class ConnectionImpl implements Connection{

	@Override
	public List<String> getWords(String link){
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		List<String> words = new ArrayList<String>();
		try {
			url = new URL(link);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			br = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        long start = System.nanoTime();
	        while ((inputLine = br.readLine()) != null) {
	        	String[] fields = inputLine .split(" ");
	        	for(String field : fields){
	        		words.add(field);
	        	}
	        } 
	        long finish = System.nanoTime();
	        long timeElapsed = finish - start;
	        System.out.println("Time taken non stream "+timeElapsed);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} if(con != null){
				con.disconnect();
			}
		}
		
		return words;
	}

	@Override
	public List<String> getWordsStream(String link) {
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		List<String> words = new ArrayList<String>();
		try {
			url = new URL(link);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			br = new BufferedReader(
	                new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        long start = System.nanoTime();
	        while ((inputLine = br.readLine()) != null) {
	        	List<String> wordList = Stream.of(inputLine.split(" "))
	            .map (elem -> new String(elem))
	            .collect(Collectors.toList());
	        	words.addAll(wordList);
	        } 
	        long finish = System.nanoTime();
	        long timeElapsed = finish - start;
	        System.out.println("Time taken using stream "+timeElapsed);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} if(con != null){
				con.disconnect();
			}
		}
		
		return words;
	}

	@Override
	public List<String> getWordsFromFile(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(path);
		String line;
		BufferedReader br = null;
		List <String> words = new ArrayList<String>();
		try {
			br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			while ((line = br.readLine()) != null) {
				words.addAll(Stream.of(line.split(" ")).filter(s ->!s.isEmpty()).collect(Collectors.toList()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return words;
	}

}
