public class Word {
    private String word;
    private int vowels;
    private int consoants;
    
    public Word(String aWord){
        this.analyzeWord(aWord);
    }
    private void analyzeWord(String aWord){
        if(aWord == null)
            return;
        this.word = aWord;
        aWord = aWord.toLowerCase();
        int count = 0;
        for(int i=0;i<aWord.length();i++){
            if(aWord.charAt(i) =='a' || aWord.charAt(i) == 'e' || aWord.charAt(i) == 'i' ||
                aWord.charAt(i) == 'o' || aWord.charAt(i) == 'u' || aWord.charAt(i) == 'y'){
                    count++;
                }
        }
        this.vowels = count;
        this.consoants = aWord.length() - count;
    }
    public String getWord(){
        return this.word;
    }
    public int getVowels(){
        return this.vowels;
    }
    public int getConsonants(){
        return this.consoants;
    }
}
