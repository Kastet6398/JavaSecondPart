package com.example.demo4.models;

import com.example.demo4.utils.ChooseFileOperation;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ChooseFileModel extends BaseModel<String> {

    public ChooseFileModel() {
        super(null);
        setArg("fileTypes", new ArrayList<HashMap<String, String>>());
    }

    @Override
    public String execute() {
        FileChooser fileChooser = new FileChooser();
        File file;
        Object fileTypes = args.getOrDefault("fileTypes", new ArrayList<HashMap<String, String>>());
        if (fileTypes instanceof ArrayList<?> arrayList) {
            @SuppressWarnings("unchecked")
            ArrayList<HashMap<String, String>> fileTypesToIterate = (ArrayList<HashMap<String, String>>) arrayList;
            for (HashMap<String, String> each : fileTypesToIterate)
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter((String) each.keySet().toArray()[0], each.get((String) each.keySet().toArray()[0])));
            if (args.getOrDefault("type", ChooseFileOperation.OPEN) == ChooseFileOperation.SAVE)
                file = fileChooser.showSaveDialog(null);
            else file = fileChooser.showOpenDialog(null);
            if (file == null) return null;
            return file.getAbsolutePath();
        }
        throw new IllegalArgumentException("Invalid fileTypes");
    }
}
