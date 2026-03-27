package org.example.command;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.example.repository.Catalog;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        cfg.setClassForTemplateLoading(this.getClass(), "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("items", catalog.getResourceList());

        Template template = cfg.getTemplate("report.ftl");
        File outputFile = new File("report.html");
        Writer fileWriter = new FileWriter(outputFile);
        template.process(templateData, fileWriter);
        fileWriter.close();
        System.out.println("generated report");

        if (Desktop.isDesktopSupported() && outputFile.exists()) {
            Desktop.getDesktop().open(outputFile);
        }
    }
}