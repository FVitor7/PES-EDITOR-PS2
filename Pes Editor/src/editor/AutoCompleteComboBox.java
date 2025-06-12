package editor;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AutoCompleteComboBox extends JComboBox {
    private static final long serialVersionUID = 1L;
    private List<CallnameEntry> entries;
    private JTextField editorField;

    public AutoCompleteComboBox(List<CallnameEntry> entries) {
        super(entries.toArray());
        this.entries = entries;
        setEditable(true);
        editorField = (JTextField) getEditor().getEditorComponent();
        editorField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { update(); }
            public void removeUpdate(DocumentEvent e) { update(); }
            public void changedUpdate(DocumentEvent e) { update(); }
        });
    }

    private void update() {
        String text = editorField.getText().toUpperCase();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (CallnameEntry e : entries) {
            if (e.playerName.toUpperCase().startsWith(text)) {
                model.addElement(e);
            }
        }
        setModel(model);
        editorField.setText(text);
        setPopupVisible(model.getSize() > 0);
    }
}
