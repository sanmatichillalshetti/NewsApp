#include "TrafficSystem.hpp"
#include <bits/stdc++.h>



int main()
{
    //create a traffic system.
    TrafficSystem system;
    Intersection* intersection1= system.createIntersection();

    Signal* signal1=system.addSignal(intersection1->getIntersectionId(),20,5,25);
    Signal* signal2=system.addSignal(intersection1->getIntersectionId(),20,5,25);

    //we can have a look if we javecrated inter and added signal to it.
    system.displaySystemStatus();

    //loop to disply diffreent signal at intersectn
    for(int i=0;i<10;i++){
        std::cout << "\nTime step " << i + 1 << ":" << std::endl;
        system.updateSystem(5);  // Update every 5 seconds
        system.displaySystemStatus();
        

    }
     // Simulate intersection failure
     std::cout << "\nSimulating intersection failure..." << std::endl;
     system.setIntersectionStatus(intersection1->getIntersectionId(), false);
     system.displaySystemStatus();
     
     // Restore intersection
     std::cout << "\nRestoring intersection..." << std::endl;
     system.setIntersectionStatus(intersection1->getIntersectionId(), true);
     system.synchronizeIntersection(intersection1->getIntersectionId());
     system.displaySystemStatus();
    return 0;
}
