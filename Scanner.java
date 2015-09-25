/* Code To generatetokens for constructing symbol tabel for given program.
   Developed by praveen kumar kommireddy,NetID: pkk236,Dean dsouza Net id:dpd285, shreyas tiwari Net id:st2352 .
   .*/

import java.*; /* include the header files needed*/
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.lang.*;

class Scanner {
    public static String NUMBER_TOKEN = "tokNumber";
    public static String WORD_TOKEN = "tokWord";
    public static String OPERATOR_TOKEN = "tokOp";
    public static Vector Num_Tok= new Vector(3,2);
    public static Enumeration Num_Enum = Num_Tok.elements();
    public static Vector Word_Tok= new Vector(3,2);
    public static Enumeration Word_Enum = Word_Tok.elements();
    public static Vector Op_Tok= new Vector(3,2);
    public static Enumeration Op_Enum = Op_Tok.elements();
    String tok1;


    public void getTokens(String toks)                               //create a function that breaks stings into tokens
    {
        String relops[]={"=","<>","<","<=",">=",">"};
        String addops[]={"+","-"};
        String mulops[]={"*","/"};
        int i;
        StringTokenizer newtoks = new StringTokenizer(toks);
        while (newtoks.hasMoreTokens()) {                            //the loop checks for other tokens
            String token = newtoks.nextToken() ;
            String tokenType = getTokenType(token) ;
            //System.out.println(token + "\t" + tokenType);            // Returns the type of token to user


            if(tokenType.equals("tokNumber")){
                Num_Tok.addElement(new String(token));                // tokens of type numbers are stored
                System.out.println(token + "\t" + tokenType);
                tok1=token; }


            if(tokenType.equals("tokWord")) {
               Word_Tok.addElement(new String(token));               //  tokens of type words are stored
               if(token.equalsIgnoreCase("program"))
                 System.out.println(token + "\t" + "tokProgram");
               else
               if(tok1.equalsIgnoreCase("program"))
                 System.out.println(token + "\t" + "tokIdentifier");
               else
               if(tok1.equalsIgnoreCase("var"))
                 System.out.println(token + "\t" +"tokIdentifier");
               else
               if(tok1.equalsIgnoreCase(":"))
                 System.out.println(token + "\t" + "toktype");
               else
               if(token.equalsIgnoreCase("or"))
                 System.out.println(token + "\t" + "tokaddop");
               else
               if(token.equalsIgnoreCase("div"))
                 System.out.println(token + "\t" + "tokmulop");
               else
               if(token.equalsIgnoreCase("mod"))
                 System.out.println(token + "\t" + "tokmulop");
               else
               if(token.equalsIgnoreCase("and"))
                 System.out.println(token + "\t" + "tokmulop");
               else
               if(token.equalsIgnoreCase("begin"))
                 System.out.println(token + "\t" + "tokBegin");
               else
               if(token.equalsIgnoreCase("End"))
                 System.out.println(token + "\t" + "tokEnd");
               else
               System.out.println(token + "\t" + "tokWord");
               tok1=token; }

            if(tokenType.equals("tokOp")){
               Op_Tok.addElement(new String(token));                 // tokens of type operators are stored
               if(token.equalsIgnoreCase(";"))
                 System.out.println(token + "\t" + "toksemicolon");
               if(token.equalsIgnoreCase("."))
                 System.out.println(token + "\t" + "tokperiod");
               if(token.equalsIgnoreCase(":="))
                 System.out.println(token + "\t" + "tokassignop");
               for(i=0;i<6;i++){
               if(token.equalsIgnoreCase(relops[i]))
                 System.out.println(token + "\t" + "tokrelop"); }
               for(i=0;i<2;i++){
               if(token.equalsIgnoreCase(addops[i]))
                 System.out.println(token + "\t" + "tokaddop"); }
               for(i=0;i<2;i++){
               if(token.equalsIgnoreCase(mulops[i]))
                 System.out.println(token + "\t" + "tokmulop"); }

               tok1=token; }
        }

    }


    /* This code stores the identified tokens in a vector for future use in the symbol table.*/


    private String getTokenType(String token) {
        if(token != null) {
            if (Pattern.matches("[\\d]+", token)) {                  // is the token of type numbers
                return NUMBER_TOKEN;
            } else if (Pattern.matches("[\\w]+", token)) {           // is the token of type word
                return WORD_TOKEN;
            } else {
                return OPERATOR_TOKEN;                               // return operator token
            }
        }
        return null;
    }


    public static void main(String s[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));          //A buffer is necessary to read the statement
        int i;
        Vector vtok = new Vector(3, 2);
        Enumeration vEnum = vtok.elements();
        String getstmt;                                                                   //obtain the input from user and store it
        Scanner sc = new Scanner();

        System.out.println("Start typing your code: ");
        System.out.println("When you finish writing enter STOP: ");

        do {
            getstmt = br.readLine();
            vtok.addElement(new String(getstmt));
        } while (!getstmt.equalsIgnoreCase("stop"));

        getstmt = "";

        while (!getstmt.equalsIgnoreCase("stop")) {
            while (vEnum.hasMoreElements()) {
                getstmt = (String) vEnum.nextElement();
                if (getstmt.equalsIgnoreCase("stop"))
                    break;
                else
                    sc.getTokens(getstmt);                                                  //after obtaining statement call the function to identify tokens
            }

        }
    }
}
