package de.denisthiessen.base;

import java.util.Arrays;
import java.util.List;


public class SignalCalculatorExecutor
{
    public static void main(String[] args)
    {
        List<Integer> signalList1 = Arrays.asList(0, 0, -2, 2, 0, -2, 0, 2);
        List<Integer> signalList2 = Arrays.asList(0, 2, 2, 2, 0, 4, -2, 2);
        List<Integer> signalList3 = Arrays.asList(2, 0, 2, -2, 0, 2, 0, 2);
        
        List<Integer> stationList1 = Arrays.asList(-1, -1, -1, 1, 1, -1, 1, 1);
        List<Integer> stationList2 = Arrays.asList(-1, -1, 1, -1, 1, 1, 1, -1);
        List<Integer> stationList3 = Arrays.asList(-1, 1, -1, 1, 1, 1, -1, -1);

        CDMASignalCalculator calculator = new CDMASignalCalculator(signalList1);
        System.out.println(calculator.getCurrentSignalValue());
        
        calculator.addToSignal(signalList2);
        System.out.println(calculator.getCurrentSignalValue());
        
        calculator.addToSignal(signalList3);
        System.out.println(calculator.getCurrentSignalValue());
               
        CDMASignalResult signalResult1 = calculator.calculateSignalResult(stationList1);
        CDMASignalResult signalResult2 = calculator.calculateSignalResult(stationList2);
        CDMASignalResult signalResult3 = calculator.calculateSignalResult(stationList3);
               
        System.out.println("Signal Result for First List:\n" + signalResult1.toString());
        System.out.println("Signal Result for Second List:\n" + signalResult2.toString());
        System.out.println("Signal Result for Third List:\n" + signalResult3.toString());
    }
}
