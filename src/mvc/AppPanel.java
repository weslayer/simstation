/**
 * Apppanel.java
 *
 * @author Jon Pearce
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro     03/10/2025: Created File
 *      All        03/15/2025: Edit the file
 *      Rustico    03/16/2025: Finished editing the file
 */
package mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

// AppPanel is the MVC controller
public class AppPanel extends JPanel implements Subscriber, ActionListener {

    protected Model model;
    protected AppFactory factory;
    protected View view;
    protected JPanel controlPanel;
    private JFrame frame;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;

    public AppPanel(AppFactory factory) {
        this.model = factory.makeModel();
        this.factory = factory;
        this.view = factory.makeView(this.model);
        this.controlPanel = new JPanel();
        this.model.subscribe(this);

        frame = new SafeFrame();
        frame.setLayout(new BorderLayout());
        Container cp = frame.getContentPane();
        cp.add(this);
        cp.add(this.controlPanel, BorderLayout.WEST);
        cp.add(this.view, BorderLayout.EAST);
        frame.setJMenuBar(createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void display() {
        frame.setVisible(true);
    }

    public void update() {
        repaint();
    }

    public Model getModel() {
        return model;
    }

    // called by file/open and file/new
    public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);
        // view must also unsubscribe then resubscribe:
        view.setModel(this.model);
        model.changed();
        repaint();
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        // add file, edit, and help menus
        JMenu fileMenu = Utilities.makeMenu("File", new String[] { "New", "Save", "SaveAs", "Open", "Quit" }, this);
        result.add(fileMenu);

        JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);

        JMenu helpMenu = Utilities.makeMenu("Help", new String[] { "About", "Help" }, this);
        result.add(helpMenu);

        return result;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String cmmd = ae.getActionCommand();

            if (cmmd.equals("Save")) {
                Utilities.save(model, false);
            } else if (cmmd.equals("SaveAs")) {
                Utilities.save(model, true);
            } else if (cmmd.equals("Open")) {
                Model newModel = Utilities.open(model);
                if (newModel != null)
                    setModel(newModel);
            } else if (cmmd.equals("New")) {
                Utilities.saveChanges(model);
                setModel(factory.makeModel());
                // needed cuz setModel sets to true:
                model.setUnsavedChanges(false);
            } else if (cmmd.equals("Quit")) {
                Utilities.saveChanges(model);
                System.exit(0);
            } else if (cmmd.equals("About")) {
                Utilities.inform(factory.about());
            } else if (cmmd.equals("Help")) {
                Utilities.inform(factory.getHelp());
            } else { 
                Command command = this.factory.makeEditCommand(this.model, cmmd, this);
                command.execute();
            }
        }catch(

    Exception e)
    {
        handleException(e);
    }
    }

    protected void handleException(Exception e) {
        Utilities.error(e);
    }
}
