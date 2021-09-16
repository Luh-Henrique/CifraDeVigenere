package cifradevigenere;

public class CifraDeVigenere {
    
    public String codifica(String mensagem, String key){
        char[] arrayMensagem = mensagem.toCharArray();
        char[] arrayKey = key.toCharArray();
        char[] cifra = new char[arrayMensagem.length];
        
        for(int i=0; i<arrayMensagem.length;i++){
                if(arrayMensagem[i] == ' ')
                cifra[i] = ' ';
            else{
                int aux = (char) (((arrayMensagem[i]-65 + arrayKey[i]-65)%26)+65);                
                cifra[i] = (char) (aux);
            }
        }
        
        return new String(cifra);
    }
    
    public String decodifica(String mensagem, String key){
        char[] arrayMensagem = mensagem.toCharArray();
        char[] arrayKey = key.toCharArray();
        char[] cifra = new char[arrayMensagem.length];
        
        for(int i=0; i<arrayMensagem.length;i++){
                if(arrayMensagem[i] == ' ')
                cifra[i] = ' ';
            else{
                int aux = (char) (((arrayMensagem[i]-65 - arrayKey[i]-65)%26)+65);                
               
                while(aux <65)
                    aux += 26;
                              
                cifra[i] = (char) (aux);
            }
        }
        
        return new String(cifra);
    }
    
    
    public static void main(String[] args) {
        CifraDeVigenere vig = new CifraDeVigenere();
        String mensagem = "wearediscoveredsaveyourself";
        String key = "deceptive";
        
        String codificado = vig.codifica(mensagem.toUpperCase(), vig.completaKey(key.toUpperCase(), mensagem.length()));
        System.out.println("Codificado: "+codificado);
        
        String decodificado = vig.decodifica(codificado.toUpperCase(), vig.completaKey(key.toUpperCase(), mensagem.length()));
        System.out.println("Decodificado: "+decodificado);
        
    }
    
    
    public String completaKey(String key, int tam){
        char[] atualKey = key.toCharArray();   
        char[] finalKey = new char[tam];
        int i=0, j=0;
        
        
        while(i<finalKey.length){
            finalKey[i] = atualKey[j] ;
            i++;
            j++;
            
            if(j==atualKey.length)
               j=0; 
        }
        
           return  new String(finalKey);   
        }
    }
