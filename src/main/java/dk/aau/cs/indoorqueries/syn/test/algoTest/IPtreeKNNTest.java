package dk.aau.cs.indoorqueries.syn.test.algoTest;

import dk.aau.cs.indoorqueries.common.algorithm.IPtree_KNN;
import dk.aau.cs.indoorqueries.common.iDModel.GenTopology;
import dk.aau.cs.indoorqueries.common.iPTree.VIPTree;
import dk.aau.cs.indoorqueries.common.indoorEntitity.IndoorObject;
import dk.aau.cs.indoorqueries.common.indoorEntitity.IndoorSpace;
import dk.aau.cs.indoorqueries.common.indoorEntitity.Partition;
import dk.aau.cs.indoorqueries.common.indoorEntitity.Point;
import dk.aau.cs.indoorqueries.common.utilities.DataGenConstant;
import dk.aau.cs.indoorqueries.syn.datagenerate.ClassifyPartition;
import dk.aau.cs.indoorqueries.syn.datagenerate.DataGen;
import dk.aau.cs.indoorqueries.syn.datagenerate.ObjectGen;

import java.io.IOException;
import java.util.ArrayList;

/**
 * test KNNQ using IP-Tree
 * @author Tiantian Liu
 */
public class IPtreeKNNTest {
    public static void main(String[] arg) throws IOException {
        DataGen dataGen = new DataGen();
        dataGen.genAllData(DataGenConstant.dataType, DataGenConstant.divisionType);

        GenTopology genTopology = new GenTopology();
        genTopology.genTopology();

        ClassifyPartition classifyPartition = new ClassifyPartition();
        classifyPartition.classifyPar();

//        System.out.println(IndoorSpace.iCrucialPartitions.size());
        ObjectGen objectGen = new ObjectGen();
        objectGen.readObjects(500);

        VIPTree ipTree = VIPTree.createTree();
        ipTree.initTree();

        ipTree.objectPro();


        Point ps = new Point(20, 20, 0);
        Point pt = new Point(300, 700, 1);

        for (int i = 0; i < IndoorSpace.iObject.size(); i++) {
            IndoorObject ob = IndoorSpace.iObject.get(i);
            System.out.println("objectID: " + ob.getObjectId() + ", x: " + ob.getObjectX() + ", y: " + ob.getObjectY() + ", floor: " + ob.getoFloor() + ", parId: " + ob.getParId());
        }

        for (int i = 0; i < 32; i++) {
            Partition par = IndoorSpace.iPartitions.get(i);
            ArrayList<Integer> parObjects = par.getmObjects();
            System.out.println("parId: " + i + " parObjects: " + parObjects);
        }

        IPtree_KNN iPtree_knn = new IPtree_KNN();
        iPtree_knn.iptreeKNN(ps, 3, ipTree);


    }

}
