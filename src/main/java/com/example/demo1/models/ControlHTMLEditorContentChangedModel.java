package com.example.demo1.models;

import com.example.demo1.records.Task;
import javafx.scene.web.HTMLEditor;

import java.util.List;

public class ControlHTMLEditorContentChangedModel extends BaseModel {
    private final List<HTMLEditor> editors;
    private final String[] prev;
    private final List<Task> data;
    private final BaseModel[] models;

    public ControlHTMLEditorContentChangedModel(List<HTMLEditor> editors, List<Task> data) {
        super(null);
        this.editors = editors;
        this.data = data;
        models = new BaseModel[editors.size()];
        prev = new String[editors.size()];
    }

    public Object execute() {
        try {
            for (HTMLEditor editor : editors) {
                if (models[editors.indexOf(editor)] == null)
                    models[editors.indexOf(editor)] = new EditModel(data.get(editors.indexOf(editor)).id(), editor);

                if (prev[editors.indexOf(editor)] == null || !prev[editors.indexOf(editor)].equals(editor.getHtmlText())) {
                    prev[editors.indexOf(editor)] = editor.getHtmlText();
                    models[editors.indexOf(editor)].execute();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
