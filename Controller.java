/**
 * Do not modify this file without permission from your TA.
 **/
 import java.awt.event.*;
 
public class Controller implements ActionListener{
//key listener goes in the controller
	private Model model;
	private View view;
	
	public Controller(){
		view = new View();
		model = new Model(view.getPicSize(), view.getFrameStartSize());
	}
	
        //run the simulation
	public void start(){
		for(int i = 0; i < 5000; i++)
		{
			//increment the x and y coordinates, alter direction if necessary
			model.updateLocationAndDirection();
			//update the view
			view.update(model.getX(), model.getY(), model.getDirect());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(model.getBtnlock() == 0) {
			model.stopAction();
			view.setFrameLock(0);
		}
		else if(model.getBtnlock() == 1) {
			model.goAction();
			view.setFrameLock(1);
		}
	}
	
	public View getView() {
		return view;
	}
}
