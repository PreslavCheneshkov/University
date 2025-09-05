#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>
#include <Windows.h>
#include <math.h>
#pragma execution_character_set( "utf-8" )
#pragma warning( disable : 4703 )
#pragma warning( disable : 4996 )

struct BinaryTreeNode
{
    float a;
    int b;
    char c[64];
    int stringLength;
    struct BinaryTreeNode* left;
    struct BinaryTreeNode* right;
};

struct LinkedListNode
{
    float a;
    int b;
    char c[64];
    int stringLength;
    struct LinkedListNode* next;
};

struct LinkedListNode* currentNode;
struct BinaryTreeNode* globalRoot;

void copyCValue(char treeC[64], char linkedListC[64], int stringLength)
{
    for (int i = 0; i < stringLength; i++)
    {
        linkedListC[i] = treeC[i];
    }
}

struct BinaryTreeNode* newNode(float inputA, int inputB, int inputStringLength, char inputC[]) {
    struct BinaryTreeNode* temp = new BinaryTreeNode();
    temp->a = inputA;
    temp->b = inputB;
    temp->stringLength = inputStringLength;
    copyCValue(inputC, temp->c, inputStringLength);
    return temp;
}

struct BinaryTreeNode* insertNode(struct BinaryTreeNode* root, float a, int b, int stringLength, char c[])
{
    if (root == NULL)
        return newNode(a, b, stringLength, c);

    if (root->b == b)
        return root;

    if (root->b < b)
        root->right = insertNode(root->right, a, b, stringLength, c);

    else
        root->left = insertNode(root->left, a, b, stringLength, c);

    return root;
}

void createBinaryTree()
{
    printf("Моля въведете възлите на дървото:\n");
    char buffer[1];
    buffer[0] = '+';
    int i = 0;

    while(buffer[0] == '+')
    {
        float inputA = 0;
        int inputB = 0, inputStringLength = 0;
        char inputC[64];
        printf("Моля въведете данните за %d-ия елемент:\n", i + 1);
        printf("Реално число за 'а': ");
        scanf_s("%f", &inputA);
        printf("Цяло число за 'b': ");
        scanf_s("%i", &inputB);
        printf("Дължина на низ за 'c' (максимална стойност 64): ");
        scanf_s("%i", &inputStringLength);
        printf("Символен низ за 'c': ");
        gets_s(buffer);
        gets_s(inputC);
        printf("\n\n===========================================================================\n\n");

        if (i == 0)
        {
            globalRoot = new BinaryTreeNode();
            globalRoot->a = inputA;
            globalRoot->b = inputB;
            globalRoot->stringLength = inputStringLength;
            copyCValue(inputC, globalRoot->c, inputStringLength);
        }
        else
            globalRoot = insertNode(globalRoot, inputA, inputB, inputStringLength, inputC);

        printf("Ако желаете да въведете още един възел към дървото въведете '+'.\n");
        buffer[0] = _getch();
        i++;
    }
}

void convertBinarySearchTreeToLinkedList(BinaryTreeNode* root)
{
    if (root == NULL)
    {
        return;
    }

    convertBinarySearchTreeToLinkedList(root->left);

    currentNode->a = root->a;
    currentNode->b = root->b;
    currentNode->stringLength = root->stringLength;
    copyCValue(root->c, currentNode->c, root->stringLength);

    currentNode->next = new LinkedListNode();
    currentNode = currentNode->next;

    convertBinarySearchTreeToLinkedList(root->right);
}

// The chosen node is the one with the highest 'b' value, among the nodes whoose 'c' value has a length of 5
void printTheChosenNodePosition(LinkedListNode* head)
{
    bool hasChosenNode = false;
    int chosenNodeIndex = 0;
    int chosenBValue = INT_MIN;
    int index = 0;
    LinkedListNode* currentNode = head;

    // The last node is always the largest, since the BST used the 'b' value
    while (currentNode != NULL)
    {
        if (currentNode->stringLength == 5)
        {
            if (chosenBValue < currentNode->b)
            {
                hasChosenNode = true;
                chosenNodeIndex = index;
                chosenBValue = currentNode->b;
            }
        }
        currentNode = currentNode->next;
        index++;
    }
    if (hasChosenNode)
        printf("Позицията на търсения елемент в едносвързания списък е: %d", chosenNodeIndex + 1);
    else
        printf("Няма елемент, който да удоволетворява условието на задачата.");
}

