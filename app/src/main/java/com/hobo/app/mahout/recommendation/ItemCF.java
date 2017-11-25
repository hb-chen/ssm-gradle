package com.hobo.app.mahout.recommendation;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Steven on 2017/7/12.
 */
public class ItemCF {

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 20;

    public static void _main(String[] args) throws IOException, TasteException {
        String file = "classpath:mahout/item.csv";
        DataModel model = new FileDataModel(ResourceUtils.getFile(file));
        ItemSimilarity item = new EuclideanDistanceSimilarity(model);
        ItemBasedRecommender r = new GenericItemBasedRecommender(model, item);
        LongPrimitiveIterator iter = model.getUserIDs();

        while (iter.hasNext()) {
            long uid = iter.nextLong();
            List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);

            System.out.printf("uid:%s", uid);
            for (RecommendedItem ritem : list) {
                System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
            }
            System.out.println();
        }

        iter = model.getItemIDs();
        while (iter.hasNext()) {
            long itemId = iter.nextLong();
            List<RecommendedItem> list = r.mostSimilarItems(itemId,RECOMMENDER_NUM);

            System.out.printf("itemId:%s", itemId);
            for (RecommendedItem ritem : list) {
                System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
            }
            System.out.println();
        }
    }
}

