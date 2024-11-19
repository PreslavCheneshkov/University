#include <iostream>
#include <set>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

vector<char> getUniqueCharacters(string& inputString)
{
	vector<char> uniqueCharactersList;
	set<char> uniqueCharactersSet;
	for (int i = 0; i < inputString.size(); i++)
	{
		uniqueCharactersSet.insert(inputString[i]);
	}
	for (auto& character : uniqueCharactersSet)
	{
		uniqueCharactersList.push_back(character);
	}
	return uniqueCharactersList;
}

char getNextCharacter(char currentCharacter, vector<char>& uniqueCharacters)
{
	for (int i = 0; i < uniqueCharacters.size(); i++)
	{
		if (currentCharacter >= uniqueCharacters[i])
			continue;

		return uniqueCharacters[i];
	}
	return -1;
}

bool isLargestCharacter(char character, vector<char>& uniqueCharacters)
{
	return character == uniqueCharacters.at(uniqueCharacters.size() - 1);
}

string getActualInputString(string inputString, int targetStringLength, char smallestCharacter)
{
	int stringSize = inputString.size();
	if (targetStringLength == stringSize)
		return inputString;
	if (targetStringLength < stringSize)
	{
		return inputString.substr(0, targetStringLength);
	}
	stringstream ss;
	ss << inputString;

	for (int i = 0; i < targetStringLength - stringSize; i++)
		ss << smallestCharacter;
	return ss.str();
}

void handleInput(int& inputStringLength, string& inputString, int& outputStringLength)
{
	cin >> inputStringLength;
	cin >> inputString;
	cin >> outputStringLength;

	if (inputStringLength < 1 || inputStringLength > 100000 ||
		outputStringLength < 1 || outputStringLength > 100000 ||
		inputString.size() != inputStringLength)
	{
		cout << "\n\nInvalid input!\nValid input:\n1 <= n <= 100000\n1 <= k <= 100000\nInput string size must be equal to n!\nTry again!\n\n";
		exit(1);
	}
}

int main()
{
	int inputStringLength, outputStringLength;
	string inputString;
	handleInput(inputStringLength, inputString, outputStringLength);

	vector<char> uniqueCharacters = getUniqueCharacters(inputString);
	string actualString = getActualInputString(inputString, outputStringLength, uniqueCharacters.at(0));
	if (uniqueCharacters.size() == 1)
	{
		cout << actualString;
		exit(0);
	}

	int addedZeroCount = 0;
	bool concatRemainder = false;
	stringstream outputStringStream;
	for (int i = actualString.size() - 1; i >= 0; i--)
	{
		if (!concatRemainder)
		{
			if (isLargestCharacter(actualString[i], uniqueCharacters))
			{
				addedZeroCount++;
				continue;
			}
			while (addedZeroCount > 0)
			{
				outputStringStream << uniqueCharacters.at(0);
				addedZeroCount--;
			}
			outputStringStream << getNextCharacter(actualString[i], uniqueCharacters);
			concatRemainder = true;
			continue;
		}
		outputStringStream << actualString[i];
	}

	string reversedOutputString = outputStringStream.str();
	reverse(reversedOutputString.begin(), reversedOutputString.end());
	cout << reversedOutputString;
}