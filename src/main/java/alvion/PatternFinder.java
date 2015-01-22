package alvion;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by mbondar on 1/20/2015.
 */
public class PatternFinder {

    public PatternFinder(List<String> inputValues)
    {
        _data = inputValues;
    }

    public List<String> _data;


    public ArrayList<String> MatchPatternList(String inputPattern)
    {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> inputPatternList = SplitStringByUpperCaseLetter(inputPattern);

        for(String  item : _data)
        {
            if (MatchPattern(item, inputPatternList))
            {
                result.add(item);
            }
        }

        return result;
    }


    private ArrayList<String> SplitStringByUpperCaseLetter(String inputString)
    {
        ArrayList<String> result = new ArrayList<String>();

        char[] charArray = inputString.toCharArray();

        ArrayList<Integer> upperCaseIndexes =  new ArrayList<Integer>();
        for (int i = 0; i < charArray.length ; i++)
        {
            if (Character.isUpperCase(charArray[i]))
            {
              upperCaseIndexes.add(i);
            }
        }

        //boolean isStartWithCapital = false;
        boolean isEndWithCapital = false;

        if (!IsArrayContainsElement(upperCaseIndexes, 0))
        {
            upperCaseIndexes.add(0);
        }
       /* else
        {
            isStartWithCapital = true;
        }*/

        if (!IsArrayContainsElement(upperCaseIndexes, charArray.length - 1))
        {
            upperCaseIndexes.add(charArray.length - 1);
        }
        else
        {
            isEndWithCapital = true;
        }
        Collections.sort(upperCaseIndexes);

        int startIndex;
        int endIndex;

        for (int i = 0; i < upperCaseIndexes.size(); i++)
        {
            startIndex = upperCaseIndexes.get(i);
            if (i == upperCaseIndexes.size() - 1)
            {
                if (isEndWithCapital)
                    endIndex = upperCaseIndexes.get(i) + 1;
                else
                {
                    endIndex =  0;
                    break;
                }
            }
            else
            {
                if (!isEndWithCapital && i == upperCaseIndexes.size() - 2)
                    endIndex = upperCaseIndexes.get(i+1) + 1;
                else
                    endIndex = upperCaseIndexes.get(i+1);
            }

            if (endIndex != 0)
            {
                result.add(inputString.substring(startIndex, endIndex));
            }
        }
        return result;
    }

    private boolean MatchPattern(String item, ArrayList<String> inputPatternList)
    {
        int matchCount = 0;
        int currentIndex = 0;
        ArrayList<String>  itemList = SplitStringByUpperCaseLetter(item);
        String pattern = inputPatternList.get(currentIndex);

        for(String  part : itemList)
        {
            if (part.contains(pattern))
            {
                matchCount++;
                if (currentIndex < inputPatternList.size() - 1)
                {
                    currentIndex++;
                    pattern = inputPatternList.get(currentIndex);

                }
            }
        }

        if (inputPatternList.size() <= matchCount)
            return true;
        else
            return false;

    }

    private boolean IsArrayContainsElement(ArrayList<Integer> array, int element)
    {
        for (int i = 0; i < array.size(); i++)
        {
            if (array.get(i) == element)
            {
                return true;
            }
        }
        return false;
    }

}
