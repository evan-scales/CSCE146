public class WordHelper {
    public static String[] sortByVowels(String[] words){
        Word[] wArr = strArrToWordArr(words);
        boolean hasSwapped = true;
        while(hasSwapped){
            hasSwapped = false;
            for(int i=0;i<wArr.length-1;i++){
                if(wArr[i].getVowels() > wArr[i+1].getVowels()){
                    Word temp = wArr[i];
                    wArr[i] = wArr[i+1];
                    wArr[i+1] = temp;
                    hasSwapped = true;
                }
            }
        }
        return wordArrToStrArr(wArr);
    }
    public static String[] sortByConsonants(String[] words){
        Word[] wArr = strArrToWordArr(words);
        boolean hasSwapped = true;
        while(hasSwapped){
            hasSwapped = false;
            for(int i=0;i<wArr.length-1;i++){
                if(wArr[i].getConsonants() > wArr[i+1].getConsonants()){
                    Word temp = wArr[i];
                    wArr[i] = wArr[i+1];
                    wArr[i+1] = temp;
                    hasSwapped = true;
                }
            }
        }
        return wordArrToStrArr(wArr);
    }
    public static String[] sortByLength(String[] words){
        Word[] wArr = strArrToWordArr(words);
        boolean hasSwapped = true;
        while(hasSwapped){
            hasSwapped=false;
            for(int i=0;i<wArr.length-1;i++){
                if(wArr[i].getWord().length() > wArr[i+1].getWord().length()){
                    Word temp = wArr[i];
                    wArr[i] = wArr[i+1];
                    wArr[i+1] = temp;
                    hasSwapped=true;
                }
            }
        }
        return wordArrToStrArr(wArr);
    }
    private static Word[] strArrToWordArr(String[] words){
        if(words == null)
            return null;
        Word[] ret = new Word[words.length];
        for(int i=0;i<words.length;i++)
            ret[i] = new Word(words[i]);   
        return ret;
    }
    private static String[] wordArrToStrArr(Word[] words){
        if(words == null)
            return null;
        String[] ret = new String[words.length];
        for(int i=0;i<words.length;i++)
            ret[i] = words[i].getWord();
        return ret;
    }
}
