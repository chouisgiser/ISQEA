package dk.aau.cs.indoorqueries.mzb.test.algoTest;

import dk.aau.cs.indoorqueries.common.algorithm.VIPtree_KNN;
import dk.aau.cs.indoorqueries.common.iDModel.GenTopology;
import dk.aau.cs.indoorqueries.common.iPTree.VIPTree;
import dk.aau.cs.indoorqueries.common.indoorEntitity.IndoorObject;
import dk.aau.cs.indoorqueries.common.indoorEntitity.IndoorSpace;
import dk.aau.cs.indoorqueries.common.indoorEntitity.Partition;
import dk.aau.cs.indoorqueries.common.indoorEntitity.Point;
import dk.aau.cs.indoorqueries.mzb.datagenerate.ClassifyPartition;
import dk.aau.cs.indoorqueries.mzb.datagenerate.MZBDataGenRead;
import dk.aau.cs.indoorqueries.mzb.datagenerate.ObjectGen;

import java.io.IOException;
import java.util.ArrayList;

/**
 * test KNNQ using VIP-Tree
 * @author Tiantian Liu
 */
public class VIPtreeKNNTest {
    public static void main(String[] arg) throws IOException {
        MZBDataGenRead dateGenReadMen = new MZBDataGenRead();
        dateGenReadMen.dataGen();

        GenTopology genTopology = new GenTopology();
        genTopology.genTopology();

        ClassifyPartition classifyPartition = new ClassifyPartition();
        classifyPartition.classifyPar();

//        System.out.println(IndoorSpace.iCrucialPartitions.size());
        ObjectGen objectGen = new ObjectGen();
        objectGen.readObjects(1500);

        VIPTree vipTree = VIPTree.createTree();
        vipTree.initVIPtree();

        vipTree.objectPro();


        Point ps = new Point(2, 12, 0);
        Point pt = new Point(15, 25, 13);

        VIPtree_KNN iPtree_knn = new VIPtree_KNN();
        iPtree_knn.vipTreeKNN(ps, 3, vipTree);

    }
}
