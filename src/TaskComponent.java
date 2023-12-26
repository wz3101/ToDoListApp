import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TaskComponent extends JPanel implements ActionListener{
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;
    
    public JTextPane getTaskField()
    {
        return taskField;
    }
    
    
    private JPanel parentPanel;
    
    public TaskComponent (JPanel parentPanel)
    {
        this.parentPanel =parentPanel;
        taskField = new JTextPane();
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");
        
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.addActionListener(this);
        
        deleteButton = new JButton ("X");
        deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
        deleteButton.addActionListener(this);
        
        add(checkBox);
        add(taskField);
        add(deleteButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (checkBox.isSelected())
       {
           String taskText = taskField.getText().replaceAll("<[^>]*>", "");
           taskField.setText("<html><s>"+ taskText + "</s></html>");
       }
       
       else if (!checkBox.isSelected())
       {
           String taskText = taskField.getText().replaceAll("<[^>]*>", "");
           taskField.setText(taskText);
       }
       
       if (e.getActionCommand().equalsIgnoreCase("X"))
       {
           parentPanel.remove(this);
           parentPanel.repaint();
           parentPanel.revalidate();
       }
    }
}