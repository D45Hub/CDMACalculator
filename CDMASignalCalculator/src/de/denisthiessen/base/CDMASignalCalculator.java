package de.denisthiessen.base;

import java.util.List;


public class CDMASignalCalculator
{
    private List<Integer> incomingSignal;

    public CDMASignalCalculator(List<Integer> incomingList)
    {
        this.incomingSignal = incomingList;
    }

    public void addToSignal(List<Integer> addedSignal)
    {
        checkEqualLengthList(incomingSignal, addedSignal);

        for (int i = 0; i < incomingSignal.size(); i++)
        {
            incomingSignal.set(i, incomingSignal.get(i) + addedSignal.get(i));
        }
    }

    public CDMASignalResult calculateSignalResult(List<Integer> stationCodes)
    {
        int signalResultValue = calculateSignalResultValue(incomingSignal, stationCodes);
        return CDMASignalResult.getSignalValueFromResult(signalResultValue);
    }
    
    public String getCurrentSignalValue() 
    {
        return incomingSignal.toString();
    }

    private int calculateSignalResultValue(List<Integer> signal, List<Integer> station)
    {
        checkEqualLengthList(signal, station);

        int listLength = signal.size();
        int result = 0;

        for (int i = 0; i < listLength; i++)
        {
            result += (signal.get(i) * station.get(i));
        }

        result /= listLength;

        return result;
    }

    private void checkEqualLengthList(List<Integer> signal, List<Integer> station)
    {
        if (signal.size() != station.size())
        {
            throw new IllegalArgumentException("Signal and Station are not equally long");
        }
    }
}
