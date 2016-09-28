public class Asteroide {
	int altura, largura;
	int ximagem, yimagem;
	
	double x; //= (double) (Math.random()*801);
	double y; //= (double) (Math.random()*601);
	Jogo jogo;
	Cor cor; //= new Cor(Math.random(), Math.random(), Math.random());
	
	int tamanho; //= (int) (Math.random()*5);
	
	double velx; //= (double) (Math.random()*301);
	double vely; //= (double) (Math.random()*301);
	double velrot; //= (double) (Math.random()*(2*Math.PI+1));
	
	boolean vida;
	
	
	
	/*public Asteroide(Nave nave){
		this.tamanho = (int) (Math.random()*5);
		
		this.x = (double) (Math.random()*801);
		this.y = (double) (Math.random()*601);
		
		this.velx = (double) (Math.random()*301);
		this.vely = (double) (Math.random()*301);
		this.cor = new Cor(Math.random(), Math.random(), Math.random());
		this.velrot = (double) (Math.random()*(2*Math.PI+1));
		this.angulo = 0;
		this.vida = true;
	}*/
	
	public Asteroide(int tamanho, double x, double y, double velx, double vely){
		this.x = x;
		this.y = y;
		this.velx = velx;
		this.vely = vely;
		this.tamanho = tamanho;
		//this.velrot
		this.vida = true;
	}
	
	public Asteroide(Jogo jogo){
		this.jogo = jogo;
		this.x = (double) (Math.random()*801);
		this.y = (double) (Math.random()*601);
		this.cor = new Cor(Math.random(), Math.random(), Math.random());
		
		this.tamanho = (int) (Math.random()*4)+1;
		
		this.velx = (double) (Math.random()*301);
		this.vely = (double) (Math.random()*301);
		this.velrot = (double) (Math.random()*(2*Math.PI+1));
		this.vida = true;
	}
	
	
	
	public void mover(double dt, Jogo jogo){
		if(!vida) {
			return;
		}
		
		x += velx*dt;
		y += vely*dt;
		velrot += (Math.random()*(2*Math.PI+1))*dt;
		if(x >= jogo.getLargura()){
			x = 0;
		}
		else if(x <= 0){
			x = jogo.getLargura();	
		}
		if(y >= jogo.getAltura()){
			y = 0;
		}
		else if(y <= 0){
			y = jogo.getAltura();
		}
	
		
	}
	
	public void desenhar(Tela t){
		if(!vida){
			return;
		}
		switch(tamanho){
			case 1:
				ximagem = 4;
				altura = largura = 8;
				break;
			case 2:
				ximagem = 17;
				altura = largura = 15;
				break;
			case 3:
				ximagem = 32;
				altura = largura = 32;
				break;
			case 4:
				ximagem = 65;
				altura = largura = 47;
				break;
		}
		t.imagem("asteroids.png", ximagem, yimagem, largura, altura, velrot, x, y);
	}
}
