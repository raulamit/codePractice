/**
 * Created by raula on 1/14/2017.
 */
public class Twitter1{
    static String knownString ="Your friend, Alice";
 public static void main(String[] args) {
     String a= maskEmail("E:abc@gmail.com");
     System.out.println(maskPhone("P:+1 (123)-172-4545"));
 }

    private static String maskPhone(String s) {
        String phoneNum = s.substring(2);
        phoneNum=phoneNum.replaceAll("[()]","");
        String maskedNum ="";
/*        for (int i=0; i<phoneNum.length()-4;i++){
            if (maskedNum.charAt(i)== '+' || maskedNum.charAt(i)== '-'){
                maskedNum =maskedNum+maskedNum.charAt(i);
            }else if (maskedNum.charAt(i) >= 48 && maskedNum.charAt(i) <= 57){
                maskedNum =maskedNum +"*";
            }
        }*/
        if (phoneNum.replaceAll("[^0-9]","").length()>10){
            maskedNum="+"+ phoneNum.substring(0,phoneNum.replaceAll("[^0-9]","").length()-10)+"-";
        }
        return maskedNum+"***-***-"+phoneNum.substring(phoneNum.length()-4);
    }

    private static String maskEmail(String s) {
     String email = s.substring(2);
     String[] emailParts= email.split("@");
     String maskedEmail = emailParts[0].charAt(0) + "*****" + emailParts[0].charAt(emailParts[0].length()-1)
             + "@" +emailParts[1];
     return s.substring(0,2)+ maskedEmail;
    }


/* main{
        String encrypted_message= "Atvt hrqgse, Cnikg";
        String decryptedString="";
        String code= getCode(encrypted_message);
        int codeLength= code.length();
        for (int i=0; i< encrypted_message.length(); i++){
            char c = encrypted_message.charAt(i);
            int codeDigit= code.charAt(i%codeLength)-48;
            if (c >= 65 && c<=90 ){
                int a='A' + (c-codeDigit+26-65)%26;
                decryptedString = decryptedString + (char)a;
            }else if ( c >= 97 && c<=122){
                int a='a' + (c-code.charAt(i%codeLength)+26-97)%26;
                code = code +a;
            }
        }
    }*/

/*    static String getCode(String encrypted_string){
        String code="";
        for (int i=0; i <encrypted_string.length();i++){
            char c= encrypted_string.charAt(i);
            if (c >= 65 && c<=90 || c >= 97 && c<=122 ){
                int a=(c-knownString.charAt(i)+26)%26;
                code = code +a;
                if (a> 9) System.out.println("wrong code:  "+ a + "" +code);
            }
        }
        return code;
    }*/
}
