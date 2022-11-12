import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor implements ActionListener {
    JFrame frame;
    //declared menubar for the text editor which will contain the file ans edit menu
    JMenuBar menuBar;
    //declaring hte file nad edit menu
    JMenu file, edit;
    //declaring items for file menu
    JMenuItem newFile, openFile, saveFile;
    //declaring items for edit menu
    JMenuItem cut, copy, paste,clear, selectAll, close;

    JTextArea textArea;
    TextEditor(){
        //initialised the frame
        frame = new JFrame();

        //intinalizong menu
        menuBar = new JMenuBar();

        file = new JMenu("File");
        edit = new JMenu("Edit");
        //initializing the text area
        textArea = new JTextArea();

        //intinalising the menu itesms
        newFile = new JMenuItem("New File");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save");
        cut= new JMenuItem("Cut");
        copy= new JMenuItem("Copy");
        paste= new JMenuItem("Paste");
        selectAll= new JMenuItem("Select All");
        close = new JMenuItem("Close");
        clear = new JMenuItem("Clear");
        //adding actionlister to all the menu items so that we can perform an operation if they are clicked;
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);
        clear.addActionListener(this);
        //adding the coponents to the file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);



        //adding the coponents to the Edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(clear);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(close);

        //adding file and edit menu to manu bar
        menuBar.add(file);
        menuBar.add(edit);

        //adding the components to the frame
        frame.add(textArea);
        frame.setJMenuBar(menuBar);

        frame.setBounds(10,10,400,400);
        frame.setVisible(true);
        frame.setTitle("Text Editor");
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==newFile){
            textArea.append("hello this is broken");
        }
        if (e.getSource()==saveFile){

        }
        if (e.getSource()==openFile){

        }
        if (e.getSource()==cut){
            textArea.cut();
        }
        if (e.getSource()==copy){
            textArea.copy();
        }
        if (e.getSource()==paste){
            textArea.paste();
        }
        if (e.getSource()==clear){
            textArea.setText("");
        }
        if (e.getSource()==selectAll){
            textArea.selectAll();
        }
        if (e.getSource()==close){

        }
    }
}
