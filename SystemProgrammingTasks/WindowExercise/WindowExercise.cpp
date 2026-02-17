// WindowExercise.cpp : Defines the entry point for the application.
//

#include "framework.h"
#include "WindowExercise.h"
//#include "WindowExercise.rc"

#define MAX_LOADSTRING 100

// Global Variables:
HINSTANCE hInst;                                // current instance
WCHAR szTitle[MAX_LOADSTRING];                  // The title bar text
WCHAR szWindowClass[MAX_LOADSTRING];            // the main window class name

// Forward declarations of functions included in this code module:
ATOM                MyRegisterClass(HINSTANCE hInstance);
BOOL                InitInstance(HINSTANCE, int);
LRESULT CALLBACK    WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    About(HWND, UINT, WPARAM, LPARAM);

int APIENTRY wWinMain(_In_ HINSTANCE hInstance,
                     _In_opt_ HINSTANCE hPrevInstance,
                     _In_ LPWSTR    lpCmdLine,
                     _In_ int       nCmdShow)
{
    UNREFERENCED_PARAMETER(hPrevInstance);
    UNREFERENCED_PARAMETER(lpCmdLine);

    // TODO: Place code here.

    // Initialize global strings
    LoadStringW(hInstance, IDS_APP_TITLE, szTitle, MAX_LOADSTRING);
    LoadStringW(hInstance, IDC_WINDOWEXERCISE, szWindowClass, MAX_LOADSTRING);
    MyRegisterClass(hInstance);

    // Perform application initialization:
    if (!InitInstance (hInstance, nCmdShow))
    {
        return FALSE;
    }

    HACCEL hAccelTable = LoadAccelerators(hInstance, MAKEINTRESOURCE(IDC_WINDOWEXERCISE));

    MSG msg;

    // Main message loop:
    while (GetMessage(&msg, nullptr, 0, 0))
    {
        if (!TranslateAccelerator(msg.hwnd, hAccelTable, &msg))
        {
            TranslateMessage(&msg);
            DispatchMessage(&msg);
        }
    }

    return (int) msg.wParam;
}



//
//  FUNCTION: MyRegisterClass()
//
//  PURPOSE: Registers the window class.
//
ATOM MyRegisterClass(HINSTANCE hInstance)
{
    WNDCLASSEXW wcex;

    wcex.cbSize = sizeof(WNDCLASSEX);

    wcex.style          = CS_HREDRAW | CS_VREDRAW;
    wcex.lpfnWndProc    = WndProc;
    wcex.cbClsExtra     = 0;
    wcex.cbWndExtra     = 0;
    wcex.hInstance      = hInstance;
    wcex.hIcon          = LoadIcon(hInstance, MAKEINTRESOURCE(IDI_WINDOWEXERCISE));
    wcex.hCursor        = LoadCursor(nullptr, IDC_ARROW);
    wcex.hbrBackground  = (HBRUSH)(COLOR_WINDOW+1);
    wcex.lpszMenuName   = MAKEINTRESOURCEW(IDC_WINDOWEXERCISE);
    wcex.lpszClassName  = szWindowClass;
    wcex.hIconSm        = LoadIcon(wcex.hInstance, MAKEINTRESOURCE(IDI_SMALL));

    return RegisterClassExW(&wcex);
}

//
//   FUNCTION: InitInstance(HINSTANCE, int)
//
//   PURPOSE: Saves instance handle and creates main window
//
//   COMMENTS:
//
//        In this function, we save the instance handle in a global variable and
//        create and display the main program window.
//
BOOL InitInstance(HINSTANCE hInstance, int nCmdShow)
{
   hInst = hInstance; // Store instance handle in our global variable

   HWND hWnd = CreateWindowW(szWindowClass, szTitle, WS_OVERLAPPEDWINDOW,
      CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, nullptr, nullptr, hInstance, nullptr);

   if (!hWnd)
   {
      return FALSE;
   }

   ShowWindow(hWnd, nCmdShow);
   UpdateWindow(hWnd);

   return TRUE;
}

enum Operation {
    Hacked = 0,
    Minimize = 1,
    Maximize = 2,
    Restore = 3,
    Move = 4
};

