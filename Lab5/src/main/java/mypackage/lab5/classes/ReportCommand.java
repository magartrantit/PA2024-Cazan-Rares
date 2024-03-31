package mypackage.lab5.classes;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import mypackage.lab5.classes.Repository;
import mypackage.lab5.interfaces.Command;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private Repository repository;

    // Constructor
    public ReportCommand(Repository repository) {
        this.repository = repository;
    }

    // Metoda pentru generarea unui raport
    @Override
    public void execute() throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File("templates/"));
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("report.ftl");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("files", repository.getFiles());

        try (Writer fileWriter = new FileWriter(new File("report.html"))) {
            template.process(templateData, fileWriter);
        } catch (TemplateException e) {
            throw new IOException("Error generating report", e);
        }

        Desktop.getDesktop().open(new File("report.html"));
    }
}