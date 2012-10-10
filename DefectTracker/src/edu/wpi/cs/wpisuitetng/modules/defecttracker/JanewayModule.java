package edu.wpi.cs.wpisuitetng.modules.defecttracker;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import edu.wpi.cs.wpisuitetng.janeway.models.IJanewayModule;
import edu.wpi.cs.wpisuitetng.janeway.models.JanewayTabModel;
import edu.wpi.cs.wpisuitetng.modules.defecttracker.controllers.MainTabController;
import edu.wpi.cs.wpisuitetng.modules.defecttracker.controllers.ToolbarController;
import edu.wpi.cs.wpisuitetng.modules.defecttracker.views.MainTabView;
import edu.wpi.cs.wpisuitetng.modules.defecttracker.views.ToolbarView;

/**
 * This is where the module can define what's necessary to work correctly in Janeway.
 * The module consists of a single "Defects" tab.
 */
public class JanewayModule implements IJanewayModule {

	private ArrayList<JanewayTabModel> tabs;
	public MainTabController mainTabController;
	public ToolbarController toolbarController;
	
	public JanewayModule() {
		MainTabView mainTabView = new MainTabView();
		mainTabController = new MainTabController(mainTabView);
		
		ToolbarView toolbarView = new ToolbarView(this);
		toolbarController = new ToolbarController(toolbarView, this);
		
		tabs = new ArrayList<JanewayTabModel>();
		JanewayTabModel tab = new JanewayTabModel("Defects", new ImageIcon(), toolbarView, mainTabView);
		tabs.add(tab);
	}
	
	@Override
	public String getName() {
		return "Defect Tracker";
	}

	@Override
	public ArrayList<JanewayTabModel> getTabs() {
		return tabs;
	}

}