BOOL CALLBACK HackWindowsFunc(HWND hWnd, LPARAM lParam)
{
    if (!IsWindowVisible(hWnd)) return TRUE;
    TCHAR szText[256];
    szText[0] = 0;
    GetWindowText(hWnd, szText, sizeof(szText));
    lstrcat(szText, L"-hacked!");
    SetWindowText(hWnd, szText);
    return TRUE;
}

BOOL CALLBACK MinimizeWindowsFunc(HWND hWnd, LPARAM lParam)
{
    if (!IsWindowVisible(hWnd)) return TRUE;

    if (!IsIconic(hWnd))
        ShowWindow(hWnd, SW_MINIMIZE);

    return TRUE;
}

BOOL CALLBACK MaximizeWindowsFunc(HWND hWnd, LPARAM lParam)
{
    if (!IsWindowVisible(hWnd)) return TRUE;

    if (!IsIconic(hWnd))
        ShowWindow(hWnd, SW_MAXIMIZE);

    return TRUE;
}

BOOL CALLBACK RestoreWindowsFunc(HWND hWnd, LPARAM lParam)
{
    if (!IsWindowVisible(hWnd)) return TRUE;

    if (IsIconic(hWnd))
        ShowWindow(hWnd, SW_RESTORE);

    return TRUE;
}

int X = 10;
int Y = 10;

BOOL CALLBACK MoveWindowsFunc(HWND hWnd, LPARAM lParam)
{
    if (!IsWindowVisible(hWnd)) return TRUE;

    LPRECT windowRect = LPRECT();

    //etWindowPlacement(hWnd, windowRect);

    //GetWindowRect(hWnd, windowRect);
    //int width = windowRect->right - windowRect->left;
    //int height = windowRect->bottom - windowRect->top;


    if (!IsIconic(hWnd))
        MoveWindow(hWnd, X, Y, 600,
            600, true);

    X += 20;
    Y += 20;

    return TRUE;
}

void Go(Operation operation)
{
    switch (operation)
    {
    case Hacked:
        EnumWindows(HackWindowsFunc, 0);
        break;
    case Minimize:
        EnumWindows(MinimizeWindowsFunc, 0);
        break;
    case Maximize:
        EnumWindows(MaximizeWindowsFunc, 0);
        break;
    case Restore:
        EnumWindows(RestoreWindowsFunc, 0);
        break;
    case Move:
        EnumWindows(MoveWindowsFunc, 0);
    default:
        break;
    }
    
}

//
//  FUNCTION: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  PURPOSE: Processes messages for the main window.
//
//  WM_COMMAND  - process the application menu
//  WM_PAINT    - Paint the main window
//  WM_DESTROY  - post a quit message and return
//
//
LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    switch (message)
    {
    case WM_COMMAND:
        {
            int wmId = LOWORD(wParam);
            // Parse the menu selections:
            switch (wmId)
            {
            case IDM_ABOUT:
                DialogBox(hInst, MAKEINTRESOURCE(IDD_ABOUTBOX), hWnd, About);
                break;
            case IDM_EXIT:
                DestroyWindow(hWnd);
                break;
            case ID_TASKS_HACKED:
                Go(Hacked);
                break;
            case ID_TASKS_MINIMIZE:
                Go(Minimize);
                    break;
            case ID_TASKS_MAXIMIZE:
                Go(Maximize);
                break;
            case ID_TASKS_RESTORE:
                Go(Restore);
                break;
            case ID_TASKS_MOVE:
                Go(Move);
            default:
                return DefWindowProc(hWnd, message, wParam, lParam);
            }
        }
        break;
    case WM_PAINT:
        {
            PAINTSTRUCT ps;
            HDC hdc = BeginPaint(hWnd, &ps);
            // TODO: Add any drawing code that uses hdc here...
            EndPaint(hWnd, &ps);
        }
        break;
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hWnd, message, wParam, lParam);
    }
    return 0;
}

// Message handler for about box.
INT_PTR CALLBACK About(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
    UNREFERENCED_PARAMETER(lParam);
    switch (message)
    {
    case WM_INITDIALOG:
        return (INT_PTR)TRUE;

    case WM_COMMAND:
        if (LOWORD(wParam) == IDOK || LOWORD(wParam) == IDCANCEL)
        {
            EndDialog(hDlg, LOWORD(wParam));
            return (INT_PTR)TRUE;
        }
        break;
    }
    return (INT_PTR)FALSE;
}
