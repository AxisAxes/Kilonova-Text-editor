package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.FileReader;



public class TextFunctions{


	private String text;
	private String NamePath;
	private boolean exists; 
	DTextInicial texto = new DTextInicial();
	
	

	
	
	public void textCreator (String Textos ,String Diret)throws IOException {
		BufferedWriter bw = null;
		FileWriter fw = null;
	
		
		
		try{
			fw = new FileWriter(Diret);
			bw = new BufferedWriter(fw);
			bw.write(Textos);	
			
		}catch(IOException e) { 
			e.printStackTrace();
		}finally {
			try {
				if(bw != null)
					bw.close();
				if(fw != null)
					fw.close();
			}catch(IOException ex){
				ex.printStackTrace();
				
			}
		}
		
	}
	public void ReadFile(JTextPane file,String path) {

		
		
	    try {
	        
	        FileReader fileReader = new FileReader(path);

	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        String linha = "";
	        while ( ( linha = bufferedReader.readLine() ) != null) {
	        file.setText(linha);
	    }
	        fileReader.close();
	        bufferedReader.close();
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
	}



	public void txtChose() {
		
		
	}
	
	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}




	public String getNamePath() {
		return NamePath;
	}




	public void setNamePath(String namePath) {
		NamePath = namePath;
	}




	public boolean isExists() {
		return exists;
	}




	public void setExists(boolean exists) {
		this.exists = exists;
	}



}
/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class ManipuladorArquivo {
 
    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
 
    public static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        linha = in.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }
 
}*/