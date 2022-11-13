import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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


        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel panel = new JPanel();

        panel.setBorder( new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(0,0));

        //adding the components to the frame
        panel.add(scrollPane);
        frame.add(panel);
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
            TextEditor newTextEditor = new TextEditor();
        }
        if (e.getSource()==saveFile){
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\Sameer\\Desktop");
            fileChooser.setApproveButtonText("Save");
            int chooseOption = fileChooser.showSaveDialog(null);

            if(chooseOption == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");
                String filePath = file.getPath();
                try{
                    BufferedWriter outFile = new BufferedWriter(new FileWriter(file));
                    textArea.write(outFile);
                    outFile.close();
                }catch (Exception exception){
                    System.out.println(exception);
                }
            }

        }
        if (e.getSource()==openFile){
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\Sameer\\Desktop");
            int chooseOption = fileChooser.showOpenDialog(null);

            if(chooseOption == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filePath));
                    String intermediate , output="";
                    while ( (intermediate=br.readLine()) !=null){
                        output+= intermediate+"\n";
                    }
                    textArea.setText(output);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

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
            System.exit(0);
        }
    }
}
