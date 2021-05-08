package de.denisthiessen.base;

public enum CDMASignalResult
{
        ONE_SENT(1), ZERO_SENT(-1), NOTHING_SENT(0);

    private int signalResult;

    private CDMASignalResult(int signalResult)
    {
        this.signalResult = signalResult;
    }

    public int getSignalValue()
    {
        return signalResult;
    }

    @Override
    public String toString()
    {
        switch (signalResult)
        {
            case 1:
                return "One got sent.";
            case 0:
                return "Nothing got sent.";
            case -1:
                return "Zero got sent.";
            default:
                return "Invalid Signal Result.";
        }
    }

    public static CDMASignalResult getSignalValueFromResult(int signalResult)
    {
        for (CDMASignalResult iteratedResult : values())
        {
            if (iteratedResult.getSignalValue() == signalResult)
            {
                return iteratedResult;
            }
        }

        throw new IllegalArgumentException(
                "Signal Result of " + signalResult + " cannot be resolved.");
    }
}
