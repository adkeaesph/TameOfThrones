package com.geektrust.tame_of_thrones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TameOfThronesApplication {

	public static void main(String[] args) throws IOException {
		File file = new File(System.getProperty("user.dir")+"/src/main/resources/inputfiles/inputFile3.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		List<SecretMessage> secretMessages = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			String[] words = line.split("\\s+");
			secretMessages.add(new SecretMessage(words[0], words[1]));
		}
		br.close();
		
		List<String> allies = new ArrayList<>();
		for(SecretMessage secretMessage : secretMessages) {
			String emblem;
			String kingdom = secretMessage.getKingdom();
			if(kingdom.equals("LAND")) 
				emblem = "PANDA"; 
			else if(kingdom.equals("WATER"))
				emblem = "OCTOPUS";
			else if(kingdom.equals("ICE"))
				emblem = "MAMMOTH";
			else if(kingdom.equals("AIR"))
				emblem = "OWL";
			else if(kingdom.equals("FIRE"))
				emblem = "DRAGON";
			else
				emblem = "";
			
			List<AlphabetNode> alphabetWheel = new ArrayList<>();
			for(char c='A';c<='Z';c++)
				alphabetWheel.add(new AlphabetNode(c, null));
			int i=0;
			for(AlphabetNode alphabetNode : alphabetWheel) {
				if(i<=24) {
					alphabetNode.setNextAlphabet(alphabetWheel.get(i+1));
					i++;
				} else
					break;
			}
			alphabetWheel.get(i).setNextAlphabet(alphabetWheel.get(0));
			
//			for(AlphabetNode alphabetNode : alphabetWheel)
//				System.out.println(alphabetNode.getAlphabet() + " " + alphabetNode.getNextAlphabet().getAlphabet());
			
			String encryptedEmblem = "";
			int emblemLength = emblem.length();
			AlphabetNode currentNode;
			for(int j=0;j<emblemLength;j++) {
				currentNode = alphabetWheel.get((int)(emblem.charAt(j)) - 65);
				for(int k=0;k<emblemLength;k++)
					currentNode = currentNode.getNextAlphabet();
				encryptedEmblem += ""+currentNode.getAlphabet();
			}
			
			boolean success = true;
			StringBuilder sb = new StringBuilder(secretMessage.getSecretMessage());
			int j=0;
			while(j<emblemLength) {
				int index = sb.indexOf(""+encryptedEmblem.charAt(j));
				if(index == -1) {
					success = false;
					break;
				} else {
					sb.deleteCharAt(index);
				}
				j++;
			}
			
			if(success)
				allies.add(kingdom);
		}
		allies.add(0,"SPACE");
		if(allies.size()<4)
			System.out.println("NONE");
		else {
			
			for(String ally : allies) 
				System.out.print(ally+" ");
		}

		
	}
}
