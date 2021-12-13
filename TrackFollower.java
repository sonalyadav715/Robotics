package robotics;
import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;

public class TrackFollower {
   public TrackFollower()
   {
       LegoRobot r=new LegoRobot();
       Gear g = new Gear();
       LightSensor ls = new LightSensor(SensorPort.S2);
       r.addPart(ls);
       r.addPart(g);
       while(true)
       {
          int pos = ls.getValue();
          if (pos==1000)
          {
              g.forward();
          }
          if(pos>50 && pos<1000)
          {
              g.rightArc(0.08);
          }
          System.out.println("Sensor value:"+pos);
          if(pos==0)
          {
              g.stop();
          }
       }
   }
       public static void main(String []arg)
       {
          new TrackFollower();
       }
       static
      {
         RobotContext.setStartPosition(80,452);
         RobotContext.useBackground("sprites/track.png");
      }
    
}

