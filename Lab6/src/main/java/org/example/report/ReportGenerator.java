package org.example.report;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.example.dao.MovieDao;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {

    public void generate() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        MovieDao movieDao = new MovieDao();
        Map<String, Object> templateData = new HashMap<>();
        templateData.put("movies", movieDao.getMovieReportData());

        Template template = cfg.getTemplate("movies.ftl");
        File outputFile = new File("movie_report.html");

        try (Writer fileWriter = new FileWriter(outputFile)) {
            template.process(templateData, fileWriter);
        }


        if (Desktop.isDesktopSupported() && outputFile.exists()) {
            Desktop.getDesktop().open(outputFile);
        }
    }
}