public class Nave {
	static int largura = 50;
	static int altura = 60;
	
	static int ximgnaveparada = 70;
	static int ximgnavemov = 135;
	static int yimgnave = 0;
	
	static double velocidade = 175;
	static double velocidademax = 400;
	
	double x, y;
	double velx, vely;
	double angulo;
	boolean ligado;
	
	//fazer colisoes;
	
	public Nave(){
		this.x = 400 - largura/2;
		this.y = 300 - altura/2;
		this.ligado = false;
		this.angulo = 0;
		this.velx = 0;
		this.vely = 0;
		
	}
	
	
	public void esquerda(double dt){
		angulo -= Math.PI*dt;
	}
	
	public void direita(double dt){
		angulo += Math.PI*dt;
	}
	
	
	public void acelerar(double dt){
		velx += dt*Math.sin(angulo)*velocidade;
		vely -= dt*Math.cos(angulo)*velocidade;
		
		if(velx >= velocidademax){
			velx = velocidademax;
		}
		else if(velx <= -velocidademax){
			velx = -velocidademax;
		}
		
		
		if(vely >= velocidademax){
			vely = velocidademax;
		}
		else if(vely <= -velocidademax){
			vely = -velocidademax;
		}
	}
	
	public void mover(double dt, Jogo jogo){
		x += velx*dt;
		y += vely*dt;
		
		if(x-largura/2 >= jogo.getLargura()){
			x = 0;
		}
		else if(x+largura/2 <= 0){
			x = jogo.getLargura();
		}
		
		
		if(y-altura/2 >= jogo.getAltura()){
			y = 0;
		}
		else if(y+altura/2 <= 0){
			y = jogo.getAltura();
		}
		
	}
	
	
	
	public void desenhar(Tela t){
		if(ligado){
			t.imagem("naves.png", ximgnavemov, yimgnave, largura, altura, angulo, x, y);
		}
		else{
			t.imagem("naves.png", ximgnaveparada, yimgnave, largura, altura, angulo, x, y);
		}
		
	}
}
