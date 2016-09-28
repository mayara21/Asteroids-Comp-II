public class Tiro {
	//static double velocidade = 100;
	static int raio = 1;
	Cor cor;
	static double posx, posy;
	static double velx, vely;
	boolean atirou;
	
	public Tiro(Nave nave){
		this.velx = 100*Math.cos(nave.angulo) + nave.velx;
		this.vely = 100*Math.sin(nave.angulo) + nave.vely;
		this.posx = nave.x;
		this.posy = nave.y;
		this.cor = new Cor(255, 255, 255);
		this.atirou = true;
	}
	
	public void desenhar(Tela t){
		t.circulo(posx, posy, raio, cor);
	}
}
