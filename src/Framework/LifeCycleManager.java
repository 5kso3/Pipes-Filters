
package Framework;

import java.util.ArrayList;
import Components.Middle.MiddleFilter;
import Components.Sink.SinkFilter;
import Components.Source.SourceFilter;

public class LifeCycleManager {
    public static void main(String[] args) {
        try {
            CommonFilter studentFilter = new SourceFilter("data/Students.txt");
            CommonFilter courseFilter = new SourceFilter("data/Courses.txt");
            CommonFilter checkFilter = new CheckFilter(2);
            CommonFilter correctFilter = new SinkFilter("output/Correct.txt");
            CommonFilter wrongFilter = new SinkFilter("output/Wrong.txt");
            
            ArrayList<Filter> filterList = new ArrayList<Filter>();
            filterList.add(new Filter(courseFilter));
            filterList.add(new Filter(studentFilter));
            checkFilter.connectInputTo(filterList);
            
            filterList = new ArrayList<Filter>();
            filterList.add(new Filter(checkFilter, 0));
            correctFilter.connectInputTo(filterList);
            
            filterList = new ArrayList<Filter>();
            filterList.add(new Filter(checkFilter, 1));
            wrongFilter.connectInputTo(filterList);
            
            Thread studentThread = new Thread(studentFilter);
            Thread courseThread = new Thread(courseFilter);
            Thread checkThread = new Thread(checkFilter);
            Thread correctThread= new Thread(correctFilter);
            Thread wrongThread= new Thread(wrongFilter);
            
            studentThread.start();
            courseThread.start();
            checkThread.start();
            correctThread.start();
            wrongThread.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
