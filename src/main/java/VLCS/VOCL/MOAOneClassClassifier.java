package VLCS.VOCL;

import moa.classifiers.meta.WEKAClassifier;
import weka.classifiers.Classifier;
import weka.classifiers.meta.OneClassClassifier;
import weka.core.Capabilities;
import weka.core.Instance;
import weka.core.Instances;

/**
 * Created by xavier on 8/06/17.
 *
 * This class allows us to use the OneClassClassifier in WEKA in MOA.
 */
public class MOAOneClassClassifier extends WEKAClassifier implements Classifier {

    public MOAOneClassClassifier() {
        this.classifier = new OneClassClassifier();
    }

    @Override
    public void buildClassifier(Instances instances) throws Exception {
        this.classifier.buildClassifier(instances);
    }

    @Override
    public double classifyInstance(Instance instance) throws Exception {
        return this.classifier.classifyInstance(instance);
    }

    @Override
    public double[] distributionForInstance(Instance instance) throws Exception {
        return this.classifier.distributionForInstance(instance);
    }

    @Override
    public Capabilities getCapabilities() {
        return this.classifier.getCapabilities();
    }

    /**
     * WEKA specific method that's unimplemented in MOA.
     * @param label
     */
    public void setTargetClassLabel(String label) {
        ((OneClassClassifier)this.classifier).setTargetClassLabel(label);
    }

    /**
     * WEKA specific method that's unimplemented in MOA.
     * @return
     */
    public String getTargetClassLabel() {
        return ((OneClassClassifier)this.classifier).getTargetClassLabel();
    }
}
