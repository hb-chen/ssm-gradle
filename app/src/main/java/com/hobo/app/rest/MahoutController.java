package com.hobo.app.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hobo.app.mahout.recommendation.ItemCF;
import com.hobo.app.mahout.recommendation.UserCF;
import com.hobo.app.mahout.recommendation.book.BookEvaluator;
import com.hobo.app.mahout.recommendation.book.BookFilterGenderResult;
import com.hobo.app.mahout.recommendation.book.BookResult;
import com.hobo.app.mahout.recommendation.job.RecommenderFilterOutdateResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("MahoutController")
@RequestMapping("/api")
public class MahoutController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/BookFilterGender")
    public String BookFilterGender() {
        try {
            BookFilterGenderResult._main(null);
        } catch (Exception e) {
            logger.info(e.toString());
        }

        return "BookFilterGender";
    }

    @RequestMapping("/BookResult")
    public String BookResult() {
        try {
            BookResult._main(null);
        } catch (Exception e) {
            logger.info(e.toString());
        }

        return "BookResult";
    }

    @RequestMapping("/BookEvaluator")
    public String BookEvaluator() {
        try {
            BookEvaluator._main(null);
        } catch (Exception e) {
            logger.info(e.toString());
        }

        return "BookEvaluator";
    }

    @RequestMapping("/UserCF")
    public String UserCF() {
        try {
            UserCF._main(null);
        } catch (Exception e) {
            logger.info(e.toString());
        }

        return "BookEvaluator";
    }

    @RequestMapping("/UserCFMySQL")
    public String UserCFMySQL() {
        try {
            UserCF.mysqlDataSource();
        } catch (Exception e) {
            logger.info(e.toString());
        }

        return "BookEvaluator";
    }

    @RequestMapping("/ItemCF")
    public String ItemCF() {
        try {
            ItemCF._main(null);
        } catch (Exception e) {
            logger.info(e.toString());
        }

        return "BookEvaluator";
    }

    @RequestMapping("/RecommenderFilterOutdate")
    public String RecommenderFilterOutdate() {
        try {
            RecommenderFilterOutdateResult._main(null);
        } catch (Exception e) {
            logger.info(e.toString());
        }

        return "RecommenderFilterOutdate";
    }
}
