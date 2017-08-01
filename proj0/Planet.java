public class Planet {
	public double xxPos;	//Its current x position
	public double yyPos;	//Its current y position
	public double xxVel;	//current velocity in the x direction
	public double yyVel;	//current velocity in the y direction
	public double mass;    //Its mass
	public String imgFileName;    //The name of an image in the images directory that depicts the planet
	public double G = 6.67E-11;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;

	}
	/** clone p */
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;

	}

	public double calcDistance(Planet p2) {
		return  Math.sqrt(Math.pow(this.xxPos - p2.xxPos, 2) + Math.pow(this.yyPos - p2.yyPos, 2));
	}

	public double calcForceExertedBy(Planet p2) {
		return G * (this.mass * p2.mass) / Math.pow(this.calcDistance(p2), 2);
	}


	public double calcForceExertedByX(Planet p2) {
		return this.calcForceExertedBy(p2) * (p2.xxPos - this.xxPos) / this.calcDistance(p2);
	}

	public double calcForceExertedByY(Planet p2) {
		return this.calcForceExertedBy(p2) * (p2.yyPos - this.yyPos) / this.calcDistance(p2);
	}

	public double calcNetForceExertedByX(Planet[] planets) {
		double netForceX;
		netForceX = 0;
		
		for (int i=0; i < planets.length; i++) {
			if (!this.equals(planets[i])) {
				netForceX = netForceX + calcForceExertedByX(planets[i]);			
			}
		}

		/*

		如果遍历数组最好使用
			for(Planet p : planets) {
            	if(this.equals(p) == true){
                	continue;
           	 	} else {
					yNetForce += this.calcForceExertedByY(p);
           	 	}
     
        }



		*/
		return netForceX;
	}


	public double calcNetForceExertedByY(Planet[] planets) {
		double netForceY;
		netForceY = 0;
		
		for (int i=0; i < planets.length; i++) {
			if (!this.equals(planets[i])) {
				netForceY = netForceY + calcForceExertedByY(planets[i]);
			}
		}
		return netForceY;
	}

	public void update(double dt, double xf, double yf) {

		double ax = xf / this.mass;
		double ay = yf / this.mass;

		xxVel = xxVel + dt * ax;
   		yyVel = yyVel + dt * ay;
    	xxPos = xxPos + dt * xxVel;
    	yyPos = yyPos + dt * yyVel;
	}




















}