void saveLinkedListToFile(LinkedListNode* head)
{
    FILE* fileStream; char fileName[255];
    printf("Моля въведете името на файла, в който искате да запазите списъка: "); gets_s(fileName);
    fileStream = fopen(fileName, "wb");
    if (fileStream == NULL) 
    { 
        printf("Грешка при отварянето на файла.\n");
        _getch(); 
        return; 
    }
    if (head == NULL) 
    { 
        printf("Списъка е празен.\n"); 
        _getch(); 
        return; 
    }
    LinkedListNode* tempNode = head;
    while (tempNode != NULL)
    {
        fwrite(tempNode, sizeof(LinkedListNode), 1, fileStream);
        tempNode = tempNode->next;
        printf("||");
    }
    printf("\n");
    fclose(fileStream);
    printf("Успешно записахте съдържанието на списъка във файл! \n"); _getch();
}

struct LinkedListNode* getLinkedListFromFile()
{
    struct LinkedListNode* head = new LinkedListNode();
    FILE* fileStream; char fileName[255];
    printf("Моля въведете името на файла, от който искате да заредите списъка: "); gets_s(fileName);
    
    fileStream = fopen(fileName, "rb");
    if (fileStream == NULL)
    {
        printf("Грешка при отварянето на файла.\n");
        _getch();
        return NULL;
    }

    struct LinkedListNode* currentNode = new LinkedListNode();
    struct LinkedListNode* tempNode = new LinkedListNode();
    struct LinkedListNode* newNode = new LinkedListNode();
    fread(currentNode, sizeof(LinkedListNode), 1, fileStream);
    bool first = true;
    while (!feof(fileStream))
    {
        if (first)
        {
            head->a = currentNode->a;
            head->b = currentNode->b;
            head->stringLength = currentNode->stringLength;
            first = false;
            head->next = tempNode;
            strcpy(head->c, currentNode->c);
        }
        else
        {
            tempNode->a = currentNode->a;
            tempNode->b = currentNode->b;
            tempNode->stringLength = currentNode->stringLength;
            strcpy(tempNode->c, currentNode->c);
            tempNode->next = new LinkedListNode();
            tempNode = tempNode->next;
        }

        fread(currentNode, sizeof(LinkedListNode), 1, fileStream);
    }
    tempNode = NULL;

    return head;
}

bool headIsEmpty;

void printLinkedList(LinkedListNode* head)
{
    if (headIsEmpty)
    {
        printf("Списъка е празен!"); _getch();
        return;
    }
    LinkedListNode* currentNode = head;
    while (currentNode != NULL)
    {
        printf("\n\n--------------------------------------------------------------\n");
        printf("Node -> a: %f", currentNode->a);
        printf("Node -> b: %d", currentNode->b);
        printf("Node -> c: %s", currentNode->c);
        currentNode = currentNode->next;
    }
    _getch();
}

void clearLastNode(LinkedListNode* head)
{
    LinkedListNode* lastPrevious;
    LinkedListNode* previous;
    LinkedListNode* current = head;
    bool hasPrevious = false;
    while (current != NULL)
    {
        if (hasPrevious)
        {
            lastPrevious = previous;
        }
        previous = current;
        current = current->next;
        hasPrevious = true;
    }
    previous->next = NULL;
    previous = NULL;
    lastPrevious->next = NULL;
}

int main()
{
    SetConsoleOutputCP(65001);
    currentNode = new LinkedListNode();
    struct LinkedListNode* head = currentNode;
    headIsEmpty = true;
    char userInput;
    do {
        system("CLS");
        printf("Добре дошли в програмата за преобразуване на бинарно дърво в едносвързан списък!\n");
        printf("Моля изберете следващо действие!\n");
        printf("a => Създайте Бинарно дърво\n");
        printf("b => Превърнете бинарното дърво в единично свързан списък\n");
        printf("c => Отпечатайте поредния номер на елемента в структурата, за който в полето 'b' има най - голяма стойност измежду всички елементи, които в полето 'c' съдържат низ с дължина 5 символа. \n");
        printf("d => Запазете свързания списък във файл. \n");
        printf("e => Заредете свързания списък от файл. \n");
        printf("f => Разгледайте съдържанието на списъка. \n");
        printf("0 => Изход от програмата\n");
        userInput = _getch(); printf("\n");

        switch (userInput)
        {
            case 'a': 
                createBinaryTree(); printf("Успешно създадено бинарно дърво!"); _getch();  break;
            case 'b': 
                convertBinarySearchTreeToLinkedList(globalRoot); 
                clearLastNode(head);
                printf("Успешно създаден едносвързан списък!");
                _getch(); 
                headIsEmpty = false; 
                break;
            case 'c': 
                printTheChosenNodePosition(head); _getch(); break;
            case 'd': 
                saveLinkedListToFile(head); headIsEmpty = false; break;
            case 'e': 
                head = getLinkedListFromFile(); 
                clearLastNode(head); 
                headIsEmpty = false; 
                break;
            case 'f':
                printLinkedList(head); break;
            case '0': 
                return 0;
            default: userInput = _getch(); printf("\n"); break;
        }
    } while (userInput != '0');
}
