package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends Application implements ActionListener,KeyListener
{
    public TextArea textArea;
    static String newline = "\n";
JFrame f;
    static int newlineLength = newline.length();
    JPanel saveFileOptionWindow;
    JLabel fileLabel, dirLabel;
    JTextField fileName, dirName;
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root=new BorderPane();
        textArea =new TextArea();
root.setCenter(textArea);

        primaryStage.setTitle("Vim Text Editor");
       MenuBar main_menu=new MenuBar();
       Menu File=new Menu("File");
       Menu Edit=new Menu("Edit");
        Menu Tools=new Menu("Tools");
       Menu Syntax=new Menu("Syntax");
       Menu Buffers=new Menu("Buffers");
       Menu Options=new Menu("Options");
       MenuItem Open=new MenuItem("Open");
       MenuItem Splitopen=new MenuItem("Splitopen");
       MenuItem OpenTab=new MenuItem("OpenTab");
       MenuItem New=new MenuItem("New");
       MenuItem Close=new MenuItem("Close");
       MenuItem Save=new MenuItem("Save");
       MenuItem Saveas=new MenuItem("Save as");
       MenuItem Exit=new MenuItem("Exit");
       File.getItems().add(Open);
       File.getItems().add(Splitopen);
       File.getItems().add(New);
       File.getItems().add(Close);
       File.getItems().add(Save);
       File.getItems().add(Saveas);
       File.getItems().add(Exit);
       MenuItem Undo=new MenuItem("Undo");
       MenuItem Redo=new MenuItem("Redo");
       MenuItem Cut=new MenuItem("Cut");
       MenuItem Copy=new MenuItem("Copy");
       MenuItem Paste=new MenuItem("Paste");
       MenuItem PutBefore=new MenuItem("PutBefore");
       MenuItem PutAfter=new MenuItem("PutAfter");
       MenuItem Delete=new MenuItem("Delete");
       MenuItem Selectall=new MenuItem("Selectall");
       MenuItem Find=new MenuItem("Find");
       MenuItem FindandReplace=new MenuItem("FindandReplace");
       MenuItem SettingsWindows=new MenuItem("SwttingWindows");
       MenuItem StaartUpSettings=new MenuItem("StartUpSettings");
       Menu GlobalSettings=new Menu("GlobalSettings");
       MenuItem TogglePatternHighlight=new MenuItem("Toggle Pattern Highlight");
       MenuItem ToggleIgnoringCase=new MenuItem("Toggle Ignoring Case");
       MenuItem ToggleShowingMatchedPairs=new MenuItem("Toggle Showing Matched Pairs");
       MenuItem ContextLines=new MenuItem("Context Lines");
       MenuItem ToggleInsertMode=new MenuItem("Toggle Insert Mode");
       MenuItem ToggleViCompatibility=new MenuItem("Toggle Vi Compatibility");
       MenuItem SearchPath=new MenuItem("SearchPath");
       MenuItem TagFiles=new MenuItem("Tag Files");
       MenuItem ToggleToolBar=new MenuItem("Toggle Tool bar");
       MenuItem ToggleBottomScrollBar=new MenuItem("Toggle Bottom ScrollBar");
       MenuItem ToggleLeftScrollBar=new MenuItem("Toggle Left ScrollBar ");
GlobalSettings.getItems().add(TogglePatternHighlight);
GlobalSettings.getItems().add(ToggleIgnoringCase);
GlobalSettings.getItems().add(ToggleShowingMatchedPairs);
GlobalSettings.getItems().add(ContextLines);
GlobalSettings.getItems().add(ToggleInsertMode);
GlobalSettings.getItems().add(ToggleViCompatibility);
     GlobalSettings.getItems().add(SearchPath);
       GlobalSettings.getItems().add(TagFiles);
       GlobalSettings.getItems().add(ToggleToolBar);
       GlobalSettings.getItems().add(ToggleBottomScrollBar);
       GlobalSettings.getItems().add(ToggleLeftScrollBar);
       Menu FileSettings=new Menu("File Settings");
       MenuItem ToggleLineNmbering=new MenuItem("Toggle Line Numbering");
       MenuItem ToggleRelativeLineNumbering=new MenuItem("Toggle Relative Line Numbering");
       MenuItem ToggleListMode=new MenuItem("Toggle List Mode");
       MenuItem ToggleLineWrapping=new MenuItem("Toggle Line Wrapping");
       MenuItem ToggleTabExpanding=new MenuItem("Toggle Tab Expanding");
       MenuItem ToggleAutoIndexing=new MenuItem("Toggle Auto Indexing");
       MenuItem TextWidth=new MenuItem("Toggle Text Width");
FileSettings.getItems().add(ToggleLineNmbering);
FileSettings.getItems().add(ToggleRelativeLineNumbering);
FileSettings.getItems().add(ToggleListMode);
FileSettings.getItems().add(ToggleLineWrapping);
FileSettings.getItems().add(ToggleTabExpanding);
FileSettings.getItems().add(ToggleAutoIndexing);
FileSettings.getItems().add(TextWidth);
Menu Shiftwidth=new Menu("Shift Width");
MenuItem T=new MenuItem("2");
       MenuItem te=new MenuItem("3");
       MenuItem ch=new MenuItem("4");
       MenuItem pan=new MenuItem("5");
       MenuItem six=new MenuItem("6");
       MenuItem ath=new MenuItem("8");
       Shiftwidth.getItems().add(T);
       Shiftwidth.getItems().add(te);
       Shiftwidth.getItems().add(ch);
       Shiftwidth.getItems().add(pan);
       Shiftwidth.getItems().add(six);
       Shiftwidth.getItems().add(ath);
       Menu SoftTabStop=new Menu("Soft Tab Stop");
       FileSettings.getItems().add(SoftTabStop);
       MenuItem st=new MenuItem("2");
       MenuItem ste=new MenuItem("3");
       MenuItem sch=new MenuItem("4");
       MenuItem span=new MenuItem("5");
       MenuItem ssix=new MenuItem("6");
       MenuItem sath=new MenuItem("8");
       SoftTabStop.getItems().add(st);
       SoftTabStop.getItems().add(ste);
       SoftTabStop.getItems().add(sch);
       SoftTabStop.getItems().add(span);
       SoftTabStop.getItems().add(ssix);
       SoftTabStop.getItems().add(sath);
       MenuItem FileFormat=new MenuItem("File Format");
MenuItem SelectFont=new MenuItem("Select Font");
       FileSettings.getItems().add(Shiftwidth);
       FileSettings.getItems().add(FileFormat);
       Menu colorscheme=new Menu("color scheme");
MenuItem blue=new MenuItem("blue");
MenuItem darkblue=new MenuItem("darkblue");
MenuItem deffault=new MenuItem("default");
MenuItem desert=new MenuItem("desert");
MenuItem elfolrd=new MenuItem("elfolrd");
colorscheme.getItems().add(blue);
        colorscheme.getItems().add(darkblue);
        colorscheme.getItems().add(deffault);
        colorscheme.getItems().add(desert);
        colorscheme.getItems().add(elfolrd);
        Menu keymap=new Menu("Keymap");
        MenuItem None=new MenuItem("None");
        MenuItem accents=new MenuItem("accents");
        MenuItem arabic=new MenuItem("arabic");
        MenuItem armenianeastern=new MenuItem("armenian-eastern");
        MenuItem armenianwestern=new MenuItem("armenian-western");
        keymap.getItems().add(None);
        keymap.getItems().add(accents);
        keymap.getItems().add(arabic);
        keymap.getItems().add(armenianeastern);
        keymap.getItems().add(armenianwestern);
       Edit.getItems().add(Undo);
       Edit.getItems().add(Redo);
       Edit.getItems().add(Cut);

       Edit.getItems().add(Copy);
       Edit.getItems().add(Paste);
       Edit.getItems().add(PutBefore);
       Edit.getItems().add(PutAfter);
       Edit.getItems().add(Delete);
       Edit.getItems().add(Selectall);
       Edit.getItems().add(Find);
       Edit.getItems().add(FindandReplace);
       Edit.getItems().add(SettingsWindows);
       Edit.getItems().add(StaartUpSettings);
       Edit.getItems().add(GlobalSettings);
       Edit.getItems().add(FileSettings);
Edit.getItems().add(colorscheme);
Edit.getItems().add(keymap);
Edit.getItems().add(SelectFont);




        MenuItem Jumptothistag=new MenuItem("Jump To This Tag");
        MenuItem Jumpback=new MenuItem("Jump Back");
        MenuItem BuildTagsFile=new MenuItem("BuildTagsFile");


        Menu Spelling=new Menu("Spelling");
        MenuItem SpellCheckOn=new MenuItem("Spell Check On");
        MenuItem SpellCheckOff=new MenuItem("SpellCheckOff");
        MenuItem ToNextError=new MenuItem("To Next Errors");
        MenuItem ToPreviousErrors=new MenuItem("To Previous Errors");
        MenuItem SuggestCorrection=new MenuItem("Suggest Correction");
        MenuItem RepeatCorrection=new MenuItem("Repeat Correction");
        MenuItem SetLantoen=new MenuItem("Set language to en");
        MenuItem Setlantoenau=new MenuItem("Set language to en_au");
      Spelling.getItems().add(SpellCheckOn);
        Spelling.getItems().add(SpellCheckOff);
        Spelling.getItems().add(ToNextError);
        Spelling.getItems().add(ToPreviousErrors);
        Spelling.getItems().add(SuggestCorrection);
        Spelling.getItems().add(RepeatCorrection);
        Spelling.getItems().add(SetLantoen);
        Spelling.getItems().add(Setlantoenau);

        Menu Folding=new Menu("Folding");
        MenuItem EnableDisable=new MenuItem("Enable/Disable Folds");
        MenuItem viewcursorline=new MenuItem("View Cursor Line");
        MenuItem viewcursorlineonly=new MenuItem("View Cursor Line Only");
        MenuItem closemorefolds=new MenuItem("Close More Folds");
        MenuItem closeallfolds=new MenuItem("Close all Folds");
        MenuItem Openmorefolds=new MenuItem("Open More Folds");
        MenuItem Openallfolds=new MenuItem("Open all Folds");
        MenuItem FoldMethod=new MenuItem("FoldMethod");
        MenuItem createfold=new MenuItem("Create Fold");
        MenuItem deltefold=new MenuItem("Delete Fold");
        MenuItem deleteallfolds=new MenuItem("Delete All folds");
Folding.getItems().add(EnableDisable);
        Folding.getItems().add(viewcursorline);
        Folding.getItems().add(viewcursorlineonly);
        Folding.getItems().add(closemorefolds);
        Folding.getItems().add(closeallfolds);
        Folding.getItems().add(Openmorefolds);
        Folding.getItems().add(Openallfolds);
        Folding.getItems().add(FoldMethod);
        Folding.getItems().add(createfold);
        Folding.getItems().add(deltefold);
        Folding.getItems().add(deleteallfolds);
Menu Diff=new Menu("Diff");
MenuItem update=new MenuItem("update");
        MenuItem setblock=new MenuItem("Set Block");
        MenuItem PutBlock=new MenuItem("Put Block");
MenuItem Make=new MenuItem("Make");
MenuItem ListErrors=new MenuItem("Listerrors");
MenuItem ListMessage=new MenuItem("List Messages");
MenuItem Nexterrors=new MenuItem("Next Errors");
        MenuItem previouserrors=new MenuItem("Previous Errors");
        MenuItem olderlist=new MenuItem("Older List");
        MenuItem NewerList=new MenuItem("Newer List");
Menu errorwin=new Menu("Error Window");
MenuItem uppdate=new MenuItem("Update");
        MenuItem open=new MenuItem("Open");
        MenuItem close=new MenuItem("Close");
errorwin.getItems().add(update);
        errorwin.getItems().add(open);
        errorwin.getItems().add(close);
Menu setcompiler=new Menu("Set Compiler");
MenuItem bdf=new MenuItem("bdf");
MenuItem cargo=new MenuItem("cargo");
MenuItem context=new MenuItem("context");
MenuItem cs=new MenuItem("cs");
setcompiler.getItems().add(bdf);
        setcompiler.getItems().add(cargo);
        setcompiler.getItems().add(context);
        setcompiler.getItems().add(cs);
MenuItem convertohex=new MenuItem("Convert to Hex");
        MenuItem convertback=new MenuItem("Convert back");
        Tools.getItems().add(Jumptothistag);
        Tools.getItems().add(Jumpback);
        Tools.getItems().add(BuildTagsFile);
        Tools.getItems().add(Spelling);
        Tools.getItems().add(Folding);
Tools.getItems().add(Diff);
Tools.getItems().add(Make);
        Tools.getItems().add(Make);
        Tools.getItems().add(ListErrors);
        Tools.getItems().add(ListMessage);
        Tools.getItems().add(Nexterrors);
        Tools.getItems().add(previouserrors);
        Tools.getItems().add(olderlist);
        Tools.getItems().add(NewerList);
        Tools.getItems().add(errorwin);
Tools.getItems().add(setcompiler);
        Tools.getItems().add(convertohex);
        Tools.getItems().add(convertback);






        main_menu.getMenus().add(File);
       main_menu.getMenus().add(Edit);
        main_menu.getMenus().add(Tools);
       main_menu.getMenus().add(Syntax);
       main_menu.getMenus().add(Buffers);
       main_menu.getMenus().add(Options);






       root.setTop(main_menu);
       Scene sc=new Scene(root);
        sc.setOnKeyPressed(this::processkeyevent);
       primaryStage.setScene(sc);

       primaryStage.setWidth(500);
       primaryStage.setHeight(500);
       primaryStage.setTitle("Vim Text Editor");
       primaryStage.show();

Cut.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {
        textArea.cut();
    }
});
Copy.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {
        textArea.copy();
    }
});
Paste.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {
        textArea.paste();
    }
});
SelectFont.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {
        String sizeOfFont = JOptionPane.showInputDialog(f,"Enter Font Size",JOptionPane.OK_CANCEL_OPTION);
        if (sizeOfFont != null){
            int convertSizeOfFont = Integer.parseInt(sizeOfFont);
            Font fo = new Font(convertSizeOfFont);
            textArea.setFont(fo);
        }
    }
});
Open.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {
        JFileChooser chooseFile = new JFileChooser();
        int i = chooseFile.showOpenDialog(f);
        if (i == JFileChooser.APPROVE_OPTION){
            File file = chooseFile.getSelectedFile(); //select the file
            String filePath = file.getPath(); //get the file path
            String fileNameToShow = file.getName(); //get the file name
            f.setTitle(fileNameToShow);

            try {
                BufferedReader readFile = new BufferedReader(new FileReader(filePath));
                String tempString1 = "";
                String tempString2 = "";

                while ((tempString1 = readFile.readLine()) != null)
                    tempString2 += tempString1 + "\n";

                textArea.setText(tempString2);
                readFile.close();
            }catch (Exception ae){
                ae.printStackTrace();
            }
        }
    }
});
Save.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {
saveTheFile();
    }
});
textArea.setOnKeyPressed(this::processkeyevent);
    }

    private void processkeyevent(javafx.scene.input.KeyEvent event) {
        String type = event.getEventType().getName();
        KeyCode keyCode = event.getCode();
       // System.out.println("Type: " + type + " Code: " + keyCode);
        //textArea.setText("text");
        if (keyCode.equals(KeyCode.Y)) {
            System.out.println("Y Pressed");

//System.out.println(textArea.getCaretPosition());
            textArea.copy();
        }
    }



    public void saveTheFile(){
        saveFileOptionWindow = new JPanel(new GridLayout(2,1));
        fileLabel = new JLabel("Filename      :- ");
        dirLabel = new JLabel("Save File To :- ");
        fileName = new JTextField();
        dirName = new JTextField();

        saveFileOptionWindow.add(fileLabel);
        saveFileOptionWindow.add(fileName);
        saveFileOptionWindow.add(dirLabel);
        saveFileOptionWindow.add(dirName);

        JOptionPane.showMessageDialog(f,saveFileOptionWindow); //show the saving dialogue box
        String fileContent = textArea.getText();
        String filePath = dirName.getText();

        try {
            BufferedWriter writeContent = new BufferedWriter(new FileWriter(filePath));
            writeContent.write(fileContent);
            writeContent.close();
            JOptionPane.showMessageDialog(f,"File Successfully saved!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//Cut.setOnAction(e->textArea.cut());



    }

    @Override
    public void keyTyped(KeyEvent e) {
     if(e.getKeyCode()==KeyEvent.VK_Y)
         textArea.setText("Y Pressed");
         System.out.println("PRESSED");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_Y)
            textArea.setText("Y  Pressed");
            System.out.println("PRESSED");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}