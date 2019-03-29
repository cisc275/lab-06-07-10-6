/**
 * Do not modify this file without permission from your TA.
 **/
 import java.awt.event.*;
 
public class Controller implements ActionListener, KeyListener{
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
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_F) {
			if (view.getFireLock() == 0) {
				model.stopAction();
				view.setOrcAction(1);
				view.setFireLock(1);
				if (view.getJumpLock() == 1) {
					view.setJumpLock(0);
				}
			}
			else if (view.getFireLock() == 1) {
				model.goAction();
				view.setOrcAction(0);
				view.setFireLock(0);
			}
		}
		else if (key == KeyEvent.VK_J) {
			if (view.getJumpLock() == 0) {
				view.setOrcAction(2);
				view.setJumpLock(1);
				if (view.getFireLock() == 1) {
					model.goAction();
					view.setFireLock(0);
				}
			}
			else if (view.getJumpLock() == 1) {
				view.setOrcAction(0);
				view.setJumpLock(0);
			}
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e) {}
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
