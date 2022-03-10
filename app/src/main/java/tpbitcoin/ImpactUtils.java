package tpbitcoin;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ImpactUtils {





    /**
     * computes the expected time (in seconds) for mining a block
     * @param hashrate: miner hashing capacity (hash/s)
     * @param difficultyAsInteger: block difficulty, as BigInteger (256 bits integer)
     * @return expected time in seconds before finding a correct block
     */
    // TODO
    public static BigInteger expectedMiningTime(double hashrate, BigInteger difficultyAsInteger){
        System.out.println("DIFF : " + difficultyAsInteger);
        System.out.println("LONG : " + difficultyAsInteger.longValue());
        BigInteger maxValue = new BigInteger("2").pow(256);
        System.out.println(maxValue);
        BigInteger expectedTries = maxValue.divide(difficultyAsInteger);
        return expectedTries.divide(BigDecimal.valueOf(hashrate).toBigInteger());
    }

    /**
     * Compute the total hashrate of the network given current difficulty level
     * @param difficultyAsInteger: difficulty level as 256bits integer
     * @return hashrate of the network in GH/s
     */
    // TODO
    public static BigInteger globalHashRate(BigInteger difficultyAsInteger){
        BigInteger averageNumberOfTries = new BigInteger("2").pow(256).divide(difficultyAsInteger);
        return averageNumberOfTries.divide(new BigInteger("600"));
    }

    /**
     * Compute the total energy consumption of the network
     * assuming each miner has the same hashrate, and consume the same power
     * @param minerHashrate: the hashrate of each miner, in GH/s
     * @param minerPower: the power consumption of each miner, in Watts
     * @param networkHashrate : the global hashrate of the network
     * @param duration : in second
     * @return energy consumed during duration, in kWh
     */
    // TODO
    public static BigInteger globalEnergyConsumption(BigInteger minerHashrate, long minerPower, BigInteger networkHashrate, long duration){
       BigInteger capictyHS = minerHashrate.multiply(new BigInteger("10").pow(12));
       BigInteger nbMiners = capictyHS.divide(networkHashrate);
       BigInteger totalPower = nbMiners.multiply(new BigInteger(String.valueOf(minerPower)));
       return totalPower.multiply(new BigInteger(String.valueOf(duration/1000)));
    }





}
