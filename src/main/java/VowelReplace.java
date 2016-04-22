
class VowelReplace {
  public static String vowelsToDash(String hasVowels){
    //initialize value
    String inString = hasVowels;
    char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
    String outString = "";
    boolean isConsonant = true;
  //  System.out.println();

    //for every character inString
    for (int i=0;i< inString.length();i++){

      //assume each character is a consotant
      isConsonant=true;


      //for every value in Vowels
      for (int j=0; j< vowels.length; j++){

        //if the instring character is anywhere in vowel,
        if ( inString.charAt(i) == vowels[j] ){
          //add '-'
          outString += '-';

          //don't add character
          isConsonant=false;
        }

      }

      //if character isn't in vowels
      if (isConsonant) {
        //add the character to outstring
        outString += inString.charAt(i);
      }


    }



    return outString;
  }

}


// if ( vowels.indexOf(inString.charAt(i)) != -1 ){
//   inString.charAt(i) = "-";
// }
