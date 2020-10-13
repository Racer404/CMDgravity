package orbitSpeed;

public class CMDgraphics {
	String[][] window;
	//constructor
	public CMDgraphics(int width,int height) {
		window=new String[100][100];
		for (int i = 0; i < window.length; i++) {
			for (int j = 0; j < window[i].length; j++) {
				window[i][j]="  ";
			}
		}
	}
	
	//refresh CMD
	public void updateFrames(double OX,double OY,double PX,double PY) {
		window[(int) (PY/10)][(int) (PX/10)]="P";
		window[(int) (OY/10)][(int) (OX/10)]="O";
			for (int i = window.length-1; i >=0 ; i--) {
					System.out.println();
				for (int j = 0; j < window[i].length; j++) {
					System.out.print(window[i][j]);
				}
			}
	}
}
