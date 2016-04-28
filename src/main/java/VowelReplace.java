class VowelReplace {

  public static String vowelsToDashWithReplaceAll(String hasVowels){
    String inOutString = hasVowels;
    String[] vowels = {"a","e","i","o","u","A","E","I","O","U"};
    for (int j=0; j< vowels.length; j++){
      inOutString = inOutString.replaceAll(vowels[j], "-");
    }
    return inOutString;
  }

  public static String vowelsToDash(String hasVowels){
    String inString = hasVowels;
    char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
    String outString = "";
    boolean isConsonant = true;

    for (int i=0;i< inString.length();i++){
      isConsonant=true;
      for (int j=0; j< vowels.length; j++){
        if ( inString.charAt(i) == vowels[j] ){
          outString += '-';
          isConsonant=false;
        }
      }
      if (isConsonant) {
        outString += inString.charAt(i);
      }
    }
    outString = outString.trim();
    return outString;
  }

}
