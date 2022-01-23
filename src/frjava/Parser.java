package frjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Parser {

	public static void main(String[] args) throws Exception {
		if(args.length < 1) {
			throw new Exception("Mauvais nombre de paramètres");
		}
		
		System.out.println(args[0]);
		
		BufferedReader buffReader = Files.newBufferedReader(Paths.get("./"+args[0]), StandardCharsets.UTF_8);
	    
	    String stringToWrite = buffReader.lines().map((s) -> translate(s)).collect(Collectors.joining("\n"));
		
	    String nomFic = args[0];
	    nomFic = nomFic.replace(".frjava",".java");
		try {
		      File myObj = new File(nomFic);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		try {
		      FileWriter myWriter = new FileWriter(nomFic);
		      myWriter.write(stringToWrite);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	private static String translate(String s) {
		String sRet = s;
		
		
		//Traduction des keywords de java
		sRet = sRet.replaceAll("(\s|)abstrait(e|)(\s|)","\sabstract\s");
		sRet = sRet.replaceAll("(\s|)bool(é|e)en(\s|)","\sboolean\s");
		sRet = sRet.replaceAll("(\s|)interrompre(\s|)","\sbreak\s");
		sRet = sRet.replaceAll("(\s|)octet(\s|)","\sbyte\s");
		sRet = sRet.replaceAll("(\s|)cas(\s|)","\scase\s");
		sRet = sRet.replaceAll("(\s|)attraper(\s|)","\scatch\s");
		sRet = sRet.replaceAll("(\s|)caract(e|è)re(\s|)","\schar\s");
		sRet = sRet.replaceAll("(\s|)classe(\s|)","\sclass\s");
		sRet = sRet.replaceAll("(\s|)continuer(\s|)","\scontinue\s");
		sRet = sRet.replaceAll("(\s|)d(é|e)faut(\s|)","\sdefault\s");
		sRet = sRet.replaceAll("(\s|)faire(\s|)","\sdo\s");
		sRet = sRet.replaceAll("(\s|)sinon(\s|)","\selse\s");
		sRet = sRet.replaceAll("(\s|)(é|e)num(é|e)ration(\s|)","\senum\s");
		sRet = sRet.replaceAll("(\s|)h(e|é)rite(\s|)","\sextends\s");
		sRet = sRet.replaceAll("(\s|)final(e|)(\s|)","\sfinal\s");
		sRet = sRet.replaceAll("(\s|)finalement(\s|)","\sfinally\s");
		sRet = sRet.replaceAll("(\s|)(flottant|r(é|e)el)(\s|)","\sfloat\s");
		sRet = sRet.replaceAll("(\s|)pour(\s|)","\sfor\s");
		sRet = sRet.replaceAll("(\s|)si(\s|)","\sif\s");
		sRet = sRet.replaceAll("(\s|)impl(é|e)mente(\s|)","\simplements\s");
		sRet = sRet.replaceAll("(\s|)importer(\s|)","\simport\s");
		sRet = sRet.replaceAll("(\s|)instancede(\s|)","\sinstanceof\s");
		sRet = sRet.replaceAll("(\s|)entier(\s|)","\sint\s");
		sRet = sRet.replaceAll("(\s|)nati(f|ve)(\s|)","\snative\s");
		sRet = sRet.replaceAll("(\s|)nouv(eau|elle)(\s|)","\snew\s");
		sRet = sRet.replaceAll("(\s|)nul(le|)(\s|)","\snull\s");
		sRet = sRet.replaceAll("(\s|)paquetage(\s|)","\spackage\s");
		sRet = sRet.replaceAll("(\s|)priv(é|e)(e|)(\s|)","\sprivate\s");
		sRet = sRet.replaceAll("(\s|)prot(é|e)g(é|e)(e|)(\s|)","\sprotected\s");
		sRet = sRet.replaceAll("(\s|)publi(c|que)(\s|)","\spublic\s");
		sRet = sRet.replaceAll("(\s|)retourner(\s|)","\sreturn\s");
		sRet = sRet.replaceAll("(\s|)court(\s|)","\sshort\s");
		sRet = sRet.replaceAll("(\s|)statique(\s|)","\sstatic\s");
		sRet = sRet.replaceAll("(\s|)selon(\s|)","\sswitch\s");
		sRet = sRet.replaceAll("(\s|)synchronis(é|e)(\s|)","\ssynchronized\s");
		sRet = sRet.replaceAll("(\s|)ceci(\s|)","\sthis\s");
		sRet = sRet.replaceAll("(\s|)lancer(\s|)","\sthrow\s");
		sRet = sRet.replaceAll("(\s|)lance(\s|)","\sthrows\s");
		sRet = sRet.replaceAll("(\s|)essayer(\s|)","\stry\s");
		sRet = sRet.replaceAll("(\s|)rien(\s|)","\svoid\s");
		sRet = sRet.replaceAll("(\s|)tant(\s|)que(\s|)","\swhile\s");
		
		sRet = sRet.replaceAll("(\s|)vrai(\s|)","\strue\s");
		sRet = sRet.replaceAll("(\s|)faux(\s|)","\sfalse\s");
				
		return sRet;
	}
}
