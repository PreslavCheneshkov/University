#include <windows.h>
#include <tchar.h>
#include <stdio.h>


const TCHAR* envVarStrings[] =
{
 TEXT("OS = %OS%"),
 TEXT("PATH = %PATH%"),
 TEXT("HOMEPATH = %HOMEPATH%"),
 TEXT("TEMP = %TEMP%")
};
#define ENV_VAR_STRING_COUNT (sizeof(envVarStrings)/sizeof(TCHAR*))
#define INFO_BUFFER_SIZE 32767
void printError(const TCHAR* msg);

void main()
{
	DWORD i;
	TCHAR infoBuf[INFO_BUFFER_SIZE];
	DWORD bufCharCount = INFO_BUFFER_SIZE;
	// Получава и визуализира името на компютъра
	bufCharCount = INFO_BUFFER_SIZE;
	if (!GetComputerName(infoBuf, &bufCharCount))
		printError(TEXT("GetComputerName"));
	_tprintf(TEXT("\nComputer name: %s"), infoBuf);
	// По аналогичен начин продължавате и с останалите функции


	SYSTEM_INFO sysInfo;// = { 0 }; // = new LPSYSTEM_INFO();


	//ZeroMemory(&sysInfo, sizeof(LPSYSTEM_INFO));
	GetSystemInfo(&sysInfo);

	_tprintf(L"\nProcessor Architecture: " + sysInfo.dwOemId);

	int x = 5;
}

void printError(const TCHAR* msg)
{
	DWORD eNum;
	TCHAR sysMsg[256];
	TCHAR* p;
	eNum = GetLastError();
	FormatMessage(FORMAT_MESSAGE_FROM_SYSTEM |
		FORMAT_MESSAGE_IGNORE_INSERTS,
		NULL, eNum,
		MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),
		sysMsg, 256, NULL);
	// Trim the end of the line and terminate it with a null
	p = sysMsg;
	while ((*p > 31) || (*p == 9))
		++p;
	do { *p-- = 0; } while ((p >= sysMsg) &&
		((*p == '.') || (*p < 33)));
	// Display the message
	_tprintf(TEXT("\n\t%s failed with error %d (%s)"), msg, eNum, sysMsg);
}