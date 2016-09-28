import java.util.Set;
import java.util.HashSet;

public class Jogo {
	
	Nave nave = new Nave();
	
	Set<Asteroide> asteroides = new HashSet<Asteroide>();
	//Set<Tiro> ListaTiros = new HashSet<Tiro>();
	int score = 0;
	int vidas = 3;
	
	public Jogo(){
		
		for(int i = 0; i < 6; i++){
			Asteroide asteroide = new Asteroide(this);
			asteroides.add(asteroide);
		}
	}
	
	public String getTitulo(){
		return "Asteroids";
	}
	public int getLargura(){
		return 800;
	}
	public int getAltura(){
		return 600;
	}
	
	
	public void tique(Set<String> teclas, double dt){
		
		for(Asteroide asteroide : this.asteroides){
			asteroide.mover(dt, this);
		}
		
		if(teclas.contains("up")){
			nave.ligado = true;
			nave.acelerar(dt);
		}
		else {
			nave.ligado = false;
		}
		
		if(teclas.contains("left")){
			nave.esquerda(dt);
		}
		if(teclas.contains("right")){
			nave.direita(dt);
		}
		nave.mover(dt, this);
	}
	
	
	public void tecla(String tecla){
		/*if(vidas==0){
			return;
		}
		
		if(tecla.equals(" ")){
			ListaTiros.add(new Tiro(nave));
			Motor.tocar("shoot.wav");
		}*/
	}
	
	
	public void desenhar(Tela tela){
		
		for(Asteroide asteroide : this.asteroides){
			asteroide.desenhar(tela);
		}
		
		if(vidas==0){
			tela.texto(String.format("FIM DE JOGO"), 150, 250, 65, Cor.BRANCO);
		}
		
		else{
			tela.texto(String.format("%d", score), 20, 35, 30, Cor.BRANCO);
			tela.texto(String.format("%d", vidas), 750, 35, 30, Cor.BRANCO);
			
			nave.desenhar(tela);
		}
	}
	
	
	public static void main(String[] args){
		new Motor(new Jogo());
	}
	
	
}
