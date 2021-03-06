/*
filename: Internal
author: Sarah Higbee
group: SHWOZ
date: 26/03/14
*/

package TrainSimulator;

import java.util.Date;
import java.util.Random;

public class Internal
{
    public int crew;
    public int passengers;
    public int cars;
    //Mass in kg.
    public double engineMass = 8182.806;
    public double carMass = 8182.806;
    public double personMass = 90;
    public double totalMass;
    //miles per hour per second
    public double maxAcceleration = 1.1184681460272;
    public double maxDeceleration = 2.6843235504653;
    public double maxDecelEmerg = 40.1068360773085;
    public double decelBrake = 1.1184681460272;
    public double distanceTraveled;
    //W
    public double maxPower = 480000;    
    
    public Date dat = new Date();
    public long time = dat.getTime();
    public Random rand = new Random(time);

    public Internal()
    {
        this.crew = 10;
        this.passengers = 0;
        this.cars = 5;
        //One fifth of Bombardier Tram's mass. Assuming engine mass ~= car mass.
        //Which admittedly isn't a realistic assumption, but it scarcely matters.
        this.totalMass = engineMass + (crew + passengers)*personMass + carMass*cars;
        this.distanceTraveled = 0;
    }

    public void boardPassengers()
    {
        //nextInt(2) returns either 0 or 1.
        if (rand.nextInt(2) > 0)
        {
            passengers = passengers + rand.nextInt(11);
            //passenger limit based on Blackpool tram, since it has a good list of
            //stats on Wikipedia.
            if (passengers > 222)
            {
                passengers = 222;
            }
        }
        else
        {
            passengers = passengers - rand.nextInt(11);
            if (passengers < 0)
            {
                passengers = 0;
            }
        }
    }

    public double getTotalMass()
    {
        return engineMass + (crew + passengers)*personMass + carMass*cars;
    }
    
    
    public double getMaxPower()
    {
    	return maxPower;
    }
    
    public double getMaxDecelEmerg()
    {
        return maxDecelEmerg;
    }

    public double getMaxDeceleration()
    {
        return maxDeceleration;
    }
    
    public double getMaxAcceleration()
    {
        return maxAcceleration;
    }
}
